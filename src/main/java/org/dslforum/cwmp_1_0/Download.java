
package org.dslforum.cwmp_1_0;

/** 
 * Download message - Annex A.3.2.8
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Download">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="CommandKey"/>
 *       &lt;xs:element type="xs:string" name="FileType"/>
 *       &lt;xs:element type="xs:string" name="URL"/>
 *       &lt;xs:element type="xs:string" name="Username"/>
 *       &lt;xs:element type="xs:string" name="Password"/>
 *       &lt;xs:element type="xs:int" name="FileSize"/>
 *       &lt;xs:element type="xs:string" name="TargetFileName"/>
 *       &lt;xs:element type="xs:int" name="DelaySeconds"/>
 *       &lt;xs:element type="xs:string" name="SuccessURL"/>
 *       &lt;xs:element type="xs:string" name="FailureURL"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Download
{
    private String commandKey;
    private String fileType;
    private String URL;
    private String username;
    private String password;
    private int fileSize;
    private String targetFileName;
    private int delaySeconds;
    private String successURL;
    private String failureURL;

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
     * Get the 'FileSize' element value.
     * 
     * @return value
     */
    public int getFileSize() {
        return fileSize;
    }

    /** 
     * Set the 'FileSize' element value.
     * 
     * @param fileSize
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    /** 
     * Get the 'TargetFileName' element value.
     * 
     * @return value
     */
    public String getTargetFileName() {
        return targetFileName;
    }

    /** 
     * Set the 'TargetFileName' element value.
     * 
     * @param targetFileName
     */
    public void setTargetFileName(String targetFileName) {
        this.targetFileName = targetFileName;
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

    /** 
     * Get the 'SuccessURL' element value.
     * 
     * @return value
     */
    public String getSuccessURL() {
        return successURL;
    }

    /** 
     * Set the 'SuccessURL' element value.
     * 
     * @param successURL
     */
    public void setSuccessURL(String successURL) {
        this.successURL = successURL;
    }

    /** 
     * Get the 'FailureURL' element value.
     * 
     * @return value
     */
    public String getFailureURL() {
        return failureURL;
    }

    /** 
     * Set the 'FailureURL' element value.
     * 
     * @param failureURL
     */
    public void setFailureURL(String failureURL) {
        this.failureURL = failureURL;
    }
}
