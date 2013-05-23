
package org.dslforum.cwmp_1_0;

/** 
 * GetParameterNamesResponse message - Annex A.3.2.3
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetParameterNamesResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:ParameterInfoList" name="ParameterList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetParameterNamesResponse
{
    private ParameterInfoList parameterList;

    /** 
     * Get the 'ParameterList' element value.
     * 
     * @return value
     */
    public ParameterInfoList getParameterList() {
        return parameterList;
    }

    /** 
     * Set the 'ParameterList' element value.
     * 
     * @param parameterList
     */
    public void setParameterList(ParameterInfoList parameterList) {
        this.parameterList = parameterList;
    }
}
