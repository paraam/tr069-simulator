
package org.dslforum.cwmp_1_0;

/** 
 * GetParameterAttributesResponse message - Annex A.3.2.5
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetParameterAttributesResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:ParameterAttributeList" name="ParameterList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetParameterAttributesResponse
{
    private ParameterAttributeList parameterList;

    /** 
     * Get the 'ParameterList' element value.
     * 
     * @return value
     */
    public ParameterAttributeList getParameterList() {
        return parameterList;
    }

    /** 
     * Set the 'ParameterList' element value.
     * 
     * @param parameterList
     */
    public void setParameterList(ParameterAttributeList parameterList) {
        this.parameterList = parameterList;
    }
}
