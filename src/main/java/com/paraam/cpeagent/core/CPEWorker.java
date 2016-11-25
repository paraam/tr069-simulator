package com.paraam.cpeagent.core;

import java.util.ArrayList;

import org.dslforum.cwmp_1_0.Envelope;
import org.dslforum.cwmp_1_0.EventStruct;

public class CPEWorker implements Runnable {
	
	String ip = "192.168.1.50";
	int port  = 8030;
	String acsurl; 
	String requrl;
	int informperiod = 1800;
	String instanceId = "";
	String dumploc;
	String 	username	= null;
	String 	passwd		= null;
	String 	authtype	= null;
	
	public static void main(String args[]) {		
		String mgmturl 	= "http://192.168.1.50:8085/ws?wsdl";
		CPEWorker worker = new CPEWorker("192.168.1.50", 8030, mgmturl, "/wsdl", 1800, "/dump/microcell/", null, null, null, String.valueOf(1));
		Thread cpthread = new Thread(worker, "WorkerThread");
		cpthread.start();
	}
	
	public CPEWorker(String ip, int port, String acsurl, String requrl, int informperiod, String dumploc, String username, String passwd, String authtype, String instanceId) {
		this.ip 		= ip;
		this.port		= port;
		this.acsurl 	= acsurl;
		this.requrl 	= requrl;
		this.dumploc 	= dumploc;
		this.instanceId = instanceId;
		this.username 	= username;
		this.passwd 	= passwd;
		this.authtype 	= authtype;
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

		CPEHttpServer httpserver = new CPEHttpServer(confdb, username, passwd, authtype);
		Thread serverthread = new Thread(httpserver, "Http_Server"); 
		serverthread.start();
		
		CPEPeriodicInform periodicInform = new CPEPeriodicInform(confdb, username, passwd, authtype);
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
		CpeActions cpeactions = new CpeActions(confdb);
		Envelope informMessage = cpeactions.doInform(eventKeyList);

		CPEClientSession session = new CPEClientSession(cpeactions, username, passwd, authtype);
		session.sendInform(informMessage);	
   
	}

}
