package com.paraam.cpeagent.core;

import java.util.ArrayList;

import org.dslforum.cwmp_1_0.Envelope;
import org.dslforum.cwmp_1_0.ID;
import org.dslforum.cwmp_1_0.EventStruct;

public class CPEWorker implements Runnable {
	
	String ip = "192.168.1.50";
	int port  = 8030;
	String acsurl; 
	String requrl;
	int informperiod = 1800;
	String instanceId = "";
	String dumploc;
	String username	= null;
	String passwd = null;
	String authtype	= null;
    String useragent = null;
	String xmlformatter = "";
    
	public static void main(String args[]) {		
		String mgmturl 	= "http://192.168.1.50:8085/ws?wsdl";
		CPEWorker worker = new CPEWorker("192.168.1.50", 8030, mgmturl, "/wsdl", 1800, "/dump/microcell/", null, null, null, "TR069 Simulator/0.7.0", "", String.valueOf(1));
		Thread cpthread = new Thread(worker, "WorkerThread");
		cpthread.start();
	}
	
	public CPEWorker(String ip, int port, String acsurl, String requrl, int informperiod, String dumploc, String username, String passwd, String authtype, String useragent, String xmlformatter, String instanceId) {
		this.ip 		= ip;
		this.port		= port;
		this.acsurl 	= acsurl;
		this.requrl 	= requrl;
		this.dumploc 	= dumploc;
		this.instanceId = instanceId;
		this.username 	= username;
		this.passwd 	= passwd;
		this.authtype 	= authtype;
        this.useragent  = useragent;
        this.xmlformatter = xmlformatter;
		this.informperiod = informperiod;
	}
	
        @Override
	public void run () {
		
		String connreqURL  = "http://" + ip + ":" + port + requrl;
		//System.out.println("ConnectionRequestURL >>>>>> " + connreqURL);
		CpeDBReader confdb = CpeDBReader.readFromGetMessages(dumploc);
		//CpeDBReader confdb = CpeDBReader.readFromGetMessages("D://Paraam//ACS//groovy_src//groovycpe//testfiles//parameters_zyxel2602//");
		//final CpeActions cpeActions = new CpeActions(confdb);
		//System.out.println("Loaded Properties >>>>>>>>> "  + confdb.props.toString());

		String serialNo = ((ConfParameter)confdb.confs.get(confdb.props.getProperty("SerialNumber"))).value;
		((ConfParameter)confdb.confs.get(confdb.props.getProperty("PeriodicInformInterval"))).value = "" + informperiod;
		((ConfParameter)confdb.confs.get(confdb.props.getProperty("ConnectionRequestURL"))).value = connreqURL; // "/wsdl";
		((ConfParameter)confdb.confs.get(confdb.props.getProperty("SerialNumber"))).value = serialNo + (instanceId.equals("") ? "" : ("_" + instanceId));
		((ConfParameter)confdb.confs.get(confdb.props.getProperty("ExternalIPAddress"))).value = ip;
		//((ConfParameter)confdb.confs.get("InternetGatewayDevice.ManagementServer.PeriodicInformInterval")).value = "1800";

        XmlFormatter xmlFmt = null;
        
        if(xmlformatter != null) {
            if(xmlformatter.equals("normal")) {
                xmlFmt = new XmlFormatter();
            }
            else if(xmlformatter.equals("stripdec")) {
                xmlFmt = new XmlFormatter(true);
            }
        }
        
		CPEHttpServer httpserver = new CPEHttpServer(confdb, username, passwd, authtype, useragent, xmlFmt);
		Thread serverthread = new Thread(httpserver, "Http_Server"); 
		serverthread.start();
		
		CPEPeriodicInform periodicInform = new CPEPeriodicInform(confdb, username, passwd, authtype, useragent, xmlFmt);
		Thread informthread = new Thread(periodicInform, "Periodic_Inform");
		informthread.start();
		
		((ConfParameter)confdb.confs.get(confdb.props.getProperty("MgmtServer_URL"))).value = acsurl; // "http://192.168.1.50:8085/ws?wsdl";
		//((ConfParameter)confdb.confs.get("InternetGatewayDevice.ManagementServer.URL")).value = "http://192.168.1.50:8085/ws?wsdl";
		//((ConfParameter)confdb.confs.get("InternetGatewayDevice.DeviceInfo.SerialNumber")).value = "CP0816NT029";
		//((ConfParameter)confdb.confs.get("InternetGatewayDevice.DeviceInfo.SoftwareVersion")).value = "GroovyCPE_FW.1";
		
		ArrayList<EventStruct> eventKeyList = new ArrayList<EventStruct>();
		EventStruct eventStruct = new EventStruct();
		eventStruct.setEventCode("0 BOOTSTRAP");
		eventKeyList.add(eventStruct);
        eventStruct = new EventStruct();
        eventStruct .setEventCode("1 BOOT");
        eventKeyList.add(eventStruct);
        eventStruct = new EventStruct();
        eventStruct .setEventCode("4 VALUE CHANGE");
        eventKeyList.add(eventStruct);
		CpeActions cpeactions = new CpeActions(confdb);
		Envelope informMessage = cpeactions.doInform(eventKeyList);
                
                boolean strangeACS = false;
                
                if (!strangeACS) {
                    ID id = new ID();
                    id.setMustUnderstand(true);
                    String pk = ((ConfParameter)confdb.confs.get(confdb.props.getProperty("ParameterKey"))).value;
                    id.setString(String.format("BS_%s_SIM_TR69_ID", this.instanceId.equals("") ? "0" : this.instanceId));
                    informMessage.getHeader().getObjects().add(id);
                }
                
		CPEClientSession session = new CPEClientSession(cpeactions, username, passwd, authtype, useragent, xmlFmt);
		session.sendInform(informMessage);	
   
	}

}
