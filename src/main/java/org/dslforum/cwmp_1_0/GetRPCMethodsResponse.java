
package org.dslforum.cwmp_1_0;

/** 
 * GeRPCMethodsResponse message - Annex A.3.1.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetRPCMethodsResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:MethodList" name="MethodList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetRPCMethodsResponse
{
    private MethodList methodList;

    /** 
     * Get the 'MethodList' element value.
     * 
     * @return value
     */
    public MethodList getMethodList() {
        return methodList;
    }

    /** 
     * Set the 'MethodList' element value.
     * 
     * @param methodList
     */
    public void setMethodList(MethodList methodList) {
        this.methodList = methodList;
    }
}
