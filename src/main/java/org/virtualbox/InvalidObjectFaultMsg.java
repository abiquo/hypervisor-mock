
package org.virtualbox;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2012-07-16T12:59:38.564+02:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "InvalidObjectFault", targetNamespace = "http://www.virtualbox.org/")
public class InvalidObjectFaultMsg extends Exception {
    
    private org.virtualbox.InvalidObjectFault invalidObjectFault;

    public InvalidObjectFaultMsg() {
        super();
    }
    
    public InvalidObjectFaultMsg(String message) {
        super(message);
    }
    
    public InvalidObjectFaultMsg(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidObjectFaultMsg(String message, org.virtualbox.InvalidObjectFault invalidObjectFault) {
        super(message);
        this.invalidObjectFault = invalidObjectFault;
    }

    public InvalidObjectFaultMsg(String message, org.virtualbox.InvalidObjectFault invalidObjectFault, Throwable cause) {
        super(message, cause);
        this.invalidObjectFault = invalidObjectFault;
    }

    public org.virtualbox.InvalidObjectFault getFaultInfo() {
        return this.invalidObjectFault;
    }
}