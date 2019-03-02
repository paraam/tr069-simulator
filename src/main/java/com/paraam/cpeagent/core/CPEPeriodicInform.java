package com.paraam.cpeagent.core;

import java.util.ArrayList;
import java.util.Date;

import org.dslforum.cwmp_1_0.Envelope;
import org.dslforum.cwmp_1_0.EventStruct;

public class CPEPeriodicInform implements Runnable {
	
	CpeActions cpeActions;
	CpeDBReader confdb;	
	String 	username	= null;
	String 	passwd		= null;
	String 	authtype	= null;
    String  useragent   = null;
	XmlFormatter xmlformatter = null;
    
	public CPEPeriodicInform (CpeDBReader confdb, String username, String passwd, String authtype, String useragent, XmlFormatter xmlformatter) {		
		this.confdb = confdb;
        this.username = username;
        this.passwd = passwd;
        this.authtype = authtype;
        this.useragent = useragent;
        this.xmlformatter = xmlformatter;
	}
	
	public void run() {
		try {			
			while(true) {				
				int sleepInterval = Integer.parseInt(((ConfParameter)confdb.confs.get(confdb.props.getProperty("PeriodicInformInterval"))).value);
				//int sleepInterval = Integer.parseInt(((ConfParameter)confdb.confs.get("InternetGatewayDevice.ManagementServer.PeriodicInformInterval")).value);
				Thread.sleep(sleepInterval * 1000);
				
				ArrayList<EventStruct> eventKeyList = new ArrayList<EventStruct>();
				EventStruct eventStruct = new EventStruct();
				eventStruct.setEventCode("2 PERIODIC");
				eventKeyList.add(eventStruct);
				CpeActions cpeactions = new CpeActions(confdb);
				Envelope informMessage = cpeactions.doInform(eventKeyList);

				System.out.println("Sending Periodic Message at " + (new Date()));				
				CPEClientSession session = new CPEClientSession(cpeactions, username, passwd, authtype, useragent, xmlformatter);
				session.sendInform(informMessage, xmlformatter);
				
			}						
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
