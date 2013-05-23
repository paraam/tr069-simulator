package com.paraam.cpeagent.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.dslforum.cwmp_1_0.Envelope;
import org.dslforum.cwmp_1_0.GetParameterNamesResponse;
import org.dslforum.cwmp_1_0.GetParameterValuesResponse;
import org.dslforum.cwmp_1_0.ParameterInfoList;
import org.dslforum.cwmp_1_0.ParameterInfoStruct;
import org.dslforum.cwmp_1_0.ParameterValueList;
import org.dslforum.cwmp_1_0.ParameterValueStruct;

/**
 * @author anders
 *
 */
public class CpeDBReader implements Serializable {		private static final long serialVersionUID = -2634321577569129211L;	
	private CpeDBReader INSTANCE 		= null;	
	HashMap 	confs 	= new HashMap();	
	Properties 	props 	= new Properties();	
	
	public CpeDBReader() { }
		public CpeDBReader readFromGetMessages(String baseDir) {
		CpeDBReader 	confDB 			= new CpeDBReader();
		String 			cwmpver 		= "cwmp_1_0";
		String 			xmlfile 		= baseDir + "getnames.txt";
		String 			xmlcontent1		= deserialize (xmlfile);
		Envelope 		classobj 		= (Envelope)JibxHelper.unmarshalMessage(xmlcontent1, cwmpver);
		Object 			tempobj 		= classobj.getBody().getObjects().get(0);
		GetParameterNamesResponse resp 	= (GetParameterNamesResponse)tempobj;
		ParameterInfoList pilist 		= resp.getParameterList();
		ArrayList 		namelist 		= pilist.getParameterInfoStruct();

		//System.out.println(	"  ParameterInfoList Classes ---- " + tempobj1.getClass().getName());
		String 			xmlfile2 		= baseDir + "getvalues.txt";
		String 			xmlcontent2 	= deserialize (xmlfile2);
		Envelope 		classobj2 		= (Envelope)JibxHelper.unmarshalMessage(xmlcontent2, cwmpver);	
		
		for (Iterator e = namelist.iterator() ; e.hasNext();) {
			//System.out.println(	"  Body Classes ---- " + e.next().getClass().getSimpleName());
			ParameterInfoStruct pis = (ParameterInfoStruct)e.next();
			String namestr		= pis.getName();
			int 	boolnum 	= pis.getWritable();
			if(namestr.endsWith(".")) {
				ConfObject confobj = new ConfObject();
				confobj.name = namestr;
				confobj.writable = ""+boolnum;				confDB.confs.put(namestr, confobj);			} else {
				ConfParameter confobj = new ConfParameter();
				confobj.name = namestr;
				confobj.writable = ""+boolnum ;
				confobj.notification = "0";
				confobj.accessList = "Subscriber";				confDB.confs.put(namestr, confobj);			}		
		}
		Object 		tempobj2		= classobj2.getBody().getObjects().get(0);
		ParameterValueList 	pvlist 	= ((GetParameterValuesResponse)tempobj2).getParameterList();
		ArrayList 		valuelist  	= pvlist.getParameterValueStruct();

		for (Iterator e = valuelist.iterator() ; e.hasNext();) {
			ParameterValueStruct pvs = (ParameterValueStruct)e.next();
				String namestr		= pvs.getName();
				String valuestr		= pvs.getValue();
				if(!confDB.confs.containsKey(namestr) ) {
					if(namestr.endsWith(".")) {
						ConfObject confobj = new ConfObject();
						confobj.name = namestr;
						confobj.writable = "0";
						confDB.confs.put(namestr, confobj);
					} else {
						ConfParameter confobj = new ConfParameter();
						confobj.name = namestr;
						confobj.writable = "0";
						confobj.notification = "0";
						confobj.accessList = "Subscriber";
						confDB.confs.put(namestr, confobj);
					}
				}				
				((ConfParameter)confDB.confs.get(namestr)).value = valuestr; //pvs.getValue();
				//System.out.println("Adding key/value   " + namestr + " = " + valuestr );
			
		}
		confDB.props = setCPEKeyProperties(baseDir);
		//def keys = confDB.confs.keySet().asList().sort();
		return confDB;	}
	
	/*public static String getXMLString (Element element) {
		StringWriter buffer = new StringWriter();		
		try {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(element), new StreamResult(buffer));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  buffer.toString();
		
	}*/		
	static void serialize(String filepath, String content) throws IOException {
		if (filepath == null) {
			throw new IllegalArgumentException("File should not be null.");
		}
		File aFile = new File (filepath);
		Writer output = new BufferedWriter(new FileWriter(aFile));
		try {
			output.write( content );
		} finally {
			output.close();
		}
	}	public String deserialize(String filepath) {
		//File aFile = new File (filepath);
		System.out.println( "deserialize CpeConfDB >>>>>> : " + filepath);
		StringBuilder contents = new StringBuilder();	    
		try {
			BufferedReader input = null;
			File infile = new File(filepath);
			if (infile.exists()) {
				input = new BufferedReader(new FileReader(infile));
			} else {
				InputStream is = this.getClass().getResourceAsStream(filepath);
				input = new BufferedReader(new InputStreamReader( is));
			}
			//BufferedReader input =  new BufferedReader(new FileReader(aFile));
			try {
				String line = null;
				while (( line = input.readLine()) != null){
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
		return contents.toString();
	}
	
	private Properties setCPEKeyProperties(String baseDir) {		
		Properties tprops = null;
		String filepath = baseDir + "cpekeys.properties";
		InputStream is = null;
		try {
			File infile = new File( filepath);
			if (infile.exists()) {
				is = new FileInputStream(infile);
				System.out.println("Properties has been loaded from FLAT File >>>>>> ");
			} else {
				is = this.getClass().getResourceAsStream(filepath);
				System.out.println("Properties has been loaded from JAR File >>>>>> ");
			}
			if (is != null) {
				tprops = new Properties();
				tprops.load(is);			
				System.out.println("Properties has been loaded successfully >>>>>> "  + props.toString());
			}
		} catch (IOException ex) {
			System.out.println("Exception in reading CPE Keys property file " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				is.close();
			} catch ( Exception e) { }
		}
		if (tprops == null) {
			tprops = new Properties();
			tprops.setProperty("MgmtServer_URL", "InternetGatewayDevice.ManagementServer.URL");
			tprops.setProperty("ConnectionRequestURL", "InternetGatewayDevice.ManagementServer.ConnectionRequestURL");
			tprops.setProperty("PeriodicInformInterval", "InternetGatewayDevice.ManagementServer.PeriodicInformInterval");
			tprops.setProperty("SerialNumber", "InternetGatewayDevice.DeviceInfo.SerialNumber");
			tprops.setProperty("ExternalIPAddress", "InternetGatewayDevice.WANDevice.1.WANConnectionDevice.1.WANPPPConnection.1.ExternalIPAddress");
			System.out.println("Properties has been loaded from Default Keys >>>>>> ");
		}
		return tprops;
	}

	public static void main(String[] args){
		System.out.println( "Starting CpeConfDB");
				//def c = CpeConfDB.readFromGetMessages('testfiles/parameters_zyxel2602/')	
		//CpeDBReader c = CpeDBReader.readFromGetMessages("D://Paraam//ACS//femto//microcell//");
		CpeDBReader c = new CpeDBReader().readFromGetMessages("/dump/microcell/");		

		//CpeDBReader c = CpeDBReader.readFromGetMessages("D://Paraam//ACS//groovy_src//groovycpe//testfiles//parameters_zyxel2602//");
		System.out.println( " Hashtable >>>>>> " + c.confs.toString());		System.out.println( " SerialNumber ---->  " + ((ConfParameter)c.confs.get("Device.DeviceInfo.SerialNumber")).value);	
		//System.out.println( " SerialNumber ---->  " + ((ConfParameter)c.confs.get("InternetGatewayDevice.DeviceInfo.SerialNumber")).value);			//c.serialize("test.txt");		//System.out.println( " " + CpeDBReader.deserialize("test.txt"));
	}	
}class ConfTreeNode {		String name;	HashMap children = new HashMap();	ConfObject data;		ConfTreeNode(String name){		this.name = name;	}		public ConfTreeNode getChild(String name){		return (ConfTreeNode)children.get(name);	}		public void addChild(String name, ConfTreeNode child) {		children.put(name, child);	}	}class ConfObject implements Serializable {	private static final long serialVersionUID = -572794791232157922L;		String name;	String writable;		ConfObject(){}		ConfObject(String name, String writable){		this.name=name;		this.writable = writable;	}}class ConfParameter extends ConfObject {	private static final long serialVersionUID = -5721624376352129129L;	String value;	String accessList;	String notification;		ConfParameter(){}		ConfParameter(String name, String writable, String value, String notification, String accessList) {		super(name, writable);		this.value = value;		this.notification = notification;		this.accessList = accessList;	}	}