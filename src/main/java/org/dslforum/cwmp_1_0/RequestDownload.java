
package org.dslforum.cwmp_1_0;

/** 
 * RequestDownload message - Annex A.4.2.2
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="RequestDownload">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="FileType"/>
 *       &lt;xs:element type="ns:FileTypeArg" name="FileTypeArg"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class RequestDownload
{
    private String fileType;
    private FileTypeArg fileTypeArg;

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
     * Get the 'FileTypeArg' element value.
     * 
     * @return value
     */
    public FileTypeArg getFileTypeArg() {
        return fileTypeArg;
    }

    /** 
     * Set the 'FileTypeArg' element value.
     * 
     * @param fileTypeArg
     */
    public void setFileTypeArg(FileTypeArg fileTypeArg) {
        this.fileTypeArg = fileTypeArg;
    }
}
