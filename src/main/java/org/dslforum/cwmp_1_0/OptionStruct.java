
package org.dslforum.cwmp_1_0;

import java.util.Date;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="OptionStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="OptionName"/>
 *     &lt;xs:element type="xs:int" name="VoucherSN"/>
 *     &lt;xs:element name="State">
 *       &lt;xs:simpleType>
 *         &lt;!-- Reference to inner class State -->
 *       &lt;/xs:simpleType>
 *     &lt;/xs:element>
 *     &lt;xs:element name="Mode">
 *       &lt;xs:simpleType>
 *         &lt;!-- Reference to inner class Mode -->
 *       &lt;/xs:simpleType>
 *     &lt;/xs:element>
 *     &lt;xs:element type="xs:dateTime" name="StartDate"/>
 *     &lt;xs:element type="xs:dateTime" name="ExpirationDate" minOccurs="0"/>
 *     &lt;xs:element name="IsTransferable">
 *       &lt;xs:simpleType>
 *         &lt;!-- Reference to inner class IsTransferable -->
 *       &lt;/xs:simpleType>
 *     &lt;/xs:element>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class OptionStruct
{
    private String optionName;
    private int voucherSN;
    private State state;
    private Mode mode;
    private Date startDate;
    private Date expirationDate;
    private IsTransferable isTransferable;

    /** 
     * Get the 'OptionName' element value.
     * 
     * @return value
     */
    public String getOptionName() {
        return optionName;
    }

    /** 
     * Set the 'OptionName' element value.
     * 
     * @param optionName
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /** 
     * Get the 'VoucherSN' element value.
     * 
     * @return value
     */
    public int getVoucherSN() {
        return voucherSN;
    }

    /** 
     * Set the 'VoucherSN' element value.
     * 
     * @param voucherSN
     */
    public void setVoucherSN(int voucherSN) {
        this.voucherSN = voucherSN;
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
     * Get the 'Mode' element value.
     * 
     * @return value
     */
    public Mode getMode() {
        return mode;
    }

    /** 
     * Set the 'Mode' element value.
     * 
     * @param mode
     */
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /** 
     * Get the 'StartDate' element value.
     * 
     * @return value
     */
    public Date getStartDate() {
        return startDate;
    }

    /** 
     * Set the 'StartDate' element value.
     * 
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /** 
     * Get the 'ExpirationDate' element value.
     * 
     * @return value
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /** 
     * Set the 'ExpirationDate' element value.
     * 
     * @param expirationDate
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /** 
     * Get the 'IsTransferable' element value.
     * 
     * @return value
     */
    public IsTransferable getIsTransferable() {
        return isTransferable;
    }

    /** 
     * Set the 'IsTransferable' element value.
     * 
     * @param isTransferable
     */
    public void setIsTransferable(IsTransferable isTransferable) {
        this.isTransferable = isTransferable;
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:simpleType xmlns:xs="http://www.w3.org/2001/XMLSchema">
     *   &lt;xs:restriction base="xs:int">
     *     &lt;xs:enumeration value="0"/>
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
         * Option is disabled and not setup
         */
        public static final State _0 = new State("0");
        /** 
         * Option is enabled and not setup
         */
        public static final State _1 = new State("1");
        /** 
         * Option is disabled and setup
         */
        public static final State _2 = new State("2");
        /** 
         * Option is enabled and setup
         */
        public static final State _3 = new State("3");
        private static final String[] values = new String[]{"0", "1", "2", "3"};
        private static final State[] instances = new State[]{_0, _1, _2, _3};

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
    public static class Mode
    {
        private final String value;
        /** 
         * 0 - Disabled
         */
        public static final Mode _0 = new Mode("0");
        /** 
         * 1 - Enabled with expiration
         */
        public static final Mode _1 = new Mode("1");
        /** 
         * 2 - Enabled without expiration
         */
        public static final Mode _2 = new Mode("2");
        private static final String[] values = new String[]{"0", "1", "2"};
        private static final Mode[] instances = new Mode[]{_0, _1, _2};

        private Mode(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static Mode convert(String value) {
            int index = java.util.Arrays.binarySearch(values, value);
            if (index >= 0) {
                return instances[index];
            } else {
                return null;
            }
        }

        public static Mode fromValue(String text) {
            Mode value = convert(text);
            if (value == null) {
                throw new IllegalArgumentException("Value '" + text
                        + "' is not allowed");
            } else {
                return value;
            }
        }
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
    public static class IsTransferable
    {
        private final String value;
        /** 
         * Non-transferable
         */
        public static final IsTransferable _0 = new IsTransferable("0");
        /** 
         * Transferable
         */
        public static final IsTransferable _1 = new IsTransferable("1");
        private static final String[] values = new String[]{"0", "1"};
        private static final IsTransferable[] instances = new IsTransferable[]{
                _0, _1};

        private IsTransferable(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static IsTransferable convert(String value) {
            int index = java.util.Arrays.binarySearch(values, value);
            if (index >= 0) {
                return instances[index];
            } else {
                return null;
            }
        }

        public static IsTransferable fromValue(String text) {
            IsTransferable value = convert(text);
            if (value == null) {
                throw new IllegalArgumentException("Value '" + text
                        + "' is not allowed");
            } else {
                return value;
            }
        }
    }
}
