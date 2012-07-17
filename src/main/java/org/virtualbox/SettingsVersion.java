
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SettingsVersion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SettingsVersion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="v1_0"/>
 *     &lt;enumeration value="v1_1"/>
 *     &lt;enumeration value="v1_2"/>
 *     &lt;enumeration value="v1_3pre"/>
 *     &lt;enumeration value="v1_3"/>
 *     &lt;enumeration value="v1_4"/>
 *     &lt;enumeration value="v1_5"/>
 *     &lt;enumeration value="v1_6"/>
 *     &lt;enumeration value="v1_7"/>
 *     &lt;enumeration value="v1_8"/>
 *     &lt;enumeration value="v1_9"/>
 *     &lt;enumeration value="v1_10"/>
 *     &lt;enumeration value="v1_11"/>
 *     &lt;enumeration value="v1_12"/>
 *     &lt;enumeration value="Future"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SettingsVersion")
@XmlEnum
public enum SettingsVersion {

    @XmlEnumValue("Null")
    NULL("Null"),
    @XmlEnumValue("v1_0")
    V_1_0("v1_0"),
    @XmlEnumValue("v1_1")
    V_1_1("v1_1"),
    @XmlEnumValue("v1_2")
    V_1_2("v1_2"),
    @XmlEnumValue("v1_3pre")
    V_1_3_PRE("v1_3pre"),
    @XmlEnumValue("v1_3")
    V_1_3("v1_3"),
    @XmlEnumValue("v1_4")
    V_1_4("v1_4"),
    @XmlEnumValue("v1_5")
    V_1_5("v1_5"),
    @XmlEnumValue("v1_6")
    V_1_6("v1_6"),
    @XmlEnumValue("v1_7")
    V_1_7("v1_7"),
    @XmlEnumValue("v1_8")
    V_1_8("v1_8"),
    @XmlEnumValue("v1_9")
    V_1_9("v1_9"),
    @XmlEnumValue("v1_10")
    V_1_10("v1_10"),
    @XmlEnumValue("v1_11")
    V_1_11("v1_11"),
    @XmlEnumValue("v1_12")
    V_1_12("v1_12"),
    @XmlEnumValue("Future")
    FUTURE("Future");
    private final String value;

    SettingsVersion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SettingsVersion fromValue(String v) {
        for (SettingsVersion c: SettingsVersion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
