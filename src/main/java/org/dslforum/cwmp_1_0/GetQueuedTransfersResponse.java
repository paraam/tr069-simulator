
package org.dslforum.cwmp_1_0;

/** 
 * GetQueuedTransfersResponse message - Annex A.4.1.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetQueuedTransfersResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:TransferList" name="TransferList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetQueuedTransfersResponse
{
    private TransferList transferList;

    /** 
     * Get the 'TransferList' element value.
     * 
     * @return value
     */
    public TransferList getTransferList() {
        return transferList;
    }

    /** 
     * Set the 'TransferList' element value.
     * 
     * @param transferList
     */
    public void setTransferList(TransferList transferList) {
        this.transferList = transferList;
    }
}
