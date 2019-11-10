package com.paraam.cpeagent.api;

import com.paraam.cpeagent.core.ConnectionFactory;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import java.util.HashMap;
import java.util.Map;

public class ResourceAPI {
	
	//String urlstr = "http://192.168.1.50:8085/ws?wsdl";

	private static 	ResourceAPI INSTANCE 	= null;	
	private 		WebResource service		= null;
    private         Map<String, WebResource> services = new HashMap<String, WebResource>();

	private ResourceAPI() { }
	
	public static synchronized ResourceAPI getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new ResourceAPI();        	
        }
        return INSTANCE;
    }

    public WebResource getResourceAPI(String urlstr) {
    	if(!services.containsKey(urlstr)) {
    		//ClientConfig 	config 		= new DefaultClientConfig();
            //Client          client      = Client.create(config);
            URLConnectionClientHandler ch   = new URLConnectionClientHandler(new ConnectionFactory());
            Client 	        client 		= new Client(ch);
            services.put(urlstr, client.resource(getBaseURI(urlstr)));
        }
        
    	return services.get(urlstr);
    }
    
    private URI getBaseURI(String urlstr) {
		return UriBuilder.fromUri(urlstr).build();
	}	
    
}
