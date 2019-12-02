
package org.dslforum.cwmp_1_0;

import java.util.ArrayList;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="EventList">
 *   &lt;xs:complexContent>
 *     &lt;xs:restriction base="ns1:Array">
 *       &lt;xs:sequence>
 *         &lt;xs:element type="ns:EventStruct" name="EventStruct" minOccurs="0" maxOccurs="64"/>
 *       &lt;/xs:sequence>
 *       &lt;xs:attribute use="required" ref="ns1:arrayType"/>
 *     &lt;/xs:restriction>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class EventList {
	private ArrayList<EventStruct> eventStruct = new ArrayList<EventStruct>();
    private ArrayAttributes.ArrayType arrayType = new ArrayAttributes.ArrayType();;

	public ArrayList<EventStruct> getEventStruct() {
		return eventStruct;
	}

	public void setEventStruct(ArrayList<EventStruct> eventStruct) {
		this.eventStruct = eventStruct;
        this.setArrayType(String.format("cwmp:EventStruct[%d]", this.eventStruct.size()));
	}	
	
    public String getArrayType() {
		return arrayType.getArrayType();
	}

	public void setArrayType(String arrayType) {
        this.arrayType.setArrayType(arrayType);
	}	
}
