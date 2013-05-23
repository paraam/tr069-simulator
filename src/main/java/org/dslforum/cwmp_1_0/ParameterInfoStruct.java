
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="ParameterInfoStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="Name"/>
 *     &lt;xs:element type="xs:boolean" name="Writable"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class ParameterInfoStruct
{
    private String name;
    private int writable;

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
     * Get the 'Writable' element value.
     * 
     * @return value
     */
    public int getWritable() {
        return writable;
    }

    /** 
     * Set the 'Writable' element value.
     * 
     * @param writable
     */
    public void setWritable(int writable) {
        this.writable = writable;
    }
}
