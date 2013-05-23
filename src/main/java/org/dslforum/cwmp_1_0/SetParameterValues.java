
package org.dslforum.cwmp_1_0;

/** 
 * SetParameterValues message - Annex A.3.2.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SetParameterValues">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:ParameterValueList" name="ParameterList"/>
 *       &lt;xs:element type="xs:string" name="ParameterKey"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class SetParameterValues
{
    private ParameterValueList parameterList;
    private String parameterKey;

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

    /** 
     * Get the 'ParameterKey' element value.
     * 
     * @return value
     */
    public String getParameterKey() {
        return parameterKey;
    }

    /** 
     * Set the 'ParameterKey' element value.
     * 
     * @param parameterKey
     */
    public void setParameterKey(String parameterKey) {
        this.parameterKey = parameterKey;
    }
}
