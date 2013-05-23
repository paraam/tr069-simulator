package com.paraam.cpeagent.core;

/**
 * SimAttrib model class 
 */
public class SimAttrib implements java.io.Serializable {

	private int id;
	private Integer oid;
	private Integer ssid;
	private String oidstr;
	private String oidlabel;
	private String instance;
	private String value;
	private int last_index;
	private int order_value;
	private boolean use_func;
	private Integer func;

	public SimAttrib() {
	}

	public SimAttrib(int id, Integer oid, Integer ssid, String instance, String value, 
			int last_index, int order_value, boolean use_func, Integer func) {
		this.id = id;
		this.oid = oid;
		this.ssid = ssid;
		this.instance = instance;
		this.value = value;
		this.last_index = last_index;
		this.order_value = order_value;
		this.use_func = use_func;
		this.func = func;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOidstr() {
		return oidstr;
	}

	public void setOidstr(String oidstr) {
		this.oidstr = oidstr;
	}

	public String getOidlabel() {
		return oidlabel;
	}

	public void setOidlabel(String oidlabel) {
		this.oidlabel = oidlabel;
	}

	public Integer getSsid() {
		return ssid;
	}

	public void setSsid(Integer ssid) {
		this.ssid = ssid;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getLast_index() {
		return last_index;
	}

	public void setLast_index(int last_index) {
		this.last_index = last_index;
	}

	public int getOrder_value() {
		return order_value;
	}

	public void setOrder_value(int order_value) {
		this.order_value = order_value;
	}

	public boolean isUse_func() {
		return use_func;
	}

	public void setUse_func(boolean use_func) {
		this.use_func = use_func;
	}

	public Integer getFunc() {
		return func;
	}

	public void setFunc(Integer func) {
		this.func = func;
	}

	public String toString() {
		StringBuffer bu = new StringBuffer();
		bu.append("\nID " + id);
		bu.append("\noid " + oid);
		bu.append("\nssid " + ssid);
		bu.append("\ninstance " + instance); 
		bu.append("\nvalue " + value);
		bu.append("\nlast_index " + last_index);
		bu.append("\norder_value " + order_value);
		bu.append("\nuse_func " + use_func);
		bu.append("\nfunc " + func);
		return bu.toString();
	}
	
}


