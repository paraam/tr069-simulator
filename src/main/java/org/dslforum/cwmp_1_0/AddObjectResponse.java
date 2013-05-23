
package org.dslforum.cwmp_1_0;

/** 
 * AddObjectResponse message - Annex A.3.2.6
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AddObjectResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:int" name="InstanceNumber"/>
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
public class AddObjectResponse
{
    private int instanceNumber;
    private Status status;

    /** 
     * Get the 'InstanceNumber' element value.
     * 
     * @return value
     */
    public int getInstanceNumber() {
        return instanceNumber;
    }

    /** 
     * Set the 'InstanceNumber' element value.
     * 
     * @param instanceNumber
     */
    public void setInstanceNumber(int instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

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
         * The object has been created
         */
        public static final Status _0 = new Status("0");
        /** 
         * The object creation has been validated and committed, but not yet applied
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
