
package org.dslforum.cwmp_1_0;

/** 
 * GetParameterNames message - Annex A.3.2.3
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetParameterNames">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" nillable="true" name="ParameterPath"/>
 *       &lt;xs:element type="xs:boolean" name="NextLevel"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetParameterNames
{
    private String parameterPath;
    private boolean nextLevel;

    /** 
     * Get the 'ParameterPath' element value.
     * 
     * @return value
     */
    public String getParameterPath() {
        return parameterPath;
    }

    /** 
     * Set the 'ParameterPath' element value.
     * 
     * @param parameterPath
     */
    public void setParameterPath(String parameterPath) {
        this.parameterPath = parameterPath;
    }

    /** 
     * Get the 'NextLevel' element value.
     * 
     * @return value
     */
    public boolean isNextLevel() {
        return nextLevel;
    }

    /** 
     * Set the 'NextLevel' element value.
     * 
     * @param nextLevel
     */
    public void setNextLevel(boolean nextLevel) {
        this.nextLevel = nextLevel;
    }
}
