
package org.dslforum.cwmp_1_0;

import java.util.ArrayList;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="ParameterValueList">
 *   &lt;xs:complexContent>
 *     &lt;xs:restriction base="ns1:Array">
 *       &lt;xs:sequence>
 *         &lt;xs:element type="ns:ParameterValueStruct" name="ParameterValueStruct" minOccurs="0" maxOccurs="unbounded"/>
 *       &lt;/xs:sequence>
 *       &lt;xs:attribute use="required" ref="ns1:arrayType"/>
 *     &lt;/xs:restriction>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class ParameterValueList {
	private ArrayList<ParameterValueStruct> parameterValueStruct = new ArrayList<ParameterValueStruct>();
    private ArrayAttributes.ArrayType arrayType = new ArrayAttributes.ArrayType();

	public ArrayList<ParameterValueStruct> getParameterValueStruct() {
		return parameterValueStruct;
	}

	public void setParameterValueStruct( ArrayList<ParameterValueStruct> parameterValueStruct) {
		this.parameterValueStruct = parameterValueStruct;
        this.setArrayType(String.format("cwmp:ParameterValueStruct[%d]", this.parameterValueStruct.size()));
	}
	
	public String getArrayType() {
		return arrayType.getArrayType();
	}

	public void setArrayType(String arrayType) {
        this.arrayType.setArrayType(arrayType);
	}	
}
