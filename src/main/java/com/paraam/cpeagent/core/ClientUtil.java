package com.paraam.cpeagent.core;

import java.util.Hashtable;

public class ClientUtil {
	
	public static Hashtable<String, Integer> reqProps 			= new Hashtable<String, Integer>();

	public static final int 	GET_RPC_METHODS_ID				= 1;
	public static final int 	GET_PARAMETER_VALUES_ID			= 2;
	public static final int 	SET_PARAMETER_VALUES_ID			= 3;
	public static final int 	GET_PARAMETER_NAMES_ID			= 4;
	public static final int 	GET_PARAMETER_ATTRIBUTES_ID		= 5;
	public static final int 	SET_PARAMETER_ATTRIBUTES_ID	 	= 6;
	public static final int 	ADD_OBJECT_ID	 				= 7;
	public static final int 	DELETE_OBJECT_ID 				= 8;
	public static final int 	REBOOT_ID	 					= 9;
	public static final int 	DOWNLOAD_ID 					= 10;
	public static final int 	SCHEDULE_INFORM_ID 				= 11;
	public static final int 	UPLOAD_ID 						= 12;
	public static final int 	FACTORY_RESET_ID				= 13;
	
	public static final String 	GET_RPC_METHODS					= "GetRPCMethods";
	public static final String 	GET_PARAMETER_VALUES			= "GetParameterValues";
	public static final String 	SET_PARAMETER_VALUES			= "SetParameterValues";
	public static final String 	GET_PARAMETER_NAMES				= "GetParameterNames";
	public static final String 	GET_PARAMETER_ATTRIBUTES		= "GetParameterAttributes";
	public static final String	SET_PARAMETER_ATTRIBUTES		= "SetParameterAttributes";
	public static final String	ADD_OBJECT	 					= "AddObject";
	public static final String	DELETE_OBJECT	 				= "DeleteObject";
	public static final String	REBOOT 							= "Reboot";
	public static final String 	DOWNLOAD	 					= "Download";
	public static final String	SCHEDULE_INFORM 				= "ScheduleInform";
	public static final String	UPLOAD 							= "Upload";
	public static final String	FACTORY_RESET 					= "FactoryReset";
	
	static {
		reqProps.put(GET_RPC_METHODS, new Integer(GET_RPC_METHODS_ID));
		reqProps.put(GET_PARAMETER_VALUES, new Integer(GET_PARAMETER_VALUES_ID));
		reqProps.put(SET_PARAMETER_VALUES, new Integer(SET_PARAMETER_VALUES_ID));
		reqProps.put(GET_PARAMETER_NAMES, new Integer(GET_PARAMETER_NAMES_ID));
		reqProps.put(GET_PARAMETER_ATTRIBUTES, new Integer(GET_PARAMETER_ATTRIBUTES_ID));
		reqProps.put(SET_PARAMETER_ATTRIBUTES, new Integer(SET_PARAMETER_ATTRIBUTES_ID));
		reqProps.put(ADD_OBJECT, new Integer(ADD_OBJECT_ID));
		reqProps.put(DELETE_OBJECT, new Integer(DELETE_OBJECT_ID));
		reqProps.put(REBOOT, new Integer(REBOOT_ID));
		reqProps.put(DOWNLOAD, new Integer(DOWNLOAD_ID));
		reqProps.put(SCHEDULE_INFORM, new Integer(SCHEDULE_INFORM_ID));
		reqProps.put(UPLOAD, new Integer(UPLOAD_ID));
		reqProps.put(FACTORY_RESET, new Integer(FACTORY_RESET_ID));
	}

}
