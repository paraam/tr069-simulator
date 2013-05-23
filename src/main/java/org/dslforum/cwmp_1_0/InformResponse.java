
package org.dslforum.cwmp_1_0;

/** 
 * InformResponse message - Annex A.3.3.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="InformResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:int" name="MaxEnvelopes"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class InformResponse
{
    private int maxEnvelopes;

    /** 
     * Get the 'MaxEnvelopes' element value.
     * 
     * @return value
     */
    public int getMaxEnvelopes() {
        return maxEnvelopes;
    }

    /** 
     * Set the 'MaxEnvelopes' element value.
     * 
     * @param maxEnvelopes
     */
    public void setMaxEnvelopes(int maxEnvelopes) {
        this.maxEnvelopes = maxEnvelopes;
    }
}
