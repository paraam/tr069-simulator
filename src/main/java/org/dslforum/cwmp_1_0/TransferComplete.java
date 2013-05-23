
package org.dslforum.cwmp_1_0;

import java.util.Date;

/** 
 * TransferComplete message - Annex A.3.3.2
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="TransferComplete">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="CommandKey"/>
 *       &lt;xs:element type="ns:FaultStruct" name="FaultStruct"/>
 *       &lt;xs:element type="xs:dateTime" name="StartTime"/>
 *       &lt;xs:element type="xs:dateTime" name="CompleteTime"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class TransferComplete
{
    private String commandKey;
    private FaultStruct faultStruct;
    private Date startTime;
    private Date completeTime;

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
     * Get the 'FaultStruct' element value.
     * 
     * @return value
     */
    public FaultStruct getFaultStruct() {
        return faultStruct;
    }

    /** 
     * Set the 'FaultStruct' element value.
     * 
     * @param faultStruct
     */
    public void setFaultStruct(FaultStruct faultStruct) {
        this.faultStruct = faultStruct;
    }

    /** 
     * Get the 'StartTime' element value.
     * 
     * @return value
     */
    public Date getStartTime() {
        return startTime;
    }

    /** 
     * Set the 'StartTime' element value.
     * 
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /** 
     * Get the 'CompleteTime' element value.
     * 
     * @return value
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /** 
     * Set the 'CompleteTime' element value.
     * 
     * @param completeTime
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }
}
