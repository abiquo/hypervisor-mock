package com.abiquo.aimstub.mock;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import scala.Option;

import com.abiquo.aimstub.finagle.Aim;
import com.abiquo.aimstub.finagle.mock.BootAimServerMock;
import com.twitter.finagle.builder.ClientBuilder;
import com.twitter.finagle.thrift.ClientId;
import com.twitter.finagle.thrift.ThriftClientFramedCodecFactory;
import com.twitter.util.FutureEventListener;

/**
 * Base test class to setup a thrift server running the {@link Aim} protocol.
 */
public class AimServerMockIT
{
    protected BootAimServerMock boot = new BootAimServerMock();

    protected Future< ? > blockedServer;

    protected Aim.ServiceIface aimclient;

    @BeforeClass(groups = {"it-all"})
    public void startAimServerMock() throws Exception
    {
        blockedServer = Executors.newSingleThreadExecutor().submit(new Runnable()
        {
            @Override
            public void run()
            {
                boot.startServer();
            }
        });

        aimclient =
            new Aim.ServiceToClient(ClientBuilder.safeBuild(ClientBuilder.get().hosts(
                new InetSocketAddress(BootAimServerMock.SERVER_PORT)).codec(
                new ThriftClientFramedCodecFactory(Option.apply(new ClientId("thriftclient")))) //
                .hostConnectionLimit(100)), new TBinaryProtocol.Factory());

        // be sure the Server Runnable is executed before returning
        int timeout = 10;
        boolean serverIsStarted = false;
        Exception lastException = null;
        while (!serverIsStarted && timeout > 0)
        {
            try
            {

                aimclient.checkRimpConfiguration().apply();
                serverIsStarted = true;
            }         
            catch (Exception e)
            {
                // server not yet started
                timeout--;
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e1)
                {
                }
                lastException = e;
            }
        }
        if (!serverIsStarted)
        {
            throw lastException;
        }
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

        aimclient.checkRimpConfiguration()//
            .addEventListener(new TestListener("checkRimpConfiguration"));

        aimclient.getDatastoreSize()//
            .addEventListener(new TestListener("getDatastoreSize"));

        aimclient.getDiskFileSize("virtualImageDatastorePath")//
            .addEventListener(new TestListener("getDiskFileSize"));

        aimclient.getDatastores()//
            .addEventListener(new TestListener("getDatastores"));

        aimclient.getNetInterfaces()//
            .addEventListener(new TestListener("getNetInterfaces"));

        aimclient.copyFromRepositoryToDatastore//
            ("virtualImageRepositoryPath", "datastorePath", "virtualMachineUUID")//
            .addEventListener(new TestListener("copyFromRepositoryToDatastore"));

        aimclient.deleteVirtualImageFromDatastore//
            ("datastorePath", "virtualMachineUUID")//
            .addEventListener(new TestListener("deleteVirtualImageFromDatastore"));

        aimclient.copyFromDatastoreToRepository//
            ("virtualMachineUUID", "snapshot", "destinationRepositoryPath", "sourceDatastorePath")//
            .addEventListener(new TestListener("copyFromDatastoreToRepository"));

        aimclient.createVLAN(vlanTag, "vlanInterface", "bridgeInterface")//
            .addEventListener(new TestListener("createVLAN"));

        aimclient.deleteVLAN(vlanTag, "vlanInterface", "bridgeInterface")//
            .addEventListener(new TestListener("deleteVLAN"));

        aimclient.checkVLANConfiguration()//
            .addEventListener(new TestListener("checkVLANConfiguration"));

        aimclient.getInitiatorIQN()//
            .addEventListener(new TestListener("getInitiatorIQN"));

    }

    class TestListener implements FutureEventListener<Object>
    {
        final String name;

        public TestListener(String name)
        {
            this.name = name;
        }

        @Override
        public void onFailure(Throwable e)
        {
            System.err.println("fail : " + name);
            e.printStackTrace();
            Assert.fail(name);
        }

        @Override
        public void onSuccess(Object win)
        {
            System.err.println("win : " + name);
        }

    }
}
