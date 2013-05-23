
package org.dslforum.cwmp_1_0;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Fault">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="FaultCode"/>
 *       &lt;xs:element type="xs:string" name="FaultString" minOccurs="0"/>
 *       &lt;xs:element name="SetParameterValuesFault" minOccurs="0" maxOccurs="unbounded">
 *         &lt;!-- Reference to inner class SetParameterValuesFault -->
 *       &lt;/xs:element>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Fault
{
    private String faultCode;
    private String faultString;
    private List setParameterValuesFaultList = new ArrayList();

    /** 
     * Get the 'FaultCode' element value.
     * 
     * @return value
     */
    public String getFaultCode() {
        return faultCode;
    }

    /** 
     * Set the 'FaultCode' element value.
     * 
     * @param faultCode
     */
    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    /** 
     * Get the 'FaultString' element value.
     * 
     * @return value
     */
    public String getFaultString() {
        return faultString;
    }

    /** 
     * Set the 'FaultString' element value.
     * 
     * @param faultString
     */
    public void setFaultString(String faultString) {
        this.faultString = faultString;
    }

    /** 
     * Get the list of 'SetParameterValuesFault' element items.
     * 
     * @return list
     */
    public List getSetParameterValuesFaultList() {
        return setParameterValuesFaultList;
    }

    /** 
     * Set the list of 'SetParameterValuesFault' element items.
     * 
     * @param list
     */
    public void setSetParameterValuesFaultList(List list) {
        setParameterValuesFaultList = list;
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:element xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SetParameterValuesFault" minOccurs="0" maxOccurs="unbounded">
     *   &lt;xs:complexType>
     *     &lt;xs:sequence>
     *       &lt;xs:element type="xs:string" name="ParameterName"/>
     *       &lt;xs:element type="xs:string" name="FaultCode"/>
     *       &lt;xs:element type="xs:string" name="FaultString" minOccurs="0"/>
     *     &lt;/xs:sequence>
     *   &lt;/xs:complexType>
     * &lt;/xs:element>
     * </pre>
     */
    public static class SetParameterValuesFault
    {
        private String parameterName;
        private String faultCode;
        private String faultString;

        /** 
         * Get the 'ParameterName' element value.
         * 
         * @return value
         */
        public String getParameterName() {
            return parameterName;
        }

        /** 
         * Set the 'ParameterName' element value.
         * 
         * @param parameterName
         */
        public void setParameterName(String parameterName) {
            this.parameterName = parameterName;
        }

        /** 
         * Get the 'FaultCode' element value.
         * 
         * @return value
         */
        public String getFaultCode() {
            return faultCode;
        }

        /** 
         * Set the 'FaultCode' element value.
         * 
         * @param faultCode
         */
        public void setFaultCode(String faultCode) {
            this.faultCode = faultCode;
        }

        /** 
         * Get the 'FaultString' element value.
         * 
         * @return value
         */
        public String getFaultString() {
            return faultString;
        }

        /** 
         * Set the 'FaultString' element value.
         * 
         * @param faultString
         */
        public void setFaultString(String faultString) {
            this.faultString = faultString;
        }
    }
}
