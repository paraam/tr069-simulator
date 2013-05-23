
package org.dslforum.cwmp_1_0;

/** 
 * 
 Attributes common to all elements that function as accessors or 
 represent independent (multi-ref) values.  The href attribute is
 intended to be used in a manner like CONREF.  That is, the element
 content should be empty iff the href attribute appears

 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:attributeGroup xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="commonAttributes">
 *   &lt;xs:attribute type="xs:string" name="id"/>
 *   &lt;xs:attribute type="xs:string" name="href"/>
 *   &lt;xs:anyAttribute processContents="lax" namespace="##other"/>
 * &lt;/xs:attributeGroup>
 * </pre>
 */
public class CommonAttributes
{
    private String id;
    private String href;

    /** 
     * Get the 'id' attribute value.
     * 
     * @return value
     */
    public String getId() {
        return id;
    }

    /** 
     * Set the 'id' attribute value.
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /** 
     * Get the 'href' attribute value.
     * 
     * @return value
     */
    public String getHref() {
        return href;
    }

    /** 
     * Set the 'href' attribute value.
     * 
     * @param href
     */
    public void setHref(String href) {
        this.href = href;
    }
}
