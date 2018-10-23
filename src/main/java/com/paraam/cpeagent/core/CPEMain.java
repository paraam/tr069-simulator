package com.paraam.cpeagent.core;


public class CPEMain {
	
	public static void main(String args[]) {
		
		String 	ipadr 	= "192.168.1.";
		int 	port  	= 8031;
		int 	startip = 231;		
		String mgmturl 	= "http://192.168.1.50:8085/ws?wsdl";
		for (int i = 0; i < 3; i++) {
			startip = startip + i;
			//CPEWorker worker = new CPEWorker(ipadr+startip, port+i);
			CPEWorker worker = new CPEWorker(ipadr+startip, port+i, mgmturl, "/wsdl", 1800, "/dump/microcell/", null, null, null, "TR068 Simulator/0.7.0", String.valueOf(1));
			Thread cpthread = new Thread(worker, "WorkerThread_"+i);
			cpthread.start();
		}
	}
	
	

}
