
package org.dslforum.cwmp_1_0;

/** 
 * KickedResponse message - Annex A.4.2.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="KickedResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="NextURL"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class KickedResponse
{
    private String nextURL;

    /** 
     * Get the 'NextURL' element value.
     * 
     * @return value
     */
    public String getNextURL() {
        return nextURL;
    }

    /** 
     * Set the 'NextURL' element value.
     * 
     * @param nextURL
     */
    public void setNextURL(String nextURL) {
        this.nextURL = nextURL;
    }
}
