
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetworkAdapterPromiscModePolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NetworkAdapterPromiscModePolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Deny"/>
 *     &lt;enumeration value="AllowNetwork"/>
 *     &lt;enumeration value="AllowAll"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NetworkAdapterPromiscModePolicy")
@XmlEnum
public enum NetworkAdapterPromiscModePolicy {

    @XmlEnumValue("Deny")
    DENY("Deny"),
    @XmlEnumValue("AllowNetwork")
    ALLOW_NETWORK("AllowNetwork"),
    @XmlEnumValue("AllowAll")
    ALLOW_ALL("AllowAll");
    private final String value;

    NetworkAdapterPromiscModePolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NetworkAdapterPromiscModePolicy fromValue(String v) {
        for (NetworkAdapterPromiscModePolicy c: NetworkAdapterPromiscModePolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
