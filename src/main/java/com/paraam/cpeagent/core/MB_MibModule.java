package com.paraam.cpeagent.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MB_MibModule {

	private long id;
	private long mibfileref_id;
	private String module;
	private String description;
	
	public MB_MibModule(long id, long mibfileref_id, String module, String description){
		this.id		=	id;
		this.mibfileref_id	=	mibfileref_id;
		this.module	=	module;
		this.description	=	description;
	}
	
	@JsonProperty
	public long getId(){
		return id;
	}
	
	
	public void setId(long id){
		this.id		=	id;
	}
	
	@JsonProperty
	public long getMibfileref_id(){
		return mibfileref_id;
	}
	
	public void setsetMibfileref_id(long mibfileref_id){ 
		this.mibfileref_id	=	mibfileref_id;
	}
	
	@JsonProperty
	public String getModule(){
		return module;
	}
	
	public void setModule(String module){
		this.module		=	module;
	}
	
	@JsonProperty
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description	=	description;
	}
}
