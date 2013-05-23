
package org.dslforum.cwmp_1_0;

/** 
 * AddObject message - Annex A.3.2.6
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AddObject">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="ObjectName"/>
 *       &lt;xs:element type="xs:string" name="ParameterKey"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class AddObject
{
    private String objectName;
    private String parameterKey;

    /** 
     * Get the 'ObjectName' element value.
     * 
     * @return value
     */
    public String getObjectName() {
        return objectName;
    }

    /** 
     * Set the 'ObjectName' element value.
     * 
     * @param objectName
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
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
