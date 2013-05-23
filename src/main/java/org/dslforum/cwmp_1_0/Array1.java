
package org.dslforum.cwmp_1_0;

/** 
 * 
 'Array' is a complex type for accessors identified by position 

 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Array">
 *   &lt;xs:group ref="ns:Array" minOccurs="0"/>
 *   &lt;xs:attributeGroup ref="ns:arrayAttributes"/>
 *   &lt;xs:attributeGroup ref="ns:commonAttributes"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Array1
{
    private Array array;
    private ArrayAttributes arrayAttributes;
    private CommonAttributes commonAttributes;

    /** 
     * Get the 'Array' group value.
     * 
     * @return value
     */
    public Array getArray() {
        return array;
    }

    /** 
     * Set the 'Array' group value.
     * 
     * @param array
     */
    public void setArray(Array array) {
        this.array = array;
    }

    /** 
     * Get the 'arrayAttributes' attributeGroup value.
     * 
     * @return value
     */
    public ArrayAttributes getArrayAttributes() {
        return arrayAttributes;
    }

    /** 
     * Set the 'arrayAttributes' attributeGroup value.
     * 
     * @param arrayAttributes
     */
    public void setArrayAttributes(ArrayAttributes arrayAttributes) {
        this.arrayAttributes = arrayAttributes;
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
