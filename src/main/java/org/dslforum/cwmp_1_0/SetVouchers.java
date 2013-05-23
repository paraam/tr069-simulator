
package org.dslforum.cwmp_1_0;

/** 
 * SetVouchers message - Annex A.4.1.3
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SetVouchers">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:VoucherList" name="VoucherList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class SetVouchers
{
    private VoucherList voucherList;

    /** 
     * Get the 'VoucherList' element value.
     * 
     * @return value
     */
    public VoucherList getVoucherList() {
        return voucherList;
    }

    /** 
     * Set the 'VoucherList' element value.
     * 
     * @param voucherList
     */
    public void setVoucherList(VoucherList voucherList) {
        this.voucherList = voucherList;
    }
}
