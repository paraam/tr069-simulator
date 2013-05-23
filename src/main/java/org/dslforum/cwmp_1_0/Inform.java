
package org.dslforum.cwmp_1_0;

import java.util.Date;

/** 
 * Inform message - Annex A.3.3.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Inform">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:DeviceIdStruct" name="DeviceId"/>
 *       &lt;xs:element type="ns:EventList" name="Event"/>
 *       &lt;xs:element type="xs:int" name="MaxEnvelopes"/>
 *       &lt;xs:element type="xs:dateTime" name="CurrentTime"/>
 *       &lt;xs:element type="xs:int" name="RetryCount"/>
 *       &lt;xs:element type="ns:ParameterValueList" name="ParameterList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Inform
{
    private DeviceIdStruct deviceId;
    private EventList event;
    private int maxEnvelopes;
    private Date currentTime;
    private int retryCount;
    private ParameterValueList parameterList;

    /** 
     * Get the 'DeviceId' element value.
     * 
     * @return value
     */
    public DeviceIdStruct getDeviceId() {
        return deviceId;
    }

    /** 
     * Set the 'DeviceId' element value.
     * 
     * @param deviceId
     */
    public void setDeviceId(DeviceIdStruct deviceId) {
        this.deviceId = deviceId;
    }

    /** 
     * Get the 'Event' element value.
     * 
     * @return value
     */
    public EventList getEvent() {
        return event;
    }

    /** 
     * Set the 'Event' element value.
     * 
     * @param event
     */
    public void setEvent(EventList event) {
        this.event = event;
    }

    /** 
     * Get the 'MaxEnvelopes' element value.
     * 
     * @return value
     */
    public int getMaxEnvelopes() {
        return maxEnvelopes;
    }

    /** 
     * Set the 'MaxEnvelopes' element value.
     * 
     * @param maxEnvelopes
     */
    public void setMaxEnvelopes(int maxEnvelopes) {
        this.maxEnvelopes = maxEnvelopes;
    }

    /** 
     * Get the 'CurrentTime' element value.
     * 
     * @return value
     */
    public Date getCurrentTime() {
        return currentTime;
    }

    /** 
     * Set the 'CurrentTime' element value.
     * 
     * @param currentTime
     */
    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    /** 
     * Get the 'RetryCount' element value.
     * 
     * @return value
     */
    public int getRetryCount() {
        return retryCount;
    }

    /** 
     * Set the 'RetryCount' element value.
     * 
     * @param retryCount
     */
    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    /** 
     * Get the 'ParameterList' element value.
     * 
     * @return value
     */
    public ParameterValueList getParameterList() {
        return parameterList;
    }

    /** 
     * Set the 'ParameterList' element value.
     * 
     * @param parameterList
     */
    public void setParameterList(ParameterValueList parameterList) {
        this.parameterList = parameterList;
    }
}
