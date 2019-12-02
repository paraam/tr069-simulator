package com.paraam.cpeagent.core;

import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

public class JibxHelper {
	
	public final static String STRING_ENCODING = "UTF8";
    public final static String URL_ENCODING = "UTF-8";
	
	public static String marshalObject(Object message, String system)	{
		String packageName = "org.dslforum." + system;
		String bindingName = "binding";

		try {
			IBindingFactory jc = BindingDirectory.getFactory(bindingName, packageName);
			IMarshallingContext marshaller = jc.createMarshallingContext();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			marshaller.marshalDocument(message, URL_ENCODING, null, out);
			String xml = out.toString(STRING_ENCODING);
			return xml;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JiBXException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Unmarshal this xml Message to an object.
	 * @param xml
	 * @param version
	 * @return
	 */
	public static Object unmarshalMessage(String xml, String version)
	{
		String packageName = "org.dslforum." + version;
		String bindingName = "binding";

		try {
			IBindingFactory jc = BindingDirectory.getFactory(bindingName, packageName);
			IUnmarshallingContext unmarshaller = jc.createUnmarshallingContext();
			Reader inStream = new StringReader(xml);
			Object message = unmarshaller.unmarshalDocument( inStream, bindingName);
			return message;
		} catch (JiBXException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object unmarshalMessage(Class className, String xml, String version) {
		String packageName = "org.dslforum." + version;
		String bindingName = "binding";
		try {
			IBindingFactory jc = BindingDirectory.getFactory(bindingName, className);
			IUnmarshallingContext unmarshaller = jc.createUnmarshallingContext();
			Reader inStream = new StringReader(xml);
			Object message = unmarshaller.unmarshalDocument( inStream, bindingName);
			return message;
		} catch (JiBXException e) {
			e.printStackTrace();
		}
		return null;
	}

}
