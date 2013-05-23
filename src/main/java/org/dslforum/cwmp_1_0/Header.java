
package org.dslforum.cwmp_1_0;

import java.util.ArrayList;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Header">
 *   &lt;xs:sequence>
 *     &lt;xs:any minOccurs="0" maxOccurs="unbounded" processContents="lax" namespace="##other"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:anyAttribute processContents="lax" namespace="##other"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Header {
	
	private ArrayList<Object> objects = new ArrayList<Object>();

	public ArrayList<Object> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Object> objects) {
		this.objects = objects;
	}
}
