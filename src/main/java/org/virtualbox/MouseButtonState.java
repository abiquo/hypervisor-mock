
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MouseButtonState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MouseButtonState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LeftButton"/>
 *     &lt;enumeration value="RightButton"/>
 *     &lt;enumeration value="MiddleButton"/>
 *     &lt;enumeration value="WheelUp"/>
 *     &lt;enumeration value="WheelDown"/>
 *     &lt;enumeration value="XButton1"/>
 *     &lt;enumeration value="XButton2"/>
 *     &lt;enumeration value="MouseStateMask"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MouseButtonState")
@XmlEnum
public enum MouseButtonState {

    @XmlEnumValue("LeftButton")
    LEFT_BUTTON("LeftButton"),
    @XmlEnumValue("RightButton")
    RIGHT_BUTTON("RightButton"),
    @XmlEnumValue("MiddleButton")
    MIDDLE_BUTTON("MiddleButton"),
    @XmlEnumValue("WheelUp")
    WHEEL_UP("WheelUp"),
    @XmlEnumValue("WheelDown")
    WHEEL_DOWN("WheelDown"),
    @XmlEnumValue("XButton1")
    X_BUTTON_1("XButton1"),
    @XmlEnumValue("XButton2")
    X_BUTTON_2("XButton2"),
    @XmlEnumValue("MouseStateMask")
    MOUSE_STATE_MASK("MouseStateMask");
    private final String value;

    MouseButtonState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MouseButtonState fromValue(String v) {
        for (MouseButtonState c: MouseButtonState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
