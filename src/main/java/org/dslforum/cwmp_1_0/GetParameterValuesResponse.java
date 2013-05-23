
package org.dslforum.cwmp_1_0;

/** 
 * GetParameterValuesResponse message - Annex A.3.2.2
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetParameterValuesResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:ParameterValueList" name="ParameterList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetParameterValuesResponse
{
    private ParameterValueList parameterList;

    /** 
     * Get the 'ParameterList' element value.
     * 
     * @return value
     */
    public ParameterValueList getParameterList() {
        return parameterList;
    }

    /** 
     * Set the 'ParameterList' element value.
     * 
     * @param parameterList
     */
    public void setParameterList(ParameterValueList parameterList) {
        this.parameterList = parameterList;
    }
}
