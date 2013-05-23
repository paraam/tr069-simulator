
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="HoldRequests">
 *   &lt;xs:complexType>
 *     &lt;xs:simpleContent>
 *       &lt;xs:extension base="xs:boolean">
 *         &lt;xs:attribute use="required" fixed="1" ref="ns1:mustUnderstand"/>
 *       &lt;/xs:extension>
 *     &lt;/xs:simpleContent>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * 
 * &lt;xs:attribute xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:boolean" name="mustUnderstand"/>
 * </pre>
 */
public class HoldRequests
{
    private boolean _boolean;
    private boolean mustUnderstand;

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
     * Get the 'mustUnderstand' attribute value.
     * 
     * @return value
     */
    public boolean isMustUnderstand() {
        return mustUnderstand;
    }

    /** 
     * Set the 'mustUnderstand' attribute value.
     * 
     * @param mustUnderstand
     */
    public void setMustUnderstand(boolean mustUnderstand) {
        this.mustUnderstand = mustUnderstand;
    }
}
