
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudioDriverType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AudioDriverType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="WinMM"/>
 *     &lt;enumeration value="OSS"/>
 *     &lt;enumeration value="ALSA"/>
 *     &lt;enumeration value="DirectSound"/>
 *     &lt;enumeration value="CoreAudio"/>
 *     &lt;enumeration value="MMPM"/>
 *     &lt;enumeration value="Pulse"/>
 *     &lt;enumeration value="SolAudio"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AudioDriverType")
@XmlEnum
public enum AudioDriverType {

    @XmlEnumValue("Null")
    NULL("Null"),
    @XmlEnumValue("WinMM")
    WIN_MM("WinMM"),
    OSS("OSS"),
    ALSA("ALSA"),
    @XmlEnumValue("DirectSound")
    DIRECT_SOUND("DirectSound"),
    @XmlEnumValue("CoreAudio")
    CORE_AUDIO("CoreAudio"),
    MMPM("MMPM"),
    @XmlEnumValue("Pulse")
    PULSE("Pulse"),
    @XmlEnumValue("SolAudio")
    SOL_AUDIO("SolAudio");
    private final String value;

    AudioDriverType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AudioDriverType fromValue(String v) {
        for (AudioDriverType c: AudioDriverType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
