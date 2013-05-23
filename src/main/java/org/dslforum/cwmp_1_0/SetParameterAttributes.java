
package org.dslforum.cwmp_1_0;

/** 
 * SetParameterAttributes message - Annex A.3.2.4
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SetParameterAttributes">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:SetParameterAttributesList" name="ParameterList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class SetParameterAttributes
{
    private SetParameterAttributesList parameterList;

    /** 
     * Get the 'ParameterList' element value.
     * 
     * @return value
     */
    public SetParameterAttributesList getParameterList() {
        return parameterList;
    }

    /** 
     * Set the 'ParameterList' element value.
     * 
     * @param parameterList
     */
    public void setParameterList(SetParameterAttributesList parameterList) {
        this.parameterList = parameterList;
    }
}
