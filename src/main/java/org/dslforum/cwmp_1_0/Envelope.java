
package org.dslforum.cwmp_1_0;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Envelope">
 *   &lt;xs:sequence>
 *     &lt;xs:element ref="ns:Header" minOccurs="0"/>
 *     &lt;xs:element ref="ns:Body" minOccurs="1"/>
 *     &lt;xs:any minOccurs="0" maxOccurs="unbounded" processContents="lax" namespace="##other"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:anyAttribute processContents="lax" namespace="##other"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Envelope
{
    private Header header;
    private Body body;
    private List anyList = new ArrayList();

    /** 
     * Get the 'Header' element value.
     * 
     * @return value
     */
    public Header getHeader() {
        return header;
    }

    /** 
     * Set the 'Header' element value.
     * 
     * @param header
     */
    public void setHeader(Header header) {
        this.header = header;
    }

    /** 
     * Get the 'Body' element value.
     * 
     * @return value
     */
    public Body getBody() {
        return body;
    }

    /** 
     * Set the 'Body' element value.
     * 
     * @param body
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /** 
     * Get the list of any items.
     * 
     * @return list
     */
    public List getAnyList() {
        return anyList;
    }

    /** 
     * Set the list of any items.
     * 
     * @param list
     */
    public void setAnyList(List list) {
        anyList = list;
    }
}
