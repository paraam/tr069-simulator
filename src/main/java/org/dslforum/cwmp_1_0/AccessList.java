
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AccessList">
 *   &lt;xs:complexContent>
 *     &lt;xs:restriction base="ns1:Array">
 *       &lt;xs:sequence>
 *         &lt;xs:element name="string" minOccurs="0" maxOccurs="unbounded">
 *           &lt;xs:simpleType>
 *             &lt;xs:restriction base="xs:string">
 *               &lt;xs:enumeration value="Subscriber"/>
 *             &lt;/xs:restriction>
 *           &lt;/xs:simpleType>
 *         &lt;/xs:element>
 *       &lt;/xs:sequence>
 *       &lt;xs:attribute use="required" ref="ns1:arrayType"/>
 *     &lt;/xs:restriction>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AccessList {
	
	private String[] strings = null;

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}	
	
}
