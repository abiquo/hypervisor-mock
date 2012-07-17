
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessorFeature.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProcessorFeature">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HWVirtEx"/>
 *     &lt;enumeration value="PAE"/>
 *     &lt;enumeration value="LongMode"/>
 *     &lt;enumeration value="NestedPaging"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProcessorFeature")
@XmlEnum
public enum ProcessorFeature {

    @XmlEnumValue("HWVirtEx")
    HW_VIRT_EX("HWVirtEx"),
    PAE("PAE"),
    @XmlEnumValue("LongMode")
    LONG_MODE("LongMode"),
    @XmlEnumValue("NestedPaging")
    NESTED_PAGING("NestedPaging");
    private final String value;

    ProcessorFeature(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcessorFeature fromValue(String v) {
        for (ProcessorFeature c: ProcessorFeature.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
