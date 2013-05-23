
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="ID">
 *   &lt;xs:complexType>
 *     &lt;xs:simpleContent>
 *       &lt;xs:extension base="xs:string">
 *         &lt;xs:attribute use="required" fixed="1" ref="ns1:mustUnderstand"/>
 *       &lt;/xs:extension>
 *     &lt;/xs:simpleContent>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * 
 * &lt;xs:attribute xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:ns1="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:boolean" name="mustUnderstand"/>
 * </pre>
 */
public class ID
{
    private String string;
    private boolean mustUnderstand;

    /** 
     * Get the extension value.
     * 
     * @return value
     */
    public String getString() {
        return string;
    }

    /** 
     * Set the extension value.
     * 
     * @param string
     */
    public void setString(String string) {
        this.string = string;
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
