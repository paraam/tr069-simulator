
package org.dslforum.cwmp_1_0;

import java.util.ArrayList;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SetParameterAttributesList">
 *   &lt;xs:complexContent>
 *     &lt;xs:restriction base="ns1:Array">
 *       &lt;xs:sequence>
 *         &lt;xs:element type="ns:SetParameterAttributesStruct" name="SetParameterAttributesStruct" minOccurs="1" maxOccurs="unbounded"/>
 *       &lt;/xs:sequence>
 *       &lt;xs:attribute use="required" ref="ns1:arrayType"/>
 *     &lt;/xs:restriction>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class SetParameterAttributesList {
	
	private ArrayList<SetParameterAttributesStruct> setParameterAttributesStruct = new ArrayList<SetParameterAttributesStruct>();

	public ArrayList<SetParameterAttributesStruct> getSetParameterAttributesStruct() {
		return setParameterAttributesStruct;
	}

	public void setSetParameterAttributesStruct(
			ArrayList<SetParameterAttributesStruct> setParameterAttributesStruct) {
		this.setParameterAttributesStruct = setParameterAttributesStruct;
	}	

}
