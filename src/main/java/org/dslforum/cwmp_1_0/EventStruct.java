
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="EventStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="EventCode"/>
 *     &lt;xs:element type="xs:string" name="CommandKey"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class EventStruct
{
    private String eventCode;
    private String commandKey;

    public EventStruct() {
        this.eventCode = "";
        this.commandKey = "";
    }

    /** 
     * Get the 'EventCode' element value.
     * 
     * @return value
     */
    public String getEventCode() {
        return eventCode;
    }

    /** 
     * Set the 'EventCode' element value.
     * 
     * @param eventCode
     */
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
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
