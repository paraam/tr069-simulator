
package org.dslforum.cwmp_1_0;

/** 
 * Fault information for TransferComplete
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="FaultStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element name="FaultCode">
 *       &lt;xs:simpleType>
 *         &lt;!-- Reference to inner class FaultCode -->
 *       &lt;/xs:simpleType>
 *     &lt;/xs:element>
 *     &lt;xs:element type="xs:string" name="FaultString"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class FaultStruct
{
    private FaultCode faultCode;
    private String faultString;

    /** 
     * Get the 'FaultCode' element value.
     * 
     * @return value
     */
    public FaultCode getFaultCode() {
        return faultCode;
    }

    /** 
     * Set the 'FaultCode' element value.
     * 
     * @param faultCode
     */
    public void setFaultCode(FaultCode faultCode) {
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
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema">
     *   &lt;xs:restriction base="xs:int">
     *     &lt;xs:enumeration value="0"/>
     *     &lt;xs:enumeration value="9001"/>
     *     &lt;xs:enumeration value="9002"/>
     *     &lt;xs:enumeration value="9010"/>
     *     &lt;xs:enumeration value="9011"/>
     *     &lt;xs:enumeration value="9012"/>
     *   &lt;/xs:restriction>
     * &lt;/xs:simpleType>
     * </pre>
     */
    public static class FaultCode
    {
        private final String value;
        /** 
         * No fault
         */
        public static final FaultCode _0 = new FaultCode("0");
        /** 
         * Request denied (no reason specified)
         */
        public static final FaultCode _9001 = new FaultCode("9001");
        /** 
         * Internal error
         */
        public static final FaultCode _9002 = new FaultCode("9002");
        /** 
         * Download failure
         */
        public static final FaultCode _9010 = new FaultCode("9010");
        /** 
         * Upload failure
         */
        public static final FaultCode _9011 = new FaultCode("9011");
        /** 
         * File transfer server authentication failure
         */
        public static final FaultCode _9012 = new FaultCode("9012");
        private static final String[] values = new String[]{"0", "9001",
                "9002", "9010", "9011", "9012"};
        private static final FaultCode[] instances = new FaultCode[]{_0, _9001,
                _9002, _9010, _9011, _9012};

        private FaultCode(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static FaultCode convert(String value) {
            int index = java.util.Arrays.binarySearch(values, value);
            if (index >= 0) {
                return instances[index];
            } else {
                return null;
            }
        }

        public static FaultCode fromValue(String text) {
            FaultCode value = convert(text);
            if (value == null) {
                throw new IllegalArgumentException("Value '" + text
                        + "' is not allowed");
            } else {
                return value;
            }
        }
    }
}
