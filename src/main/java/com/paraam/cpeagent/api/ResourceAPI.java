package com.paraam.cpeagent.api;

import com.paraam.cpeagent.core.ConnectionFactory;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;

    public class ResourceAPI {
	
	//String urlstr = "http://192.168.1.50:8085/ws?wsdl";

	private static 	ResourceAPI INSTANCE 	= null;	
	private 		WebResource service		= null;

	private ResourceAPI() { }
	
	public static synchronized ResourceAPI getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new ResourceAPI();        	
        }
        return INSTANCE;
    }

    public WebResource getResourceAPI(String urlstr) {
    	if(service == null) {
    		//ClientConfig 	config 		= new DefaultClientConfig();
            //Client          client      = Client.create(config);
            URLConnectionClientHandler ch   = new URLConnectionClientHandler(new ConnectionFactory());
            Client 	        client 		= new Client(ch);
            service 			= client.resource(getBaseURI(urlstr));
        }
        
    	return service;
    }
    
    private URI getBaseURI(String urlstr) {
		return UriBuilder.fromUri(urlstr).build();
	}	
    
}
