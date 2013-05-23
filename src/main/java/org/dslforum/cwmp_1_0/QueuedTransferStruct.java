
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="QueuedTransferStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="CommandKey"/>
 *     &lt;xs:element name="State">
 *       &lt;xs:simpleType>
 *         &lt;!-- Reference to inner class State -->
 *       &lt;/xs:simpleType>
 *     &lt;/xs:element>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class QueuedTransferStruct
{
    private String commandKey;
    private State state;

    /** 
     * Get the 'CommandKey' element value.
     * 
     * @return value
     */
    public String getCommandKey() {
        return commandKey;
    }

    /** 
     * Set the 'CommandKey' element value.
     * 
     * @param commandKey
     */
    public void setCommandKey(String commandKey) {
        this.commandKey = commandKey;
    }

    /** 
     * Get the 'State' element value.
     * 
     * @return value
     */
    public State getState() {
        return state;
    }

    /** 
     * Set the 'State' element value.
     * 
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema">
     *   &lt;xs:restriction base="xs:int">
     *     &lt;xs:enumeration value="1"/>
     *     &lt;xs:enumeration value="2"/>
     *     &lt;xs:enumeration value="3"/>
     *   &lt;/xs:restriction>
     * &lt;/xs:simpleType>
     * </pre>
     */
    public static class State
    {
        private final String value;
        /** 
         * 1 - Not yet started
         */
        public static final State _1 = new State("1");
        /** 
         * 2 - In progress
         */
        public static final State _2 = new State("2");
        /** 
         * 3 - Completed
         */
        public static final State _3 = new State("3");
        private static final String[] values = new String[]{"1", "2", "3"};
        private static final State[] instances = new State[]{_1, _2, _3};

        private State(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static State convert(String value) {
            int index = java.util.Arrays.binarySearch(values, value);
            if (index >= 0) {
                return instances[index];
            } else {
                return null;
            }
        }

        public static State fromValue(String text) {
            State value = convert(text);
            if (value == null) {
                throw new IllegalArgumentException("Value '" + text
                        + "' is not allowed");
            } else {
                return value;
            }
        }
    }
}
