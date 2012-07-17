
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CopyFileFlag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CopyFileFlag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Recursive"/>
 *     &lt;enumeration value="Update"/>
 *     &lt;enumeration value="FollowLinks"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CopyFileFlag")
@XmlEnum
public enum CopyFileFlag {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Recursive")
    RECURSIVE("Recursive"),
    @XmlEnumValue("Update")
    UPDATE("Update"),
    @XmlEnumValue("FollowLinks")
    FOLLOW_LINKS("FollowLinks");
    private final String value;

    CopyFileFlag(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CopyFileFlag fromValue(String v) {
        for (CopyFileFlag c: CopyFileFlag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
