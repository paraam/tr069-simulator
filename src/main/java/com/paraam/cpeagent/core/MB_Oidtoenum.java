package com.paraam.cpeagent.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MB_Oidtoenum {

	private int id;
	private int attribute;
	private int val;
	private String enum_;

	public MB_Oidtoenum() {
	}

	public MB_Oidtoenum(int id, int attribute, int val, String enum_) {
		this.id = id;
		this.attribute = attribute;
		this.val = val;
		this.enum_ = enum_;
	}

	@JsonProperty
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@JsonProperty
	public int getAttribute() {
		return this.attribute;
	}

	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}
    
	@JsonProperty
	public int getVal() {
		return this.val;
	}

	public void setVal(int val) {
		this.val = val;
	}
    
	@JsonProperty
	public String getEnum_() {
		return this.enum_;
	}

	public void setEnum_(String enum_) {
		this.enum_ = enum_;
	}

	public String toString() {
		StringBuffer bu = new StringBuffer();
		bu.append("\nID " + id);
		//bu.append("\nattribute " + attribute);
		bu.append("\nval " + val);
		bu.append("\nenum_ " + enum_);
		return bu.toString();
	}
}

