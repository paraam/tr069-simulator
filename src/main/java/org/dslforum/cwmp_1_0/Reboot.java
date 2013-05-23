
package org.dslforum.cwmp_1_0;

/** 
 * Reboot message - Annex A.3.2.9
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Reboot">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="CommandKey"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Reboot
{
    private String commandKey;

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
