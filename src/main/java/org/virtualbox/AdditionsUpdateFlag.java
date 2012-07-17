
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdditionsUpdateFlag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdditionsUpdateFlag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="WaitForUpdateStartOnly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdditionsUpdateFlag")
@XmlEnum
public enum AdditionsUpdateFlag {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("WaitForUpdateStartOnly")
    WAIT_FOR_UPDATE_START_ONLY("WaitForUpdateStartOnly");
    private final String value;

    AdditionsUpdateFlag(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdditionsUpdateFlag fromValue(String v) {
        for (AdditionsUpdateFlag c: AdditionsUpdateFlag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
