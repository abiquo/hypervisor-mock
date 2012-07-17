
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediumFormatCapabilities.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MediumFormatCapabilities">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Uuid"/>
 *     &lt;enumeration value="CreateFixed"/>
 *     &lt;enumeration value="CreateDynamic"/>
 *     &lt;enumeration value="CreateSplit2G"/>
 *     &lt;enumeration value="Differencing"/>
 *     &lt;enumeration value="Asynchronous"/>
 *     &lt;enumeration value="File"/>
 *     &lt;enumeration value="Properties"/>
 *     &lt;enumeration value="TcpNetworking"/>
 *     &lt;enumeration value="VFS"/>
 *     &lt;enumeration value="CapabilityMask"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MediumFormatCapabilities")
@XmlEnum
public enum MediumFormatCapabilities {

    @XmlEnumValue("Uuid")
    UUID("Uuid"),
    @XmlEnumValue("CreateFixed")
    CREATE_FIXED("CreateFixed"),
    @XmlEnumValue("CreateDynamic")
    CREATE_DYNAMIC("CreateDynamic"),
    @XmlEnumValue("CreateSplit2G")
    CREATE_SPLIT_2_G("CreateSplit2G"),
    @XmlEnumValue("Differencing")
    DIFFERENCING("Differencing"),
    @XmlEnumValue("Asynchronous")
    ASYNCHRONOUS("Asynchronous"),
    @XmlEnumValue("File")
    FILE("File"),
    @XmlEnumValue("Properties")
    PROPERTIES("Properties"),
    @XmlEnumValue("TcpNetworking")
    TCP_NETWORKING("TcpNetworking"),
    VFS("VFS"),
    @XmlEnumValue("CapabilityMask")
    CAPABILITY_MASK("CapabilityMask");
    private final String value;

    MediumFormatCapabilities(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MediumFormatCapabilities fromValue(String v) {
        for (MediumFormatCapabilities c: MediumFormatCapabilities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
