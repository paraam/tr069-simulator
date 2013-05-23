
package org.dslforum.cwmp_1_0;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="detail">
 *   &lt;xs:sequence>
 *     &lt;xs:any minOccurs="0" maxOccurs="unbounded" processContents="lax" namespace="##any"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:anyAttribute processContents="lax" namespace="##any"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Detail
{
    private List anyList = new ArrayList();

    /** 
     * Get the list of 'detail' complexType items.
     * 
     * @return list
     */
    public List getAnyList() {
        return anyList;
    }

    /** 
     * Set the list of 'detail' complexType items.
     * 
     * @param list
     */
    public void setAnyList(List list) {
        anyList = list;
    }
}
