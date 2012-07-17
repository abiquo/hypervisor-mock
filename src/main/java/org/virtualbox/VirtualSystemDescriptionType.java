
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualSystemDescriptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualSystemDescriptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ignore"/>
 *     &lt;enumeration value="OS"/>
 *     &lt;enumeration value="Name"/>
 *     &lt;enumeration value="Product"/>
 *     &lt;enumeration value="Vendor"/>
 *     &lt;enumeration value="Version"/>
 *     &lt;enumeration value="ProductUrl"/>
 *     &lt;enumeration value="VendorUrl"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="License"/>
 *     &lt;enumeration value="Miscellaneous"/>
 *     &lt;enumeration value="CPU"/>
 *     &lt;enumeration value="Memory"/>
 *     &lt;enumeration value="HardDiskControllerIDE"/>
 *     &lt;enumeration value="HardDiskControllerSATA"/>
 *     &lt;enumeration value="HardDiskControllerSCSI"/>
 *     &lt;enumeration value="HardDiskControllerSAS"/>
 *     &lt;enumeration value="HardDiskImage"/>
 *     &lt;enumeration value="Floppy"/>
 *     &lt;enumeration value="CDROM"/>
 *     &lt;enumeration value="NetworkAdapter"/>
 *     &lt;enumeration value="USBController"/>
 *     &lt;enumeration value="SoundCard"/>
 *     &lt;enumeration value="SettingsFile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualSystemDescriptionType")
@XmlEnum
public enum VirtualSystemDescriptionType {

    @XmlEnumValue("Ignore")
    IGNORE("Ignore"),
    OS("OS"),
    @XmlEnumValue("Name")
    NAME("Name"),
    @XmlEnumValue("Product")
    PRODUCT("Product"),
    @XmlEnumValue("Vendor")
    VENDOR("Vendor"),
    @XmlEnumValue("Version")
    VERSION("Version"),
    @XmlEnumValue("ProductUrl")
    PRODUCT_URL("ProductUrl"),
    @XmlEnumValue("VendorUrl")
    VENDOR_URL("VendorUrl"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("License")
    LICENSE("License"),
    @XmlEnumValue("Miscellaneous")
    MISCELLANEOUS("Miscellaneous"),
    CPU("CPU"),
    @XmlEnumValue("Memory")
    MEMORY("Memory"),
    @XmlEnumValue("HardDiskControllerIDE")
    HARD_DISK_CONTROLLER_IDE("HardDiskControllerIDE"),
    @XmlEnumValue("HardDiskControllerSATA")
    HARD_DISK_CONTROLLER_SATA("HardDiskControllerSATA"),
    @XmlEnumValue("HardDiskControllerSCSI")
    HARD_DISK_CONTROLLER_SCSI("HardDiskControllerSCSI"),
    @XmlEnumValue("HardDiskControllerSAS")
    HARD_DISK_CONTROLLER_SAS("HardDiskControllerSAS"),
    @XmlEnumValue("HardDiskImage")
    HARD_DISK_IMAGE("HardDiskImage"),
    @XmlEnumValue("Floppy")
    FLOPPY("Floppy"),
    CDROM("CDROM"),
    @XmlEnumValue("NetworkAdapter")
    NETWORK_ADAPTER("NetworkAdapter"),
    @XmlEnumValue("USBController")
    USB_CONTROLLER("USBController"),
    @XmlEnumValue("SoundCard")
    SOUND_CARD("SoundCard"),
    @XmlEnumValue("SettingsFile")
    SETTINGS_FILE("SettingsFile");
    private final String value;

    VirtualSystemDescriptionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualSystemDescriptionType fromValue(String v) {
        for (VirtualSystemDescriptionType c: VirtualSystemDescriptionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
