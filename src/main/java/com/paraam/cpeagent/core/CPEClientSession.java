package com.paraam.cpeagent.core;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONObject;
import org.dslforum.cwmp_1_0.ID;
import org.dslforum.cwmp_1_0.AddObject;
import org.dslforum.cwmp_1_0.DeleteObject;
import org.dslforum.cwmp_1_0.Download;
import org.dslforum.cwmp_1_0.Envelope;
import org.dslforum.cwmp_1_0.EventStruct;
import org.dslforum.cwmp_1_0.FactoryReset;
import org.dslforum.cwmp_1_0.GetParameterAttributes;
import org.dslforum.cwmp_1_0.GetParameterNames;
import org.dslforum.cwmp_1_0.GetParameterValues;
import org.dslforum.cwmp_1_0.InformResponse;
import org.dslforum.cwmp_1_0.Reboot;
import org.dslforum.cwmp_1_0.ScheduleInform;
import org.dslforum.cwmp_1_0.SetParameterAttributes;
import org.dslforum.cwmp_1_0.SetParameterValues;
import org.dslforum.cwmp_1_0.Upload;

import com.paraam.cpeagent.api.ResourceAPI;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.HTTPDigestAuthFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dslforum.cwmp_1_0.ParameterNames;

public class CPEClientSession {	
	
	String 		cwmpver 	= "cwmp_1_0";
	CpeActions 	cpeActions 	= null;
	WebResource service 	= null;
	String username 	= null; 
	String passwd		= null; 
	String authtype		= null;
    String useragent        = null;
    XmlFormatter xmlFmt = null;
        
    List<NewCookie> cookies;
	
	public static void main(String[] args) {
		ClientConfig 	config 			= new DefaultClientConfig();
		Client 			client 			= Client.create(config);
		WebResource 	service 		= client.resource(getBaseURI());
		JSONObject 		data 			= new JSONObject();
		JSONObject 		status 			= new JSONObject();		
		String			filefolder  	= "//dump//microcell//";
		CpeDBReader 	confdb 			= CpeDBReader.readFromGetMessages(filefolder);
		CpeActions 		cpeAction 		= new CpeActions(confdb);	
		
		ArrayList<EventStruct> eventKeyList = new ArrayList<EventStruct>();
		EventStruct eventStruct = new EventStruct();
		eventStruct.setEventCode("1 BOOT");
		eventKeyList.add(eventStruct);
		CpeActions cpeactions = new CpeActions(confdb);
		Envelope evn = cpeactions.doInform(eventKeyList);
		
	}
	
	public CPEClientSession (CpeActions cpeActions, String username, String passwd, String authtype, String useragent, XmlFormatter xmlFmt) {
		this.cpeActions = cpeActions;		
		this.username 	= username;
		this.passwd 	= passwd;
		this.authtype 	= authtype;
        this.useragent  = useragent;
        this.xmlFmt = xmlFmt;
        
		String urlstr 	= ((ConfParameter)this.cpeActions.confdb.confs.get(this.cpeActions.confdb.props.getProperty("MgmtServer_URL"))).value;  //"http://192.168.1.50:8085/ws?wsdl";
		System.out.println("ACS MGMT URL -------> " + urlstr);
		service = ResourceAPI.getInstance().getResourceAPI(urlstr);		
		if (username != null && passwd != null) {
			if (authtype.equalsIgnoreCase("digest")) {
			    service.addFilter(new HTTPDigestAuthFilter(username, passwd));
            } else if (authtype.equalsIgnoreCase("basic")) {
                service.addFilter(new HTTPBasicAuthFilter(username, passwd));
			} // else use no authentication
			//System.out.println("==========================> " + username + " " + passwd);
		}
		//System.out.println(" 2nd time ==============> " + username + " " + passwd);
	}	
	
	public void sendInform (Envelope envelope) {
        String informBody;
		if (this.xmlFmt == null)
            informBody = JibxHelper.marshalObject(envelope, "cwmp_1_0");
        else
            informBody = this.xmlFmt.format(JibxHelper.marshalObject(envelope, "cwmp_1_0"));
        
		//String informBody  = getInformString();
		//System.out.println("Sending informBody >>>>> " );
		this.cookies = new ArrayList<NewCookie>();
		ACSResponse acsresp 	= sendData (service, informBody);		
		Envelope classobj 		= (Envelope)JibxHelper.unmarshalMessage(acsresp.getResponse(), cwmpver);		
		InformResponse iresp 	= (InformResponse)classobj.getBody().getObjects().get(0);		
		//System.out.println("Received InformResponse Max Envelopes ===== " + iresp.getMaxEnvelopes());
        this.cookies = acsresp.getCookies();
		
		//System.out.println("Sending empty request =====>>>>>>>> " );
		acsresp = sendData (service, "");	
		//System.out.println("Response for empty request <<<<<<===== " + response);
		
		handleACSRequest (acsresp);
		
                String serial = ((ConfParameter)this.cpeActions.confdb.confs.get(this.cpeActions.confdb.props.getProperty("SerialNumber"))).value;
                this.dumpCurrentConfiguration(this.cpeActions.confdb.getDumpLocation(), serial);
	}
	
	public void handleACSRequest (ACSResponse acsresp) {
		String response = acsresp.getResponse();
		if (response != null && response.length() > 0 ) {				
			Envelope	envReq 		= (Envelope)JibxHelper.unmarshalMessage(response, cwmpver);
            Object      idObj;
            try {
                idObj = envReq.getHeader().getObjects().get(0);
            }
            catch(IndexOutOfBoundsException oob) {
                idObj = new ID();
                ((ID)idObj).setMustUnderstand(true);
                String sn = ((ConfParameter)cpeActions.confdb.confs.get(cpeActions.confdb.props.getProperty("SerialNumber"))).value;
                ((ID)idObj).setString(String.format("NOID_%s_SIM_TR69_ID", sn));
            }
			Object  	reqobj 		= envReq.getBody().getObjects().get(0);
			
			System.out.println("Has New Request by ClassName ===== " + reqobj.getClass().getName());			
			Envelope 	envResp 	= getClientResponse (cpeActions, idObj, reqobj);		
			String 		respBody;
            if (this.xmlFmt == null)
                respBody = JibxHelper.marshalObject(envResp, "cwmp_1_0");
            else
                respBody = this.xmlFmt.format(JibxHelper.marshalObject(envResp, "cwmp_1_0"));
            
			//System.out.println("Sending Client response =====>>>>>>>> " + respBody );
			ACSResponse newresp 	= sendData (service, respBody);			
			//System.out.println("Response for new request <<<<<<===== " + newresp);

			handleACSRequest (newresp);
			
		}		
		//System.out.println(data.toString()) ;		
		
        }
	
	private ACSResponse sendData (WebResource service, String reqString) {
		
		Builder builder = service
            .accept(MediaType.APPLICATION_XML)
		    .type(MediaType.APPLICATION_XML)
//                .accept(MediaType.TEXT_XML)
//                .type(MediaType.TEXT_XML)
            .header("User-Agent", this.useragent);
		for ( NewCookie c : cookies ) {
		    //System.out.println( "Request Setting cookie  ======================== " + c.getName() + " = " + c.getValue() );
		   builder = builder.cookie( c );
		}

            try {
                // wait a bit
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CPEClientSession.class.getName()).log(Level.SEVERE, null, ex);
            }
                
		ClientResponse 	response 	= builder.post(ClientResponse.class, reqString);
        ACSResponse 	acsresp 	= new ACSResponse();
		acsresp.setCookies(response.getCookies());
		acsresp.setHeaders(response.getHeaders());		
                //if (response.getClientResponseStatus() == ClientResponse.Status.OK) {
                //if (response.hasEntity()) {
                if (response.getClientResponseStatus() == ClientResponse.Status.OK) {
                    String 		rdata 	= response.getEntity(String.class);		
                    acsresp.setResponse(rdata);
                    System.out.println(rdata);
                } else {
                    System.out.println(response.getClientResponseStatus());
                }		
		return acsresp;
	}
	
	public Envelope getClientResponse (CpeActions cpeactions, Object idobject, Object reqobject) {		
		Envelope toreturn 	= null;
		String reqname 		= reqobject.getClass().getSimpleName();
		Integer switchId 	= ClientUtil.reqProps.get(reqname);
		
		switch (switchId) {
		
		case ClientUtil.GET_RPC_METHODS_ID:
			toreturn = cpeactions.doGetRPCMethods();
			break;
			
		case ClientUtil.GET_PARAMETER_VALUES_ID:			
			GetParameterValues gpv = (GetParameterValues)reqobject;
			toreturn = cpeactions.doGetParameterValues(gpv);
			break;
			
		case ClientUtil.SET_PARAMETER_VALUES_ID:
			SetParameterValues spv = (SetParameterValues)reqobject;
			toreturn = cpeactions.doSetParameterValues(spv);
			break;
			
		case ClientUtil.GET_PARAMETER_NAMES_ID:
			GetParameterNames gpn = (GetParameterNames)reqobject;
			toreturn = cpeactions.doGetParameterNames(gpn);
			break;
			
		case ClientUtil.GET_PARAMETER_ATTRIBUTES_ID:
			GetParameterAttributes gpa = (GetParameterAttributes)reqobject;
			toreturn = cpeactions.doGetParameterAttributes(gpa);
			break;
			
		case ClientUtil.SET_PARAMETER_ATTRIBUTES_ID:
			SetParameterAttributes spa = (SetParameterAttributes)reqobject;
			toreturn = cpeactions.doSetParameterAttributes(spa);
			break;
			
		case ClientUtil.ADD_OBJECT_ID:
			AddObject ao = (AddObject)reqobject;
			toreturn = cpeactions.doAddObject(ao);
			break;
			
		case ClientUtil.DELETE_OBJECT_ID:
			DeleteObject dobj = (DeleteObject)reqobject;
			toreturn = cpeactions.doDeleteObject(dobj);
			break;

		case ClientUtil.REBOOT_ID:
			Reboot reboot 	= (Reboot)reqobject;
			toreturn 		= cpeactions.doReboot(reboot);
			break;

		case ClientUtil.DOWNLOAD_ID:
			Download dwobj 	= (Download)reqobject;
			toreturn 		= cpeactions.doDownload(dwobj);
			break;
			
		case ClientUtil.SCHEDULE_INFORM_ID:
			ScheduleInform schInform 	= (ScheduleInform)reqobject;
			int 			delaysec 	= schInform.getDelaySeconds();
			SchedulerInform siclass 	= new SchedulerInform(delaysec, username, passwd, authtype, useragent, xmlFmt);
			Thread 	sithread 			= new Thread (siclass, "SchInformThread");
			sithread.start();			
			break;
			
		case ClientUtil.UPLOAD_ID:
			Upload upload 	= (Upload)reqobject;
			toreturn 		= cpeactions.doUpload(upload);
			break;
			
		case ClientUtil.FACTORY_RESET_ID:
			FactoryReset factreset 	= (FactoryReset)reqobject;
			toreturn 		= cpeactions.doFactoryReset(factreset);
			break;

		}
                
                boolean strangeACS = false;
                
                if(!strangeACS) {
                    if (toreturn != null) {
                        toreturn.getHeader().getObjects().add((ID)idobject);
                    }
                }
                
		return toreturn;
	}
	
	
        public void dumpCurrentConfiguration(String dumploc, String serial) {
                try {
                        GetParameterNames allParameterNames = new GetParameterNames();
                        allParameterNames.setParameterPath(cpeActions.confdb.props.getProperty("RootNode"));
                        Envelope envNames = cpeActions.doGetParameterNames(allParameterNames);
                        String 		namesDump 	= JibxHelper.marshalObject(envNames, "cwmp_1_0");
						CpeDBReader.serialize(dumploc + "getnames_" + serial + ".xml", new XmlFormatter().format(namesDump));

                        ParameterNames pn = new ParameterNames();
                        Set<String> namesSet = new HashSet<String>();
                        namesSet.add(cpeActions.confdb.props.getProperty("RootNode"));
                        pn.setStrings(namesSet.toArray(new String[namesSet.size()]));
                        
                        GetParameterValues allParameterValues = new GetParameterValues();
                        allParameterValues.setParameterNames(pn);
                        Envelope 	envValues	= cpeActions.doGetParameterValues(allParameterValues, false, cpeActions.confdb.confs);		
                        String 		valuesDump 	= JibxHelper.marshalObject(envValues, "cwmp_1_0");
                        CpeDBReader.serialize(dumploc + "getvalues_" + serial + ".xml", new XmlFormatter().format(valuesDump));
                        
                        GetParameterValues learnedParameterValues = new GetParameterValues();
                        learnedParameterValues.setParameterNames(pn);
                        Envelope 	envLearnedValues	= cpeActions.doGetParameterValues(learnedParameterValues, false, cpeActions.confdb.learns);		
                        String 		learnedValuesDump 	= JibxHelper.marshalObject(envLearnedValues, "cwmp_1_0");
                        CpeDBReader.serialize(dumploc + "learnedvalues_" + serial + ".xml", new XmlFormatter().format(learnedValuesDump));
                } catch (IOException ioex) {
                        ioex.printStackTrace();
                }
        }
                
                
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://192.168.1.50:8085/ws?wsdl").build();
	}	
	
	/*private static String getHeader() {
		return "<soap:Header><cwmp:ID soap:mustUnderstand=\"1\">100110</cwmp:ID></soap:Header>";
	}
	
	private static String envString () {
		return "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:cwmp=\"urn:dslforum-org:cwmp-1-0\" " +
				"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"></soap:Envelope>";
	}
	
	private static String getInformString() {
		String informString  = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:cwmp=\"urn:dslforum-org:cwmp-1-0\" " +
				"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
				"<soap:Header><cwmp:ID soap:mustUnderstand=\"1\">100110</cwmp:ID></soap:Header><soap:Body>" + 
				"<cwmp:Inform><DeviceId><Manufacturer>Conexant</Manufacturer><OUI>002615</OUI><ProductClass>ADSL2+ IAD</ProductClass>" +
				"<SerialNumber>00261559a496</SerialNumber></DeviceId><Event soapenc:arrayType=\"cwmp:EventStruct[1]\">" +
				"<EventStruct><EventCode>4 VALUE CHANGE</EventCode><CommandKey></CommandKey></EventStruct></Event>" +
				"<MaxEnvelopes>1</MaxEnvelopes><CurrentTime>1970-01-03T03:15:45Z</CurrentTime><RetryCount>0</RetryCount>" +
				"<ParameterList soapenc:arrayType=\"cwmp:ParameterValueStruct[9]\"><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.DeviceInfo.SpecVersion</Name><Value xsi:type=\"xsd:string\">1.0</Value>" +
				"</ParameterValueStruct><ParameterValueStruct><Name>InternetGatewayDevice.DeviceInfo.HardwareVersion</Name>" +
				"<Value xsi:type=\"xsd:string\">Solos 4615 RD / Solos 461x CSP v1.0</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.DeviceInfo.SoftwareVersion</Name><Value xsi:type=\"xsd:string\">10.4.3.12.12</Value>" +
				"</ParameterValueStruct><ParameterValueStruct><Name>InternetGatewayDevice.DeviceInfo.ProvisioningCode</Name>" +
				"<Value xsi:type=\"xsd:string\"></Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.ManagementServer.ConnectionRequestURL</Name>" +
				"<Value xsi:type=\"xsd:string\">http://192.168.1.1:7547/wsdl</Value></ParameterValueStruct>" +
				"<ParameterValueStruct><Name>InternetGatewayDevice.ManagementServer.ParameterKey</Name>" +
				"<Value xsi:type=\"xsd:string\">222333</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.DeviceSummary</Name><Value xsi:type=\"xsd:string\">" +
				"InternetGatewayDevice:1.2[](X_002615_Baseline:1,X_002615_EthernetLAN:1,X_002615_WiFiLAN:1,X_002615_ADSLWAN:1,IPPing:1)," +
				"VoiceService:1.0[1](X_002615_Endpoint:1,X_002615_SIPEndpoint:1)</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.WANDevice.1.WANConnectionDevice.7.WANPPPConnection.1.ExternalIPAddress</Name>" +
				"<Value xsi:type=\"xsd:string\">117.202.132.137</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.ManagementServer.PeriodicInformInterval</Name>" +
				"<Value xsi:type=\"xsd:string\">1800</Value></ParameterValueStruct></ParameterList></cwmp:Inform></soap:Body></soap:Envelope>";	
		return informString;
	}
	
	
	private static Element getInformBody() {
		Element node = null;
		String informString  = "<soap:Body><cwmp:Inform><DeviceId><Manufacturer>Conexant</Manufacturer><OUI>002615</OUI><ProductClass>ADSL2+ IAD</ProductClass>" +
				"<SerialNumber>00261559a496</SerialNumber></DeviceId><Event soapenc:arrayType=\"cwmp:EventStruct[1]\">" +
				"<EventStruct><EventCode>4 VALUE CHANGE</EventCode><CommandKey></CommandKey></EventStruct></Event>" +
				"<MaxEnvelopes>1</MaxEnvelopes><CurrentTime>1970-01-03T03:15:45Z</CurrentTime><RetryCount>0</RetryCount>" +
				"<ParameterList soapenc:arrayType=\"cwmp:ParameterValueStruct[9]\"><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.DeviceInfo.SpecVersion</Name><Value xsi:type=\"xsd:string\">1.0</Value>" +
				"</ParameterValueStruct><ParameterValueStruct><Name>InternetGatewayDevice.DeviceInfo.HardwareVersion</Name>" +
				"<Value xsi:type=\"xsd:string\">Solos 4615 RD / Solos 461x CSP v1.0</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.DeviceInfo.SoftwareVersion</Name><Value xsi:type=\"xsd:string\">10.4.3.12.12</Value>" +
				"</ParameterValueStruct><ParameterValueStruct><Name>InternetGatewayDevice.DeviceInfo.ProvisioningCode</Name>" +
				"<Value xsi:type=\"xsd:string\"></Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.ManagementServer.ConnectionRequestURL</Name>" +
				"<Value xsi:type=\"xsd:string\">http://192.168.1.1:7547/wsdl</Value></ParameterValueStruct>" +
				"<ParameterValueStruct><Name>InternetGatewayDevice.ManagementServer.ParameterKey</Name>" +
				"<Value xsi:type=\"xsd:string\">222333</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.DeviceSummary</Name><Value xsi:type=\"xsd:string\">" +
				"InternetGatewayDevice:1.2[](X_002615_Baseline:1,X_002615_EthernetLAN:1,X_002615_WiFiLAN:1,X_002615_ADSLWAN:1,IPPing:1)," +
				"VoiceService:1.0[1](X_002615_Endpoint:1,X_002615_SIPEndpoint:1)</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.WANDevice.1.WANConnectionDevice.7.WANPPPConnection.1.ExternalIPAddress</Name>" +
				"<Value xsi:type=\"xsd:string\">117.202.132.137</Value></ParameterValueStruct><ParameterValueStruct>" +
				"<Name>InternetGatewayDevice.ManagementServer.PeriodicInformInterval</Name>" +
				"<Value xsi:type=\"xsd:string\">1800</Value></ParameterValueStruct></ParameterList></cwmp:Inform></soap:Body>";
		
		try {
		node =  DocumentBuilderFactory
			    .newInstance()
			    .newDocumentBuilder()
			    .parse(new ByteArrayInputStream(informString.getBytes()))
			    .getDocumentElement();

		} catch (Exception e) {
			e.printStackTrace();
		}	
		return node;
	}*/
	
	
	public class SchedulerInform implements Runnable {		
		int delaysecs;
		String username 	= null; 
		String passwd		= null; 
		String authtype		= null;
        String useragent        = null;
        XmlFormatter xmlFmt = null;

		public SchedulerInform (int delaysecs, String username, String passwd, String authtype, String useragent, XmlFormatter xmlFmt) {
			this.delaysecs = delaysecs;
			this.username 	= username;
			this.passwd 	= passwd;
			this.authtype 	= authtype;
            this.useragent  = useragent;
            this.xmlFmt = xmlFmt;
		}

		public void run () {
			try {
				Thread.sleep(delaysecs * 1000);				
				ArrayList<EventStruct> eventKeyList = new ArrayList<EventStruct>();
				EventStruct eventStruct = new EventStruct();
				eventStruct.setEventCode("3 SCHEDULED");
				eventKeyList.add(eventStruct);
				Envelope informMessage = cpeActions.doInform(eventKeyList);

				System.out.println("Sending ScheduleInform Message at " + (new Date()));
				CPEClientSession session = new CPEClientSession(cpeActions, username, passwd, authtype, useragent, xmlFmt);
				session.sendInform(informMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
