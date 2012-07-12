package com.abiquo.aimstub.mock;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abiquo.aimstub.Aim.Iface;
import com.abiquo.aimstub.RimpException;
import com.abiquo.aimstub.TTransportProxy;
import com.abiquo.aimstub.finagle.mock.BootAimServerMock;

/**
 * Base test class to setup a thrift server running the {@link Aim} protocol.
 * <p>
 * It test the twitter finangle based sever but uses the regular ''am-client-java'' libraries
 */
public class AimServerMockIT
{
    protected BootAimServerMock boot = new BootAimServerMock();

    protected Future<?> blockedServer;
    
    protected Iface aimclient;
    

    @BeforeClass(groups = {"it-all"})
    public void startAimServerMock() throws TException
    {
        blockedServer = Executors.newSingleThreadExecutor().submit(new Runnable()
        {
            @Override
            public void run()
            {
                boot.startServer();
            }
        });

        try
      {
          Thread.sleep(2000);
      }
      catch (InterruptedException e1)
      {
      }
        
        aimclient = TTransportProxy.getInstance("localhost", BootAimServerMock.SERVER_PORT);

//        // be sure the Server Runnable is executed before returning
//        int timeout = 10;
//        boolean serverIsStarted = false;
//        TException lastException = null;
//        while (!serverIsStarted && timeout > 0)
//        {
//            try
//            {
//
//                aimclient.checkRimpConfiguration();
//                serverIsStarted = true;
//            }
//            catch (RimpException e)
//            {
//                // aim logic error, the server is started
//            }
//            catch (TException e)
//            {
//                // server not yet started
//                timeout--;
//                try
//                {
//                    Thread.sleep(100);
//                }
//                catch (InterruptedException e1)
//                {
//                }
//                lastException = e;
//            }
//        }
//        if(!serverIsStarted)
//        {
//            throw lastException;
//        }
    }

    @AfterClass(groups = {"it-all"})
    public void stopAimServerMock()
    {
        boot.stopServer();
        blockedServer.cancel(true);
    }

    @Test(groups = {"it-all"})
    public void test_aimOperationsAllowed() throws Exception
    {
        int vlanTag = 0;

        aimclient.checkRimpConfiguration();

        aimclient.getDatastoreSize();

        aimclient.getDiskFileSize("virtualImageDatastorePath");

        aimclient.getDatastores();

        aimclient.getNetInterfaces();

        aimclient.copyFromRepositoryToDatastore//
            ("virtualImageRepositoryPath", "datastorePath", "virtualMachineUUID");

        aimclient.deleteVirtualImageFromDatastore//
            ("datastorePath", "virtualMachineUUID");

        aimclient.copyFromDatastoreToRepository//
            ("virtualMachineUUID", "snapshot", "destinationRepositoryPath", "sourceDatastorePath");

        aimclient.createVLAN(vlanTag, "vlanInterface", "bridgeInterface");

        aimclient.deleteVLAN(vlanTag, "vlanInterface", "bridgeInterface");

        aimclient.checkVLANConfiguration();

        aimclient.getInitiatorIQN();
    }
}
