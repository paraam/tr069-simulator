
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:attributeGroup xmlns:tns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="arrayAttributes">
 *   &lt;xs:attribute ref="tns:arrayType">
 *     &lt;!-- Reference to inner class ArrayType -->
 *   &lt;/xs:attribute>
 *   &lt;xs:attribute ref="tns:offset">
 *     &lt;!-- Reference to inner class Offset -->
 *   &lt;/xs:attribute>
 * &lt;/xs:attributeGroup>
 * </pre>
 */
public class ArrayAttributes
{
    private ArrayType arrayType;
    private Offset offset;

    /** 
     * Get the 'arrayType' attribute value.
     * 
     * @return value
     */
    public ArrayType getArrayType() {
        return arrayType;
    }

    /** 
     * Set the 'arrayType' attribute value.
     * 
     * @param arrayType
     */
    public void setArrayType(ArrayType arrayType) {
        this.arrayType = arrayType;
    }

    /** 
     * Get the 'offset' attribute value.
     * 
     * @return value
     */
    public Offset getOffset() {
        return offset;
    }

    /** 
     * Set the 'offset' attribute value.
     * 
     * @param offset
     */
    public void setOffset(Offset offset) {
        this.offset = offset;
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:attribute xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" ref="ns:arrayType"/>
     * 
     * &lt;xs:attribute xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" name="arrayType"/>
     * </pre>
     */
    public static class ArrayType
    {
        private String arrayType;

        /** 
         * Get the 'arrayType' attribute value.
         * 
         * @return value
         */
        public String getArrayType() {
            return arrayType;
        }

        /** 
         * Set the 'arrayType' attribute value.
         * 
         * @param arrayType
         */
        public void setArrayType(String arrayType) {
            this.arrayType = arrayType;
        }
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:attribute xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" ref="ns:offset"/>
     * 
     * &lt;xs:attribute xmlns:ns="http://schemas.xmlsoap.org/soap/encoding/" xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" name="offset"/>
     * </pre>
     */
    public static class Offset
    {
        private String offset;

        /** 
         * Get the 'offset' attribute value.
         * 
         * @return value
         */
        public String getOffset() {
            return offset;
        }

        /** 
         * Set the 'offset' attribute value.
         * 
         * @param offset
         */
        public void setOffset(String offset) {
            this.offset = offset;
        }
    }
}
