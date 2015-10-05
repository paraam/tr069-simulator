package com.paraam.cpeagent.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.dslforum.cwmp_1_0.AccessList;
import org.dslforum.cwmp_1_0.AddObject;
import org.dslforum.cwmp_1_0.AddObjectResponse;
import org.dslforum.cwmp_1_0.Body;
import org.dslforum.cwmp_1_0.DeleteObject;
import org.dslforum.cwmp_1_0.DeleteObjectResponse;
import org.dslforum.cwmp_1_0.DeviceIdStruct;
import org.dslforum.cwmp_1_0.Download;
import org.dslforum.cwmp_1_0.DownloadResponse;
import org.dslforum.cwmp_1_0.Envelope;
import org.dslforum.cwmp_1_0.EventList;
import org.dslforum.cwmp_1_0.EventStruct;
import org.dslforum.cwmp_1_0.FactoryReset;
import org.dslforum.cwmp_1_0.FactoryResetResponse;
import org.dslforum.cwmp_1_0.GetParameterAttributes;
import org.dslforum.cwmp_1_0.GetParameterAttributesResponse;
import org.dslforum.cwmp_1_0.GetParameterNames;
import org.dslforum.cwmp_1_0.GetParameterNamesResponse;
import org.dslforum.cwmp_1_0.GetParameterValues;
import org.dslforum.cwmp_1_0.GetParameterValuesResponse;
import org.dslforum.cwmp_1_0.GetRPCMethodsResponse;
import org.dslforum.cwmp_1_0.Header;
import org.dslforum.cwmp_1_0.ID;
import org.dslforum.cwmp_1_0.Inform;
import org.dslforum.cwmp_1_0.MethodList;
import org.dslforum.cwmp_1_0.NoMoreRequests;
import org.dslforum.cwmp_1_0.ParameterAttributeList;
import org.dslforum.cwmp_1_0.ParameterAttributeStruct;
import org.dslforum.cwmp_1_0.ParameterAttributeStruct.Notification;
import org.dslforum.cwmp_1_0.ParameterInfoList;
import org.dslforum.cwmp_1_0.ParameterInfoStruct;
import org.dslforum.cwmp_1_0.ParameterValueList;
import org.dslforum.cwmp_1_0.ParameterValueStruct;
import org.dslforum.cwmp_1_0.Reboot;
import org.dslforum.cwmp_1_0.RebootResponse;
import org.dslforum.cwmp_1_0.SetParameterAttributes;
import org.dslforum.cwmp_1_0.SetParameterAttributesStruct;
import org.dslforum.cwmp_1_0.SetParameterValues;
import org.dslforum.cwmp_1_0.SetParameterValuesResponse;
import org.dslforum.cwmp_1_0.Upload;
import org.dslforum.cwmp_1_0.UploadResponse;


public class CpeActions {

	CpeDBReader confdb;	

	public static void main(String[] args){
		System.out.println( "Starting CpeConfDB");

		//def c = CpeConfDB.readFromGetMessages('testfiles/parameters_zyxel2602/')	
		CpeDBReader c = new CpeDBReader().readFromGetMessages("D://Paraam//ACS//groovy_src//groovycpe//testfiles//parameters_zyxel2602//");
		System.out.println( " Hashtable >>>>>> " + c.confs.toString());
		System.out.println( " SerialNumber ---->  " + ((ConfParameter)c.confs.get("Device.DeviceInfo.SerialNumber")).value);	
		//c.serialize("test.txt");
		//System.out.println( " " + CpeDBReader.deserialize("test.txt"));
		ArrayList<EventStruct> eventKeyList = new ArrayList<EventStruct>();
		EventStruct eventStruct = new EventStruct();
		eventStruct.setEventCode("1 BOOT");
		eventKeyList.add(eventStruct);
		CpeActions cpeactions = new CpeActions(c);
		Envelope evn = cpeactions.doInform(eventKeyList);
		String str = JibxHelper.marshalObject(evn, "cwmp_1_0");
		System.out.println("" + str);
	}	

	public CpeActions (CpeDBReader confdb) {
		this.confdb = confdb;
	}

	public Envelope doInform(ArrayList eventKeyList) {
		Inform inform = new Inform();
		DeviceIdStruct deviceId = new DeviceIdStruct();
		inform.setDeviceId(deviceId);
		inform.setCurrentTime(new Date());
		deviceId.setManufacturer(((ConfParameter)confdb.confs.get(confdb.props.getProperty("Manufacturer"))).value);
		deviceId.setOUI(((ConfParameter)         confdb.confs.get(confdb.props.getProperty("ManufacturerOUI"))).value);
		deviceId.setSerialNumber(((ConfParameter)confdb.confs.get(confdb.props.getProperty("SerialNumber"))).value);
		deviceId.setProductClass(((ConfParameter)confdb.confs.get(confdb.props.getProperty("ModelName"))).value);
		ParameterValueList pvlist = new ParameterValueList();

		// use a static list, for now
		String[] pList = new String[] {
				confdb.props.getProperty("HardwareVersion"),
				confdb.props.getProperty("ProvisioningCode"),
				confdb.props.getProperty("SoftwareVersion"),
				confdb.props.getProperty("SpecVersion"),		             
				confdb.props.getProperty("DeviceSummary"),
				confdb.props.getProperty("ConnectionRequestURL"),
				confdb.props.getProperty("ParameterKey"),
				confdb.props.getProperty("ExternalIPAddress")
		};
		ArrayList arr = new ArrayList();
		for (int i=0; i < pList.length; i++) {			
			ParameterValueStruct pvstruct = new ParameterValueStruct();
			pvstruct.setName(pList[i]);
			pvstruct.setValue(((ConfParameter)confdb.confs.get(pList[i])).value);			
			arr.add(pvstruct);
		}
		pvlist.setParameterValueStruct(arr);
		inform.setParameterList(pvlist);

		//ArrayList<String> tlist = new ArrayList();
		//tlist.add("1 BOOT");
		EventList eventList = new EventList();
		eventList.setEventStruct(eventKeyList);
		inform.setEvent(eventList);

		return inEnvelope(inform, "00001");
	}
	public Envelope doGetRPCMethods() {
		GetRPCMethodsResponse resp = new GetRPCMethodsResponse();
		MethodList methodList = new MethodList();
		String[] methods = { "GetRPCMethods", "SetParameterValues", "GetParameterValues", "GetParameterNames", 
				"SetParameterAttributes", "GetParameterAttributes", "AddObject", "DeleteObject", 
				"Reboot", "Download", "ScheduleInform", "Upload", "FactoryReset"   };
		methodList.setStrings(methods);
		resp.setMethodList(methodList);
		return inEnvelope(resp, "00001");
	}

	public Envelope doGetParameterValues( GetParameterValues getParameterValues ) {
		ParameterValueList pvl = new ParameterValueList();
		String[] nameList = getParameterValues.getParameterNames().getStrings(); 
		GetParameterValuesResponse valresp = new GetParameterValuesResponse();

		for (int i =0; i < nameList.length; i++) {			
			String paramname = nameList[i];
			if (paramname.endsWith(".")) {
				//System.out.println(" paramname ----> " + paramname);
				HashMap valobj = this.confdb.confs;				
				Iterator it = valobj.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairs = (Map.Entry)it.next();
					String keyname = (String)pairs.getKey() ;
					if (keyname.startsWith(paramname)) {
						Object obj = pairs.getValue();
						if (obj instanceof ConfParameter) {
							ConfParameter cp = (ConfParameter)obj;
							if (cp.value == null) {
								continue;
							}
							ParameterValueStruct pvs = new ParameterValueStruct();
							pvs.setName(cp.name);
							pvs.setValue(cp.value);
							pvl.getParameterValueStruct().add(pvs);
							//System.out.println("Adding Nested --->>>  " + cp.name + " = " + cp.value);
						}
					}			        
				}				
			} else if ( this.confdb.confs.keySet().contains( paramname) ) {
				Object obj = this.confdb.confs.get(nameList[i]);
				if (obj instanceof ConfParameter) {
					ConfParameter cp = (ConfParameter)obj;
					if (cp.value == null) {
						continue;
					}
					ParameterValueStruct pvs = new ParameterValueStruct();
					pvs.setName(cp.name);
					pvs.setValue(cp.value);
					pvl.getParameterValueStruct().add(pvs);
					//System.out.println("Adding Direct --->>>  " + cp.name + " = " + cp.value);
				}
			}
		}
		valresp.setParameterList(pvl);		
		return inEnvelope(valresp, "00001");
	}

	public Envelope doGetParameterNames( GetParameterNames getParameterName ) {

		GetParameterNamesResponse nameresp = new GetParameterNamesResponse();	
		ParameterInfoList pil = new ParameterInfoList();		
		String paramname = getParameterName.getParameterPath();

		if (paramname.endsWith(".")) {
			System.out.println(" paramname ----> " + paramname);
			HashMap valobj = this.confdb.confs;				
			Iterator it = valobj.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry)it.next();
				String keyname = (String)pairs.getKey() ;
				if (keyname.startsWith(paramname)) {
					Object obj = pairs.getValue();
					ConfObject co = (ConfObject)obj;
					ParameterInfoStruct pvs = new ParameterInfoStruct();
					pvs.setName(co.name);
					pvs.setWritable(new Integer(co.writable));
					pil.getParameterInfoStruct().add(pvs);
				}			        
			}				
		} else if ( this.confdb.confs.keySet().contains( paramname) ) {
			Object obj = this.confdb.confs.get(paramname);
			ConfObject co = (ConfObject)obj;
			ParameterInfoStruct pvs = new ParameterInfoStruct();
			pvs.setName(co.name);
			pvs.setWritable(new Integer(co.writable));
			pil.getParameterInfoStruct().add(pvs);
			//System.out.println("Adding Direct --->>>  " + cp.name + " = " + cp.value);
		}
		nameresp.setParameterList(pil);		
		return inEnvelope(nameresp, "00001");
	}	

	public Envelope doSetParameterValues( SetParameterValues setParameterValues ) {
		ParameterValueList pvl = new ParameterValueList();
		ArrayList<ParameterValueStruct> nameList = setParameterValues.getParameterList().getParameterValueStruct();
		SetParameterValuesResponse valresp = new SetParameterValuesResponse();		
		for (int i =0; i < nameList.size(); i++) {			
			ParameterValueStruct pvs = nameList.get(i);
			if ( this.confdb.confs.keySet().contains( pvs.getName()) ) {
				Object obj = this.confdb.confs.get(pvs.getName());
				if (obj instanceof ConfParameter) {
					ConfParameter cp = (ConfParameter)obj;
					cp.value = pvs.getValue();
					System.out.println("Setting Value --->>>  " + cp.name + " = " + cp.value);
				}
			}
		}
		valresp.setStatus(org.dslforum.cwmp_1_0.SetParameterValuesResponse.Status._0);
		return inEnvelope(valresp, "00001");
	}

	public Envelope doGetParameterAttributes( GetParameterAttributes getParameterAttributes ) {		

		String[] nameList = getParameterAttributes.getParameterNames().getStrings();
		GetParameterAttributesResponse valresp = new GetParameterAttributesResponse();
		ParameterAttributeList pal 	= new ParameterAttributeList();
		for (int i =0; i < nameList.length; i++) {
			String paramname = nameList[i];
			if (paramname.endsWith(".")) {
				//System.out.println(" paramname ----> " + paramname);
				HashMap valobj = this.confdb.confs;				
				Iterator it = valobj.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairs = (Map.Entry)it.next();
					String keyname = (String)pairs.getKey() ;
					if (keyname.startsWith(paramname)) {
						Object obj = pairs.getValue();
						if (obj instanceof ConfParameter) {
							ConfParameter cp = (ConfParameter)obj;
							ParameterAttributeStruct pas = new ParameterAttributeStruct();
							pas.setName(cp.name);
							pas.setNotification(Notification.convert(cp.notification));
							AccessList accessList = new AccessList();
							accessList.setStrings(cp.accessList.split(","));
							pas.setAccessList(accessList);
							pal.getParameterAttributeStruct().add(pas);
							//System.out.println("Adding Nested --->>>  " + cp.name + " = " + cp.value);
						}
					}			        
				}				
			} else if ( this.confdb.confs.keySet().contains( paramname) ) {
				Object obj = this.confdb.confs.get(nameList[i]);
				if (obj instanceof ConfParameter) {
					ConfParameter cp = (ConfParameter)obj;
					ParameterAttributeStruct pas = new ParameterAttributeStruct();
					pas.setName(cp.name);
					pas.setNotification(Notification.convert(cp.notification));
					AccessList accessList = new AccessList();
					accessList.setStrings(cp.accessList.split(","));
					pas.setAccessList(accessList);
					pal.getParameterAttributeStruct().add(pas);
					//System.out.println("Adding Direct --->>>  " + cp.name + " = " + cp.value);
				}
			}
		}
		valresp.setParameterList(pal);
		return inEnvelope(valresp, "00001");

	}


	public Envelope doSetParameterAttributes( SetParameterAttributes setParameterAttributes ) {
		ParameterValueList pvl = new ParameterValueList();
		ArrayList<SetParameterAttributesStruct> nameList = setParameterAttributes.getParameterList().getSetParameterAttributesStruct();
		SetParameterValuesResponse valresp = new SetParameterValuesResponse();		
		for (int i =0; i < nameList.size(); i++) {			
			SetParameterAttributesStruct spvs = nameList.get(i);
			if ( this.confdb.confs.keySet().contains( spvs.getName()) ) {
				Object obj = this.confdb.confs.get(spvs.getName());
				if (obj instanceof ConfParameter) {
					ConfParameter cp 	= (ConfParameter)obj;
					String[] aclist  	= spvs.getAccessList().getStrings();
					if (spvs.isNotificationChange()) {
						cp.notification 	= spvs.getNotification().toString();
					}
					if (spvs.isAccessListChange()) {
						cp.accessList 		= Arrays.toString(aclist);
					}
					System.out.println("Setting Value --->>>  " + cp.notification + " = " + cp.accessList);
				}
			}
		}
		valresp.setStatus(org.dslforum.cwmp_1_0.SetParameterValuesResponse.Status._0);
		return inEnvelope(valresp, "00001");
	}

	public Envelope doAddObject(AddObject addObject) {
		AddObjectResponse respobj = new AddObjectResponse();
		Random rn = new Random();
		respobj.setInstanceNumber(rn.nextInt());
		respobj.setStatus(org.dslforum.cwmp_1_0.AddObjectResponse.Status._0);
		return inEnvelope( respobj, "00001" );
	}

	public Envelope doDeleteObject(DeleteObject deleteObject) {
		DeleteObjectResponse respobj = new DeleteObjectResponse();
		respobj.setStatus(org.dslforum.cwmp_1_0.DeleteObjectResponse.Status._0);
		return inEnvelope(respobj, "00001" );
	}
	
	public Envelope doReboot(Reboot reboot) {
		RebootResponse respobj = new RebootResponse();
		return inEnvelope(respobj, "00001" );
	}
	
	public Envelope doDownload(Download download) {
		DownloadResponse respobj = new DownloadResponse();
		respobj.setStartTime(new Date());
		CPEDownloadServer cds = new CPEDownloadServer(download.getURL());
		Thread cdsthread = new Thread(cds, "DownloadThread");
		cdsthread.start();
		respobj.setStatus(org.dslforum.cwmp_1_0.DownloadResponse.Status._0);
		respobj.setCompleteTime(new Date());
		return inEnvelope( respobj, "00001");
	}

	public Envelope doUpload(Upload upload) {
		UploadResponse respobj = new UploadResponse();
		respobj.setStartTime(new Date());
		respobj.setStatus(org.dslforum.cwmp_1_0.UploadResponse.Status._0);
		respobj.setCompleteTime(new Date());
		return inEnvelope( respobj, "00001");
	}

	public Envelope doFactoryReset(FactoryReset reboot) {
		FactoryResetResponse respobj = new FactoryResetResponse();
		return inEnvelope(respobj, "00001" );
	}
	
	/*
	def doGetParameterAttributes( GetParameterAttributes getParameterAttributes ){		

		def nameList = getParameterAttributes.parameterNames.any
		def attrs = confdb.confs.keySet().findAll{ confkey ->  
				nameList.any{confkey.startsWith(it)} &&
				confdb.confs[confkey] instanceof ConfParameter &&
				confdb.confs[confkey].notification != null				
			}.collect{
				new ParameterAttributeStruct(
						name: it, 
						notification: Integer.parseInt(confdb.confs[it].notification),
						accessList: new AccessList(any: confdb.confs[it].accessList.split(","))  ) 
			}		
		return inEnvelope(new GetParameterAttributesResponse(parameterList: new ParameterAttributeList(any: attrs)))
	}

	def doSetParameterAttributes(SetParameterAttributes setParameterAttributes){
		// add error handling
		setParameterAttributes.parameterList.getAny().each{
			def conf = confdb.confs[it.name]			
			conf.accessList = it.accessList.getAny().join(",")
			conf.notification = it.notification.toString()
		}		
		return inEnvelope(new SetParameterValuesResponse(status: 0))
	}
	 */
	
	/*public static Envelope inEnvelope(Object cwmpObject) {
		Envelope envlope = new Envelope();
		Body body = new Body();
		ArrayList bodyobj = new ArrayList();
		bodyobj.add(cwmpObject);
		body.setObjects(bodyobj);
		envlope.setBody(body);
		return envlope;
	}
*/
	public static Envelope inEnvelope(Object cwmpObject, String headerID) {
		Envelope envlope = new Envelope();
		Body body = new Body();
		Header header = new Header();
		ID id = new ID();
		id.setMustUnderstand(true);
		id.setString(headerID);	
//                NoMoreRequests noMore = new NoMoreRequests();
//                noMore.setString("0");
		ArrayList headobj = new ArrayList();
		headobj.add(id);	
//                headobj.add(noMore);
		header.setObjects(headobj);
		ArrayList bodyobj = new ArrayList();
		bodyobj.add(cwmpObject);
		body.setObjects(bodyobj);		
		envlope.setHeader(header);
		envlope.setBody(body);
		return envlope;
	}

	/*def inEnvelope( cwmpObject, headerID ){		
		ID id = new ID(value: headerID, mustUnderstand: Boolean.TRUE )
		Header header = new Header(any: [ id ])
		Envelope envelope = new Envelope(body: new Body(any: [cwmpObject]), header: header);		
		return envelope
	}*/
}