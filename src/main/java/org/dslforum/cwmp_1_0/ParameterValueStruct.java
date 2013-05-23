
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="ParameterValueStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="Name"/>
 *     &lt;xs:element type="xs:anySimpleType" name="Value"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class ParameterValueStruct
{
    private String name;
    private String value;

    /** 
     * Get the 'Name' element value.
     * 
     * @return value
     */
    public String getName() {
        return name;
    }

    /** 
     * Set the 'Name' element value.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Get the 'Value' element value.
     * 
     * @return value
     */
    public String getValue() {
        return value;
    }

    /** 
     * Set the 'Value' element value.
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
