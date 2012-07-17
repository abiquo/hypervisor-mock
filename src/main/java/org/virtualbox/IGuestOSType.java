
package org.virtualbox;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IGuestOSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IGuestOSType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="familyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="familyDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="is64Bit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedIOAPIC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedVirtEx" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedRAM" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="recommendedVRAM" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="recommendedHDD" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="adapterType" type="{http://www.virtualbox.org/}NetworkAdapterType"/>
 *         &lt;element name="recommendedPae" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedDvdStorageController" type="{http://www.virtualbox.org/}StorageControllerType"/>
 *         &lt;element name="recommendedDvdStorageBus" type="{http://www.virtualbox.org/}StorageBus"/>
 *         &lt;element name="recommendedHdStorageController" type="{http://www.virtualbox.org/}StorageControllerType"/>
 *         &lt;element name="recommendedHdStorageBus" type="{http://www.virtualbox.org/}StorageBus"/>
 *         &lt;element name="recommendedFirmware" type="{http://www.virtualbox.org/}FirmwareType"/>
 *         &lt;element name="recommendedUsbHid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedHpet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedUsbTablet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedRtcUseUtc" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="recommendedChipset" type="{http://www.virtualbox.org/}ChipsetType"/>
 *         &lt;element name="recommendedAudioController" type="{http://www.virtualbox.org/}AudioControllerType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IGuestOSType", propOrder = {
    "familyId",
    "familyDescription",
    "id",
    "description",
    "is64Bit",
    "recommendedIOAPIC",
    "recommendedVirtEx",
    "recommendedRAM",
    "recommendedVRAM",
    "recommendedHDD",
    "adapterType",
    "recommendedPae",
    "recommendedDvdStorageController",
    "recommendedDvdStorageBus",
    "recommendedHdStorageController",
    "recommendedHdStorageBus",
    "recommendedFirmware",
    "recommendedUsbHid",
    "recommendedHpet",
    "recommendedUsbTablet",
    "recommendedRtcUseUtc",
    "recommendedChipset",
    "recommendedAudioController"
})
public class IGuestOSType {

    @XmlElement(required = true)
    protected String familyId;
    @XmlElement(required = true)
    protected String familyDescription;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String description;
    protected boolean is64Bit;
    protected boolean recommendedIOAPIC;
    protected boolean recommendedVirtEx;
    @XmlSchemaType(name = "unsignedInt")
    protected long recommendedRAM;
    @XmlSchemaType(name = "unsignedInt")
    protected long recommendedVRAM;
    protected long recommendedHDD;
    @XmlElement(required = true)
    protected NetworkAdapterType adapterType;
    protected boolean recommendedPae;
    @XmlElement(required = true)
    protected StorageControllerType recommendedDvdStorageController;
    @XmlElement(required = true)
    protected StorageBus recommendedDvdStorageBus;
    @XmlElement(required = true)
    protected StorageControllerType recommendedHdStorageController;
    @XmlElement(required = true)
    protected StorageBus recommendedHdStorageBus;
    @XmlElement(required = true)
    protected FirmwareType recommendedFirmware;
    protected boolean recommendedUsbHid;
    protected boolean recommendedHpet;
    protected boolean recommendedUsbTablet;
    protected boolean recommendedRtcUseUtc;
    @XmlElement(required = true)
    protected ChipsetType recommendedChipset;
    @XmlElement(required = true)
    protected AudioControllerType recommendedAudioController;

    /**
     * Gets the value of the familyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyId() {
        return familyId;
    }

    /**
     * Sets the value of the familyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyId(String value) {
        this.familyId = value;
    }

    /**
     * Gets the value of the familyDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyDescription() {
        return familyDescription;
    }

    /**
     * Sets the value of the familyDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyDescription(String value) {
        this.familyDescription = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the is64Bit property.
     * 
     */
    public boolean isIs64Bit() {
        return is64Bit;
    }

    /**
     * Sets the value of the is64Bit property.
     * 
     */
    public void setIs64Bit(boolean value) {
        this.is64Bit = value;
    }

    /**
     * Gets the value of the recommendedIOAPIC property.
     * 
     */
    public boolean isRecommendedIOAPIC() {
        return recommendedIOAPIC;
    }

    /**
     * Sets the value of the recommendedIOAPIC property.
     * 
     */
    public void setRecommendedIOAPIC(boolean value) {
        this.recommendedIOAPIC = value;
    }

    /**
     * Gets the value of the recommendedVirtEx property.
     * 
     */
    public boolean isRecommendedVirtEx() {
        return recommendedVirtEx;
    }

    /**
     * Sets the value of the recommendedVirtEx property.
     * 
     */
    public void setRecommendedVirtEx(boolean value) {
        this.recommendedVirtEx = value;
    }

    /**
     * Gets the value of the recommendedRAM property.
     * 
     */
    public long getRecommendedRAM() {
        return recommendedRAM;
    }

    /**
     * Sets the value of the recommendedRAM property.
     * 
     */
    public void setRecommendedRAM(long value) {
        this.recommendedRAM = value;
    }

    /**
     * Gets the value of the recommendedVRAM property.
     * 
     */
    public long getRecommendedVRAM() {
        return recommendedVRAM;
    }

    /**
     * Sets the value of the recommendedVRAM property.
     * 
     */
    public void setRecommendedVRAM(long value) {
        this.recommendedVRAM = value;
    }

    /**
     * Gets the value of the recommendedHDD property.
     * 
     */
    public long getRecommendedHDD() {
        return recommendedHDD;
    }

    /**
     * Sets the value of the recommendedHDD property.
     * 
     */
    public void setRecommendedHDD(long value) {
        this.recommendedHDD = value;
    }

    /**
     * Gets the value of the adapterType property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkAdapterType }
     *     
     */
    public NetworkAdapterType getAdapterType() {
        return adapterType;
    }

    /**
     * Sets the value of the adapterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkAdapterType }
     *     
     */
    public void setAdapterType(NetworkAdapterType value) {
        this.adapterType = value;
    }

    /**
     * Gets the value of the recommendedPae property.
     * 
     */
    public boolean isRecommendedPae() {
        return recommendedPae;
    }

    /**
     * Sets the value of the recommendedPae property.
     * 
     */
    public void setRecommendedPae(boolean value) {
        this.recommendedPae = value;
    }

    /**
     * Gets the value of the recommendedDvdStorageController property.
     * 
     * @return
     *     possible object is
     *     {@link StorageControllerType }
     *     
     */
    public StorageControllerType getRecommendedDvdStorageController() {
        return recommendedDvdStorageController;
    }

    /**
     * Sets the value of the recommendedDvdStorageController property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageControllerType }
     *     
     */
    public void setRecommendedDvdStorageController(StorageControllerType value) {
        this.recommendedDvdStorageController = value;
    }

    /**
     * Gets the value of the recommendedDvdStorageBus property.
     * 
     * @return
     *     possible object is
     *     {@link StorageBus }
     *     
     */
    public StorageBus getRecommendedDvdStorageBus() {
        return recommendedDvdStorageBus;
    }

    /**
     * Sets the value of the recommendedDvdStorageBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageBus }
     *     
     */
    public void setRecommendedDvdStorageBus(StorageBus value) {
        this.recommendedDvdStorageBus = value;
    }

    /**
     * Gets the value of the recommendedHdStorageController property.
     * 
     * @return
     *     possible object is
     *     {@link StorageControllerType }
     *     
     */
    public StorageControllerType getRecommendedHdStorageController() {
        return recommendedHdStorageController;
    }

    /**
     * Sets the value of the recommendedHdStorageController property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageControllerType }
     *     
     */
    public void setRecommendedHdStorageController(StorageControllerType value) {
        this.recommendedHdStorageController = value;
    }

    /**
     * Gets the value of the recommendedHdStorageBus property.
     * 
     * @return
     *     possible object is
     *     {@link StorageBus }
     *     
     */
    public StorageBus getRecommendedHdStorageBus() {
        return recommendedHdStorageBus;
    }

    /**
     * Sets the value of the recommendedHdStorageBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageBus }
     *     
     */
    public void setRecommendedHdStorageBus(StorageBus value) {
        this.recommendedHdStorageBus = value;
    }

    /**
     * Gets the value of the recommendedFirmware property.
     * 
     * @return
     *     possible object is
     *     {@link FirmwareType }
     *     
     */
    public FirmwareType getRecommendedFirmware() {
        return recommendedFirmware;
    }

    /**
     * Sets the value of the recommendedFirmware property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirmwareType }
     *     
     */
    public void setRecommendedFirmware(FirmwareType value) {
        this.recommendedFirmware = value;
    }

    /**
     * Gets the value of the recommendedUsbHid property.
     * 
     */
    public boolean isRecommendedUsbHid() {
        return recommendedUsbHid;
    }

    /**
     * Sets the value of the recommendedUsbHid property.
     * 
     */
    public void setRecommendedUsbHid(boolean value) {
        this.recommendedUsbHid = value;
    }

    /**
     * Gets the value of the recommendedHpet property.
     * 
     */
    public boolean isRecommendedHpet() {
        return recommendedHpet;
    }

    /**
     * Sets the value of the recommendedHpet property.
     * 
     */
    public void setRecommendedHpet(boolean value) {
        this.recommendedHpet = value;
    }

    /**
     * Gets the value of the recommendedUsbTablet property.
     * 
     */
    public boolean isRecommendedUsbTablet() {
        return recommendedUsbTablet;
    }

    /**
     * Sets the value of the recommendedUsbTablet property.
     * 
     */
    public void setRecommendedUsbTablet(boolean value) {
        this.recommendedUsbTablet = value;
    }

    /**
     * Gets the value of the recommendedRtcUseUtc property.
     * 
     */
    public boolean isRecommendedRtcUseUtc() {
        return recommendedRtcUseUtc;
    }

    /**
     * Sets the value of the recommendedRtcUseUtc property.
     * 
     */
    public void setRecommendedRtcUseUtc(boolean value) {
        this.recommendedRtcUseUtc = value;
    }

    /**
     * Gets the value of the recommendedChipset property.
     * 
     * @return
     *     possible object is
     *     {@link ChipsetType }
     *     
     */
    public ChipsetType getRecommendedChipset() {
        return recommendedChipset;
    }

    /**
     * Sets the value of the recommendedChipset property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChipsetType }
     *     
     */
    public void setRecommendedChipset(ChipsetType value) {
        this.recommendedChipset = value;
    }

    /**
     * Gets the value of the recommendedAudioController property.
     * 
     * @return
     *     possible object is
     *     {@link AudioControllerType }
     *     
     */
    public AudioControllerType getRecommendedAudioController() {
        return recommendedAudioController;
    }

    /**
     * Sets the value of the recommendedAudioController property.
     * 
     * @param value
     *     allowed object is
     *     {@link AudioControllerType }
     *     
     */
    public void setRecommendedAudioController(AudioControllerType value) {
        this.recommendedAudioController = value;
    }

}
