package com.paraam.cpeagent;

import java.io.File;
import java.util.ArrayList;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.paraam.cpeagent.core.CPEUtil;
import com.paraam.cpeagent.core.CPEWorker;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;


public class SimulatorService extends Service<SimulatorConfiguration> {

	public static void main(String[] args) throws Exception {
		try {
		new SimulatorService().run(args);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}


	@Override
	public void initialize(Bootstrap<SimulatorConfiguration> bootstrap) {
		bootstrap.setName("TR069-Simulator");
		bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/dashboard/") );
		bootstrap.addBundle(new ViewBundle());
		bootstrap.addBundle(GuiceBundle.newBuilder()
				.addModule(new SimulatorModule())
				.enableAutoConfig(getClass().getPackage().getName())
				.build()
				);


	}

	@Override
	public void run(SimulatorConfiguration configuration, final Environment environment) {

		String currentDir = System.getProperty("user.dir");
		String filepath = currentDir + File.separator + "agent.csv"; 
		//System.out.println("Current Filepath Checking >>>> " + filepath );
		File userfile = new File (filepath);
		if (!userfile.exists()) {
			filepath = "/conf/agent.csv";
		}
		//System.out.println(" Loaded Agent Filepath:  " + filepath);
		CPEUtil util = new CPEUtil();
		ArrayList<String> csvlist = util.parseFile(filepath);
		int csvlen = csvlist.size();
		int threadcnt = 1;
		String ipadr = "";
		for (int f = 0; f < csvlen; f++ ) {
			String csvline 	= csvlist.get(f);			
			//System.out.println("CSV Line   >>>>>>>>>   " + csvline);
			String[] tokens = csvline.split(",");
			if(tokens.length >= 7) { 
				String 	startip 	= tokens[0].trim();
				String 	endip   	= tokens[1].trim();
				String 	acsurl 		= tokens[2].trim();
				String 	requrl 		= tokens[3].trim();
				String 	httpport	= tokens[4].trim();
				String 	infmperiod	= tokens[5].trim();
				String 	dumploc		= tokens[6].trim();
				String 	username	= null;
				String 	passwd		= null;
				String 	authtype	= null;
                                String  useragent       = "TR069 Simulator/0.7.0";
				
				if (tokens.length >= 10) { 
					username	= tokens[7].trim();
					passwd		= tokens[8].trim();
					authtype	= tokens[9].trim();
				}
                                if (tokens.length >= 11) {
                                        useragent       = tokens[10].trim();
                                }
				ArrayList<String> iplist = new ArrayList<String>();
				if (!util.isValidIPAddress(startip)) {
					continue;
				}
				if (!util.isValidIPAddress(endip)) {
					iplist.add(startip);
				} else {
					iplist = util.range2iplist(startip, endip);
				}
				int port  		= Integer.parseInt(httpport);
				int infmprd		= Integer.parseInt(infmperiod);
				int ipsize 		= iplist.size();
                                if (ipsize == 1) {
                                        ipadr                   = iplist.get(0);
                                        CPEWorker worker        = new CPEWorker(ipadr, port, acsurl, requrl, infmprd, dumploc, username, passwd, authtype, useragent, "");
                                        Thread cpthread         = new Thread(worker, "WorkerThread_" + threadcnt++);
                                        cpthread.start();
                                } else {
                                        for (int i = 0; i < ipsize; i++) {
                                                ipadr 			= iplist.get(i);
                                                CPEWorker worker 	= new CPEWorker(ipadr, port + threadcnt, acsurl, requrl, infmprd, dumploc, username, passwd, authtype, useragent, String.valueOf(threadcnt));
                                                Thread cpthread 	= new Thread(worker, "WorkerThread_" + threadcnt++);
                                                cpthread.start();
                                        }
                                }
			}
		}
	}

}