package com.abiquo.vbox;

import javax.xml.ws.Endpoint;

import com.abiquo.aimstub.mock.BootAimServerMock;
import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.domain.DomainService;
import com.abiquo.mock.model.HostInfo;

/**
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 */
public class VboxPortType_VboxServicePort_Server
{

    /** TODO externalize */
    private static final int port = 18083;

    protected VboxPortType_VboxServicePort_Server() throws java.lang.Exception
    {
        System.out.println("Starting Server");
        Object implementor = new VboxPortTypeImpl();
        String address = "http://0.0.0.0" + ":" + port + "/";
        Endpoint.publish(address, implementor);
        startMock();
    }

    private BootAimServerMock startMock()
    {
        BootAimServerMock srv = new BootAimServerMock();
        srv.startServerBlocking();
        return srv;
    }

    public static void main(String args[]) throws java.lang.Exception
    {
        ConfigurationService configurationService = ConfigurationService.getInstance();
        HostInfo hostInfo = DomainService.getInstance();
        new VboxPortType_VboxServicePort_Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
