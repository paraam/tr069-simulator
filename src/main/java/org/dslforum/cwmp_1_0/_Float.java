
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="float">
 *   &lt;xs:simpleContent>
 *     &lt;xs:extension base="xs:float">
 *       &lt;xs:attributeGroup ref="ns:commonAttributes"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:simpleContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class _Float
{
    private Float _float;
    private CommonAttributes commonAttributes;

    /** 
     * Get the extension value.
     * 
     * @return value
     */
    public Float getFloat() {
        return _float;
    }

    /** 
     * Set the extension value.
     * 
     * @param _float
     */
    public void setFloat(Float _float) {
        this._float = _float;
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
