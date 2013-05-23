package com.paraam.cpeagent.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MB_SimulationSet_MibModule {
	
	private long id;
	private long simulationset_id;
	private long mibmodule_id;
	
	public MB_SimulationSet_MibModule(int id, int simulationset_id, int mibmodule_id ){
		this.id			=	id;
		this.simulationset_id =	simulationset_id;
		this.mibmodule_id	=	mibmodule_id;
	}
	
	@JsonProperty
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id		=	id;
	}
	
	@JsonProperty
	public long getSimulationset_id(){
		return simulationset_id;
	}
	
	public void setSimulationset_id(long simulationset_id){
		this.simulationset_id		=	simulationset_id;
	}
	
	@JsonProperty
	public long getMibmodule_id(){
		return mibmodule_id;
	}
	
	public void setMibmodule_id(long mibmodule_id){
		this.mibmodule_id		=	mibmodule_id;
	}

}
