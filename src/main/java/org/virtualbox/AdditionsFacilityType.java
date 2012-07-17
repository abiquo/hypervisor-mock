
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdditionsFacilityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdditionsFacilityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="VBoxGuestDriver"/>
 *     &lt;enumeration value="AutoLogon"/>
 *     &lt;enumeration value="VBoxService"/>
 *     &lt;enumeration value="VBoxTrayClient"/>
 *     &lt;enumeration value="Seamless"/>
 *     &lt;enumeration value="Graphics"/>
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdditionsFacilityType")
@XmlEnum
public enum AdditionsFacilityType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("VBoxGuestDriver")
    V_BOX_GUEST_DRIVER("VBoxGuestDriver"),
    @XmlEnumValue("AutoLogon")
    AUTO_LOGON("AutoLogon"),
    @XmlEnumValue("VBoxService")
    V_BOX_SERVICE("VBoxService"),
    @XmlEnumValue("VBoxTrayClient")
    V_BOX_TRAY_CLIENT("VBoxTrayClient"),
    @XmlEnumValue("Seamless")
    SEAMLESS("Seamless"),
    @XmlEnumValue("Graphics")
    GRAPHICS("Graphics"),
    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    AdditionsFacilityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdditionsFacilityType fromValue(String v) {
        for (AdditionsFacilityType c: AdditionsFacilityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
