
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HWVirtExPropertyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HWVirtExPropertyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="Enabled"/>
 *     &lt;enumeration value="Exclusive"/>
 *     &lt;enumeration value="VPID"/>
 *     &lt;enumeration value="NestedPaging"/>
 *     &lt;enumeration value="LargePages"/>
 *     &lt;enumeration value="Force"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HWVirtExPropertyType")
@XmlEnum
public enum HWVirtExPropertyType {

    @XmlEnumValue("Null")
    NULL("Null"),
    @XmlEnumValue("Enabled")
    ENABLED("Enabled"),
    @XmlEnumValue("Exclusive")
    EXCLUSIVE("Exclusive"),
    VPID("VPID"),
    @XmlEnumValue("NestedPaging")
    NESTED_PAGING("NestedPaging"),
    @XmlEnumValue("LargePages")
    LARGE_PAGES("LargePages"),
    @XmlEnumValue("Force")
    FORCE("Force");
    private final String value;

    HWVirtExPropertyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HWVirtExPropertyType fromValue(String v) {
        for (HWVirtExPropertyType c: HWVirtExPropertyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
