
package org.dslforum.cwmp_1_0;

/** 
 * Kicked message - Annex A.4.2.1
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Kicked">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="Command"/>
 *       &lt;xs:element type="xs:string" name="Referer"/>
 *       &lt;xs:element type="xs:string" name="Arg"/>
 *       &lt;xs:element type="xs:string" name="Next"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Kicked
{
    private String command;
    private String referer;
    private String arg;
    private String next;

    /** 
     * Get the 'Command' element value.
     * 
     * @return value
     */
    public String getCommand() {
        return command;
    }

    /** 
     * Set the 'Command' element value.
     * 
     * @param command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /** 
     * Get the 'Referer' element value.
     * 
     * @return value
     */
    public String getReferer() {
        return referer;
    }

    /** 
     * Set the 'Referer' element value.
     * 
     * @param referer
     */
    public void setReferer(String referer) {
        this.referer = referer;
    }

    /** 
     * Get the 'Arg' element value.
     * 
     * @return value
     */
    public String getArg() {
        return arg;
    }

    /** 
     * Set the 'Arg' element value.
     * 
     * @param arg
     */
    public void setArg(String arg) {
        this.arg = arg;
    }

    /** 
     * Get the 'Next' element value.
     * 
     * @return value
     */
    public String getNext() {
        return next;
    }

    /** 
     * Set the 'Next' element value.
     * 
     * @param next
     */
    public void setNext(String next) {
        this.next = next;
    }
}
