
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="QName">
 *   &lt;xs:simpleContent>
 *     &lt;xs:extension base="xs:QName">
 *       &lt;xs:attributeGroup ref="ns:commonAttributes"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:simpleContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class QName
{
    private org.jibx.runtime.QName QName1;
    private CommonAttributes commonAttributes;

    /** 
     * Get the extension value.
     * 
     * @return value
     */
    public org.jibx.runtime.QName getQName1() {
        return QName1;
    }

    /** 
     * Set the extension value.
     * 
     * @param QName1
     */
    public void setQName1(org.jibx.runtime.QName QName1) {
        this.QName1 = QName1;
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
