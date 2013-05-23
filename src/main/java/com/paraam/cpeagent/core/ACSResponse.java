package com.paraam.cpeagent.core;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;

public class ACSResponse {
	
	private String response;
	private List<NewCookie> cookies = new ArrayList<NewCookie>();
	private MultivaluedMap<String, String> headers = null;
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<NewCookie> getCookies() {
		return cookies;
	}
	public void setCookies(List<NewCookie> cookies) {
		this.cookies = cookies;
	}
	public MultivaluedMap<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(MultivaluedMap<String, String> headers) {
		this.headers = headers;
	}
	
	
	

}
