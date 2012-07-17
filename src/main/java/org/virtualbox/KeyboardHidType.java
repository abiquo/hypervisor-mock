
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeyboardHidType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KeyboardHidType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="PS2Keyboard"/>
 *     &lt;enumeration value="USBKeyboard"/>
 *     &lt;enumeration value="ComboKeyboard"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KeyboardHidType")
@XmlEnum
public enum KeyboardHidType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("PS2Keyboard")
    PS_2_KEYBOARD("PS2Keyboard"),
    @XmlEnumValue("USBKeyboard")
    USB_KEYBOARD("USBKeyboard"),
    @XmlEnumValue("ComboKeyboard")
    COMBO_KEYBOARD("ComboKeyboard");
    private final String value;

    KeyboardHidType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KeyboardHidType fromValue(String v) {
        for (KeyboardHidType c: KeyboardHidType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
