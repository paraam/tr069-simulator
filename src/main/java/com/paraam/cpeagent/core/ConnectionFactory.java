/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paraam.cpeagent.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import com.sun.jersey.client.urlconnection.HttpURLConnectionFactory;


public class ConnectionFactory implements HttpURLConnectionFactory {

    Proxy proxy;

    private void initializeProxy() {
        if (System.getProperties().containsKey("http.proxyHost")) {
                proxy = new Proxy(Proxy.Type.HTTP,
                        new InetSocketAddress(
                        System.getProperty("http.proxyHost"),
                        Integer.getInteger("http.proxyPort", 80)));
        } else {
                proxy = Proxy.NO_PROXY;
        }

    }

    public HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        //System.setProperty("http.proxyHost", "localhost");
        //System.setProperty("http.proxyPort", "8888");
        
        initializeProxy();
        return (HttpURLConnection) url.openConnection(proxy);
    }
}