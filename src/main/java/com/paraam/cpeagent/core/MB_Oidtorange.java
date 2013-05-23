package com.paraam.cpeagent.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MB_Oidtorange {

	private int id;
	private int attribute;
	private String value;

	public MB_Oidtorange() {
	}

	public MB_Oidtorange(int id, int attribute, String value) {
		this.id = id;
		this.attribute = attribute;
		this.value = value;
	}
    
	@JsonProperty
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
	@JsonProperty
	public int getAttribute() {
		return this.attribute;
	}

	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}

	public String toString() {
		StringBuffer bu = new StringBuffer();
		bu.append("\nID " + id);
		//bu.append("\nattribute " + attribute);
		bu.append("\nvalue " + value);
		return bu.toString();
	}
}

