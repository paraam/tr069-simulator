package com.paraam.cpeagent.core;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MB_Attribute{

	private int id;
	private int parentkey;
	private String oid;
	private String name;
	private String unit;
	private String status;
	private String reference;
	private boolean isrange;
	private boolean istabular;
	private boolean enumerated;
	private String desc;
	private boolean isconfigattrib;
	private int access;
	private int valtype;
	private int mibtc;
	private int mibmodule;
	private int isparent;
	private String iconname;

	public MB_Attribute() {
	}

	public MB_Attribute(int id, String oid, String name, boolean istabular, 
			boolean enumerated, String desc, boolean isconfigattrib) {
		this.id = id;
		this.oid = oid;
		this.name = name;
		this.istabular = istabular;
		this.enumerated = enumerated;
		this.desc = desc;
		this.isconfigattrib = isconfigattrib;
	}

	public MB_Attribute(int id, int parentkey, String oid, String name, String unit, boolean istabular,
			boolean enumerated, String desc, boolean isconfigattrib, int valtype, int mibtc) {
		this.id = id;
		this.oid = oid;
		this.name = name;
		this.unit = unit;
		this.istabular = istabular;
		this.enumerated = enumerated;
		this.desc = desc;
		this.isconfigattrib = isconfigattrib;
		this.valtype = valtype;
		this.mibtc = mibtc;
		this.parentkey = parentkey;
	}

	@JsonProperty
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@JsonProperty
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	@JsonProperty
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
 
	@JsonProperty
	public boolean isIsrange() {
		return isrange;
	}

	public void setIsrange(boolean isrange) {
		this.isrange = isrange;
	}

	@JsonProperty
	public boolean isIstabular() {
		return this.istabular;
	}
 
	
	public void setIstabular(boolean istabular) {
		this.istabular = istabular;
	}

	@JsonProperty
	public boolean isEnumerated() {
		return this.enumerated;
	}

	
	public void setEnumerated(boolean enumerated) {
		this.enumerated = enumerated;
	}

	@JsonProperty
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@JsonProperty
	public boolean isIsconfigattrib() {
		return this.isconfigattrib;
	}

	public void setIsconfigattrib(boolean isconfigattrib) {
		this.isconfigattrib = isconfigattrib;
	}

	@JsonProperty
	public int getValtype() {
		return this.valtype;
	}

	public void setValtype(int valtype) {
		this.valtype = valtype;
	}

	@JsonProperty
	public Integer getParentkey() {
		return parentkey;
	}

	public void setParentkey(Integer parentkey) {
		this.parentkey = parentkey;
	}

	@JsonProperty
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty
	public int getMibtc() {
		return mibtc;
	}

	public void setMibtc(int mibtc) {
		this.mibtc = mibtc;
	}

	@JsonProperty
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@JsonProperty
	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}
	
	@JsonProperty
	public int getMibmodule() {
		return mibmodule;
	}

	public void setMibmodule(int mibmodule) {
		this.mibmodule = mibmodule;
	}
	
	@JsonProperty
	public int getIsparent(){
		return isparent;
	}
	
	public void setIsparent(int isparent){
		this.isparent	=	isparent;
	}

	@JsonProperty
	public String getIconname(){
		return iconname;
	}
	
	public void setIconname(String iconname){
		this.iconname 	=	iconname;
	}
	
	public String toString() {
		StringBuffer bu = new StringBuffer();
		bu.append("\nID " + id);
		bu.append("\noid " + oid);
		bu.append("\nname " + name);
		bu.append("\nunit " + unit); 
		bu.append("\nisrange " + isrange);
		bu.append("\nistabular " + istabular);
		bu.append("\nenumerated " + enumerated);
		bu.append("\ndesc " + desc);
		bu.append("\nisconfigattrib " + isconfigattrib);
		bu.append("\nvaltype " + valtype);
		bu.append("\nmibtc " + mibtc);
		return bu.toString();
	}
	
}


