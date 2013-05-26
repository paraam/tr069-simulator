package com.paraam.cpeagent.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPEUtil {
	
	public ArrayList<String> parseFile(String filepath) {
		ArrayList<String> agentlist = new ArrayList<String>();
		//System.out.println( "deserialize CpeConfDB >>>>>> : " + filepath);
		try {
			BufferedReader input = null;
			File infile = new File(filepath);
			if (infile.exists()) {
				input = new BufferedReader(new FileReader(infile));
			} else {
				InputStream is = this.getClass().getResourceAsStream(filepath);
				input = new BufferedReader(new InputStreamReader( is));
			}
			try {
				String line = null;
				while (( line = input.readLine()) != null) {
					agentlist.add(line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return agentlist;
	}

	public ArrayList<String> range2iplist( String startIp, String endIp ) {         
        long start 	= ipToLong(startIp);         
        long end 	= ipToLong(endIp);
        ArrayList<String> pairs = new ArrayList<String>();         
        while ( end >= start ) {                     
            String ip = longToIP(start);  
            //System.out.println("Printing the IP: " + ip);
            pairs.add(ip);
            start += 1;         
        }         
        return pairs;     
    }   

	private long ipToLong(String strIP) {         
		long[] ip = new long[4];         
		String[] ipSec = strIP.split("\\.");         
		for (int k = 0; k < 4; k++) {             
			ip[k] = Long.valueOf(ipSec[k]);         
		}         

		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];     
	}       

	private String longToIP(long longIP) {         
		StringBuffer sb = new StringBuffer("");         
		sb.append(String.valueOf(longIP >>> 24));         
		sb.append(".");         
		sb.append(String.valueOf((longIP & 0x00FFFFFF) >>> 16));         
		sb.append(".");         
		sb.append(String.valueOf((longIP & 0x0000FFFF) >>> 8));         
		sb.append(".");         
		sb.append(String.valueOf(longIP & 0x000000FF));   

		return sb.toString();     
	} 
	
	public boolean isValidIPAddress(String ipaddress) {	
		String ipAddressRegex = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
		Pattern p = Pattern.compile(ipAddressRegex);
		//Match the input string with the pattern
		Matcher m = p.matcher(ipaddress);				
		return m.matches();			
	}

}
