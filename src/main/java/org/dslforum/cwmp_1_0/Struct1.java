
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Struct">
 *   &lt;xs:group ref="ns:Struct" minOccurs="0"/>
 *   &lt;xs:attributeGroup ref="ns:commonAttributes"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Struct1
{
    private Struct struct;
    private CommonAttributes commonAttributes;

    /** 
     * Get the 'Struct' group value.
     * 
     * @return value
     */
    public Struct getStruct() {
        return struct;
    }

    /** 
     * Set the 'Struct' group value.
     * 
     * @param struct
     */
    public void setStruct(Struct struct) {
        this.struct = struct;
    }

    /** 
     * Get the 'commonAttributes' attributeGroup value.
     * 
     * @return value
     */
    public CommonAttributes getCommonAttributes() {
        return commonAttributes;
    }

    /** 
     * Set the 'commonAttributes' attributeGroup value.
     * 
     * @param commonAttributes
     */
    public void setCommonAttributes(CommonAttributes commonAttributes) {
        this.commonAttributes = commonAttributes;
    }
}
