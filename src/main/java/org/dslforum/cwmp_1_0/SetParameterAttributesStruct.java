
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SetParameterAttributesStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" nillable="true" name="Name"/>
 *     &lt;xs:element type="xs:boolean" name="NotificationChange"/>
 *     &lt;xs:element name="Notification">
 *       &lt;xs:simpleType>
 *         &lt;!-- Reference to inner class Notification -->
 *       &lt;/xs:simpleType>
 *     &lt;/xs:element>
 *     &lt;xs:element type="xs:boolean" name="AccessListChange"/>
 *     &lt;xs:element type="ns:AccessList" name="AccessList"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class SetParameterAttributesStruct
{
    private String name;
    private boolean notificationChange;
    private Notification notification;
    private boolean accessListChange;
    private AccessList accessList;

    /** 
     * Get the 'Name' element value.
     * 
     * @return value
     */
    public String getName() {
        return name;
    }

    /** 
     * Set the 'Name' element value.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Get the 'NotificationChange' element value.
     * 
     * @return value
     */
    public boolean isNotificationChange() {
        return notificationChange;
    }

    /** 
     * Set the 'NotificationChange' element value.
     * 
     * @param notificationChange
     */
    public void setNotificationChange(boolean notificationChange) {
        this.notificationChange = notificationChange;
    }

    /** 
     * Get the 'Notification' element value.
     * 
     * @return value
     */
    public Notification getNotification() {
        return notification;
    }

    /** 
     * Set the 'Notification' element value.
     * 
     * @param notification
     */
    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    /** 
     * Get the 'AccessListChange' element value.
     * 
     * @return value
     */
    public boolean isAccessListChange() {
        return accessListChange;
    }

    /** 
     * Set the 'AccessListChange' element value.
     * 
     * @param accessListChange
     */
    public void setAccessListChange(boolean accessListChange) {
        this.accessListChange = accessListChange;
    }

    /** 
     * Get the 'AccessList' element value.
     * 
     * @return value
     */
    public AccessList getAccessList() {
        return accessList;
    }

    /** 
     * Set the 'AccessList' element value.
     * 
     * @param accessList
     */
    public void setAccessList(AccessList accessList) {
        this.accessList = accessList;
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema">
     *   &lt;xs:restriction base="xs:int">
     *     &lt;xs:enumeration value="0"/>
     *     &lt;xs:enumeration value="1"/>
     *     &lt;xs:enumeration value="2"/>
     *   &lt;/xs:restriction>
     * &lt;/xs:simpleType>
     * </pre>
     */
    public static class Notification
    {
        private final String value;
        /** 
         * Notification off. The CPE need not inform the ACS of a change to the specified parameter(s)
         */
        public static final Notification _0 = new Notification("0");
        /** 
         * Passive notification. Whenever the specified parameter value changes, the CPE MUST include the new value in the ParameterList in the Inform message that is sent the next time a session is established to the ACS
         */
        public static final Notification _1 = new Notification("1");
        /** 
         * Active notification. Whenever the specified parameter value changes, the CPE MUST initiate a session to the ACS, and include the new value in the ParameterList in the associated Inform message
         */
        public static final Notification _2 = new Notification("2");
        private static final String[] values = new String[]{"0", "1", "2"};
        private static final Notification[] instances = new Notification[]{_0,
                _1, _2};

        public Notification(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static Notification convert(String value) {
            int index = java.util.Arrays.binarySearch(values, value);
            if (index >= 0) {
                return instances[index];
            } else {
                return null;
            }
        }

        public static Notification fromValue(String text) {
            Notification value = convert(text);
            if (value == null) {
                throw new IllegalArgumentException("Value '" + text
                        + "' is not allowed");
            } else {
                return value;
            }
        }
    }
}
