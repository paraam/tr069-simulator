
package org.dslforum.cwmp_1_0;

/** 
 * GetOptions message - Annex A.4.1.4
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetOptions">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="OptionName"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetOptions
{
    private String optionName;

    /** 
     * Get the 'OptionName' element value.
     * 
     * @return value
     */
    public String getOptionName() {
        return optionName;
    }

    /** 
     * Set the 'OptionName' element value.
     * 
     * @param optionName
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
