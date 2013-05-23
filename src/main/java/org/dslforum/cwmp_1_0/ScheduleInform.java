
package org.dslforum.cwmp_1_0;

/** 
 * ScheduleInform message - Annex A.4.1.2
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="ScheduleInform">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:int" name="DelaySeconds"/>
 *       &lt;xs:element type="xs:string" name="CommandKey"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class ScheduleInform
{
    private int delaySeconds;
    private String commandKey;

    /** 
     * Get the 'DelaySeconds' element value.
     * 
     * @return value
     */
    public int getDelaySeconds() {
        return delaySeconds;
    }

    /** 
     * Set the 'DelaySeconds' element value.
     * 
     * @param delaySeconds
     */
    public void setDelaySeconds(int delaySeconds) {
        this.delaySeconds = delaySeconds;
    }

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
}
