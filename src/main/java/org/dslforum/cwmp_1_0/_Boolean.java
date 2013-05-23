
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="boolean">
 *   &lt;xs:simpleContent>
 *     &lt;xs:extension base="xs:boolean">
 *       &lt;xs:attributeGroup ref="ns:commonAttributes"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:simpleContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class _Boolean
{
    private boolean _boolean;
    private CommonAttributes commonAttributes;

    /** 
     * Get the extension value.
     * 
     * @return value
     */
    public boolean isBoolean() {
        return _boolean;
    }

    /** 
     * Set the extension value.
     * 
     * @param _boolean
     */
    public void setBoolean(boolean _boolean) {
        this._boolean = _boolean;
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
