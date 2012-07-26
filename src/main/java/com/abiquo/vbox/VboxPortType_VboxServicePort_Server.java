package com.abiquo.vbox;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.ws.Endpoint;

import com.abiquo.aimstub.mock.BootAimServerMock;
import com.abiquo.vbox.mock.VboxPortTypeMock;

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
        Object implementor = new VboxPortTypeMock();
        String address = "http://0.0.0.0" + ":" + port + "/";
        Endpoint.publish(address, implementor);

        startMock().get(); // block
    }

    private Future startMock()
    {
        return Executors.newSingleThreadExecutor().submit(new Runnable()
        {
            @Override
            public void run()
            {
                BootAimServerMock srv = new BootAimServerMock();
                srv.startServerBlocking();
            }
        });
    }

    public static void main(final String args[]) throws java.lang.Exception
    {
        new VboxPortType_VboxServicePort_Server();
    }
}
