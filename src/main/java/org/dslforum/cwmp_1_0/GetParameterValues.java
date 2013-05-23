
package org.dslforum.cwmp_1_0;

/** 
 * GetParameterValues message - Annex A.3.2.2
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetParameterValues">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:ParameterNames" name="ParameterNames"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetParameterValues
{
    private ParameterNames parameterNames;

    /** 
     * Get the 'ParameterNames' element value.
     * 
     * @return value
     */
    public ParameterNames getParameterNames() {
        return parameterNames;
    }

    /** 
     * Set the 'ParameterNames' element value.
     * 
     * @param parameterNames
     */
    public void setParameterNames(ParameterNames parameterNames) {
        this.parameterNames = parameterNames;
    }
}
