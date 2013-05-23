
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="base64Binary">
 *   &lt;xs:simpleContent>
 *     &lt;xs:extension base="xs:base64Binary">
 *       &lt;xs:attributeGroup ref="ns:commonAttributes"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:simpleContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Base64Binary
{
    private byte[] base64Binary;
    private CommonAttributes commonAttributes;

    /** 
     * Get the extension value.
     * 
     * @return value
     */
    public byte[] getBase64Binary() {
        return base64Binary;
    }

    /** 
     * Set the extension value.
     * 
     * @param base64Binary
     */
    public void setBase64Binary(byte[] base64Binary) {
        this.base64Binary = base64Binary;
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
