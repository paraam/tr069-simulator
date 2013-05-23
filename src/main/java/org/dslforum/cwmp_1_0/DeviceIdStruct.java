
package org.dslforum.cwmp_1_0;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="urn:dslforum-org:cwmp-1-0" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="DeviceIdStruct">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="Manufacturer"/>
 *     &lt;xs:element type="xs:string" name="OUI"/>
 *     &lt;xs:element type="xs:string" name="ProductClass"/>
 *     &lt;xs:element type="xs:string" name="SerialNumber"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class DeviceIdStruct
{
    private String manufacturer;
    private String OUI;
    private String productClass;
    private String serialNumber;

    /** 
     * Get the 'Manufacturer' element value.
     * 
     * @return value
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /** 
     * Set the 'Manufacturer' element value.
     * 
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /** 
     * Get the 'OUI' element value.
     * 
     * @return value
     */
    public String getOUI() {
        return OUI;
    }

    /** 
     * Set the 'OUI' element value.
     * 
     * @param OUI
     */
    public void setOUI(String OUI) {
        this.OUI = OUI;
    }

    /** 
     * Get the 'ProductClass' element value.
     * 
     * @return value
     */
    public String getProductClass() {
        return productClass;
    }

    /** 
     * Set the 'ProductClass' element value.
     * 
     * @param productClass
     */
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    /** 
     * Get the 'SerialNumber' element value.
     * 
     * @return value
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /** 
     * Set the 'SerialNumber' element value.
     * 
     * @param serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
