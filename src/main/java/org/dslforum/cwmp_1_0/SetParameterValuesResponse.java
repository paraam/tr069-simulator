
package org.dslforum.cwmp_1_0;

/** 
 * SetParameterValuesResponse message - Annex A.3.2.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SetParameterValuesResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element name="Status">
 *         &lt;xs:simpleType>
 *           &lt;!-- Reference to inner class Status -->
 *         &lt;/xs:simpleType>
 *       &lt;/xs:element>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class SetParameterValuesResponse
{
    private Status status;

    /** 
     * Get the 'Status' element value.
     * 
     * @return value
     */
    public Status getStatus() {
        return status;
    }

    /** 
     * Set the 'Status' element value.
     * 
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema">
     *   &lt;xs:restriction base="xs:int">
     *     &lt;xs:enumeration value="0"/>
     *     &lt;xs:enumeration value="1"/>
     *   &lt;/xs:restriction>
     * &lt;/xs:simpleType>
     * </pre>
     */
    public static class Status
    {
        private final String value;
        /** 
         * All Parameter changes have been validated and applied
         */
        public static final Status _0 = new Status("0");
        /** 
         * All Parameter changes have been validated and committed, but some or all are not yet applied (for example, if a reboot is required before the new values are applied)
         */
        public static final Status _1 = new Status("1");
        private static final String[] values = new String[]{"0", "1"};
        private static final Status[] instances = new Status[]{_0, _1};

        private Status(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static Status convert(String value) {
            int index = java.util.Arrays.binarySearch(values, value);
            if (index >= 0) {
                return instances[index];
            } else {
                return null;
            }
        }

        public static Status fromValue(String text) {
            Status value = convert(text);
            if (value == null) {
                throw new IllegalArgumentException("Value '" + text
                        + "' is not allowed");
            } else {
                return value;
            }
        }
    }
}
