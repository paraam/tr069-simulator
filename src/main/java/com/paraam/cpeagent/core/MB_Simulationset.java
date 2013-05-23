package com.paraam.cpeagent.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MB_Simulationset {
	private long id;
    private String ssname;
    private String description;

    public MB_Simulationset() {
    }

    public MB_Simulationset(long id, String ssname, String description) {
            this.setId(id);
            this.setSsname(ssname);
            this.setDescription(description);
    }
    
    @JsonProperty
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
	@JsonProperty
	public String getSsname() {
		return ssname;
	}

	public void setSsname(String ssname) {
		this.ssname = ssname;
	}
	
	@JsonProperty
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
        StringBuffer bu = new StringBuffer();
        bu.append("\nID " + id);
        bu.append("\nssname " + ssname);
        bu.append("\ndescription " + description);
//      bu.append("\nmibmodules " + mibmodules);
        return bu.toString();
}


}
