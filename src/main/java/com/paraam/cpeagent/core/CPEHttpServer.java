package com.paraam.cpeagent.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.dslforum.cwmp_1_0.Envelope;
import org.dslforum.cwmp_1_0.EventStruct;
import org.dslforum.cwmp_1_0.ID;

public class CPEHttpServer implements Runnable {

	ServerSocket serverSocket;
	CpeActions cpeActions;
	CpeDBReader confdb;	
	String 	username	= null;
	String 	passwd		= null;
	String 	authtype	= null;
    String  useragent   = null;
    XmlFormatter xmlFmt = null;
	int 	port;

	public CPEHttpServer (CpeDBReader confdb, String username, String passwd, String authtype, String useragent, XmlFormatter xmlFmt) {
		this.confdb = confdb;
		this.username 	= username;
		this.passwd 	= passwd;
		this.authtype 	= authtype;
        this.useragent  = useragent;
        this.xmlFmt = xmlFmt;
	}

	public void run() {
		String reqURL = ((ConfParameter)confdb.confs.get(confdb.props.getProperty("ConnectionRequestURL"))).value;
		//String reqURL = ((ConfParameter)confdb.confs.get("InternetGatewayDevice.ManagementServer.ConnectionRequestURL")).value;
		try {
			System.out.println("Starting CpeConnectionRequestServer" + reqURL);
			this.port 			= new URL(reqURL).getPort();
			this.serverSocket 	= new ServerSocket(port);

			while(true) {			
				if (serverSocket == null) {
					break;
				}
				Socket 			socket 	= serverSocket.accept();		
				BufferedReader 	reader 	= new BufferedReader(new InputStreamReader(socket.getInputStream()));

				String line = null;
				while((line = reader.readLine()) != null) {						
					//System.out.println("Read [" + line + "]");
					if(line.equals("")) {
						break;
					}
				}				

				final OutputStream outputStream = socket.getOutputStream();
				outputStream.write("HTTP/1.1 200 OK".getBytes());
				outputStream.close();
				socket.close();
				//System.out.println ("Closed sockets...now send");

				ArrayList<EventStruct> eventKeyList = new ArrayList<EventStruct>();
				EventStruct eventStruct = new EventStruct();
				eventStruct.setEventCode("6 CONNECTION REQUEST");
				eventKeyList.add(eventStruct);
				CpeActions cpeactions = new CpeActions(confdb);
				Envelope informMessage = cpeactions.doInform(eventKeyList);
				
                        boolean strangeACS = false;
                
                        if (!strangeACS) {
                            ID id = new ID();
                            id.setMustUnderstand(true);
                            String sn = ((ConfParameter)confdb.confs.get(confdb.props.getProperty("SerialNumber"))).value;
                            id.setString(String.format("CR_%s_SIM_TR69_ID", sn));
                            informMessage.getHeader().getObjects().add(id);
                        }
                
				System.out.println("Sending Connection Request Inform Message at " + (new Date()));				

				CPEClientSession session = new CPEClientSession(cpeactions, username, passwd, authtype, useragent, xmlFmt);
				session.sendInform(informMessage);

				//new CpeSession([ informMessage ]).run();
				System.out.println ("...sent stuff");
			}
			//serverSocket.close();				
		} catch(final IOException e) {
			System.out.println( "Failed to bind to port " + port + " " + e.getMessage());
		}	finally {
			try {
				serverSocket.close();
			} catch (IOException e) { 	}	
		}
	}	
}