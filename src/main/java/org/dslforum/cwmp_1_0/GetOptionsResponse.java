
package org.dslforum.cwmp_1_0;

/** 
 * GetOptionsResponse message - Annex A.4.1.4
 * 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="GetOptionsResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:OptionList" name="OptionList"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class GetOptionsResponse
{
    private OptionList optionList;

    /** 
     * Get the 'OptionList' element value.
     * 
     * @return value
     */
    public OptionList getOptionList() {
        return optionList;
    }

    /** 
     * Set the 'OptionList' element value.
     * 
     * @param optionList
     */
    public void setOptionList(OptionList optionList) {
        this.optionList = optionList;
    }
}
