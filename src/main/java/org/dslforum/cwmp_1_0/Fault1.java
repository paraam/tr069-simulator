
package org.dslforum.cwmp_1_0;

import org.jibx.runtime.QName;

/** 
 * 
 Fault reporting structure

 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" final="extension" name="Fault">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:QName" name="faultcode"/>
 *     &lt;xs:element type="xs:string" name="faultstring"/>
 *     &lt;xs:element type="xs:string" name="faultactor" minOccurs="0"/>
 *     &lt;xs:element type="ns:detail" name="detail" minOccurs="0"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Fault1
{
    private QName faultcode;
    private String faultstring;
    private String faultactor;
    private Detail detail;

    /** 
     * Get the 'faultcode' element value.
     * 
     * @return value
     */
    public QName getFaultcode() {
        return faultcode;
    }

    /** 
     * Set the 'faultcode' element value.
     * 
     * @param faultcode
     */
    public void setFaultcode(QName faultcode) {
        this.faultcode = faultcode;
    }

    /** 
     * Get the 'faultstring' element value.
     * 
     * @return value
     */
    public String getFaultstring() {
        return faultstring;
    }

    /** 
     * Set the 'faultstring' element value.
     * 
     * @param faultstring
     */
    public void setFaultstring(String faultstring) {
        this.faultstring = faultstring;
    }

    /** 
     * Get the 'faultactor' element value.
     * 
     * @return value
     */
    public String getFaultactor() {
        return faultactor;
    }

    /** 
     * Set the 'faultactor' element value.
     * 
     * @param faultactor
     */
    public void setFaultactor(String faultactor) {
        this.faultactor = faultactor;
    }

    /** 
     * Get the 'detail' element value.
     * 
     * @return value
     */
    public Detail getDetail() {
        return detail;
    }

    /** 
     * Set the 'detail' element value.
     * 
     * @param detail
     */
    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
