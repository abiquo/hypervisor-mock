
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VFSFileType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VFSFileType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Fifo"/>
 *     &lt;enumeration value="DevChar"/>
 *     &lt;enumeration value="Directory"/>
 *     &lt;enumeration value="DevBlock"/>
 *     &lt;enumeration value="File"/>
 *     &lt;enumeration value="SymLink"/>
 *     &lt;enumeration value="Socket"/>
 *     &lt;enumeration value="WhiteOut"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VFSFileType")
@XmlEnum
public enum VFSFileType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Fifo")
    FIFO("Fifo"),
    @XmlEnumValue("DevChar")
    DEV_CHAR("DevChar"),
    @XmlEnumValue("Directory")
    DIRECTORY("Directory"),
    @XmlEnumValue("DevBlock")
    DEV_BLOCK("DevBlock"),
    @XmlEnumValue("File")
    FILE("File"),
    @XmlEnumValue("SymLink")
    SYM_LINK("SymLink"),
    @XmlEnumValue("Socket")
    SOCKET("Socket"),
    @XmlEnumValue("WhiteOut")
    WHITE_OUT("WhiteOut");
    private final String value;

    VFSFileType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VFSFileType fromValue(String v) {
        for (VFSFileType c: VFSFileType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
