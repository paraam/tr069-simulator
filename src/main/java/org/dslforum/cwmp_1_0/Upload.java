
package org.dslforum.cwmp_1_0;

/** 
 * Upload message - Annex A.4.1.5
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Upload">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="CommandKey"/>
 *       &lt;xs:element type="xs:string" name="FileType"/>
 *       &lt;xs:element type="xs:string" name="URL"/>
 *       &lt;xs:element type="xs:string" name="Username"/>
 *       &lt;xs:element type="xs:string" name="Password"/>
 *       &lt;xs:element type="xs:int" name="DelaySeconds"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Upload
{
    private String commandKey;
    private String fileType;
    private String URL;
    private String username;
    private String password;
    private int delaySeconds;

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
     * Get the 'FileType' element value.
     * 
     * @return value
     */
    public String getFileType() {
        return fileType;
    }

    /** 
     * Set the 'FileType' element value.
     * 
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /** 
     * Get the 'URL' element value.
     * 
     * @return value
     */
    public String getURL() {
        return URL;
    }

    /** 
     * Set the 'URL' element value.
     * 
     * @param URL
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /** 
     * Get the 'Username' element value.
     * 
     * @return value
     */
    public String getUsername() {
        return username;
    }

    /** 
     * Set the 'Username' element value.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 
     * Get the 'Password' element value.
     * 
     * @return value
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Set the 'Password' element value.
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

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
}
