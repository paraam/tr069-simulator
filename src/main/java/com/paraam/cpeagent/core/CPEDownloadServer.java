package com.paraam.cpeagent.core;


import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class CPEDownloadServer implements Runnable {

	String downloadURL;
	
	public CPEDownloadServer(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	
	public void run() {		
		FileOutputStream 	fos = null;
		ReadableByteChannel rbc = null;
		try {
			//Thread.yield()
			Thread.sleep(2000);			
			URL urlobj = new URL(downloadURL);
		    rbc = Channels.newChannel(urlobj.openStream());
		    fos = new FileOutputStream(urlobj.getFile());
		    fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		    
		} catch(Exception e) {
			System.out.println("Download exception : " + e.getMessage());
		}		
	}
}
