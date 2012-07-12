package com.abiquo.aimstub.mock;

import java.util.concurrent.Executors;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abiquo.aimstub.Aim;
import com.abiquo.aimstub.RimpException;
import com.abiquo.aimstub.VLanException;

/**
 * Starts a {@link BootAimServerMock#startServerNonBlocking()} and check it is available using a
 * TFramedTransport client
 */
public class AimServerMockNonBlockingIT extends AbsAimServerMockIT
{
    private TTransport clientFrameTransport;

    @Override
    @BeforeClass(groups = {"it-all"})
    public void startAimServerMock() throws TException
    {
        blockedServer = Executors.newSingleThreadExecutor().submit(new Runnable()
        {
            @Override
            public void run()
            {
                boot.startServerNonBlocking();
            }
        });

        clientFrameTransport =
            new TFramedTransport(new TSocket("localhost", BootAimServerMock.SERVER_PORT));
        aimclient = new Aim.Client(new TBinaryProtocol(clientFrameTransport));

        // be sure the Server Runnable is executed before opening the client connection
        int timeout = 10;
        boolean serverIsStarted = false;
        TTransportException lastException = null;
        while (!serverIsStarted && timeout > 0)
        {
            try
            {

                clientFrameTransport.open();
                serverIsStarted = true;
            }
            catch (TTransportException e)
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

    @Override
    @AfterClass(groups = {"it-all"})
    public void stopAimServerMock()
    {
        clientFrameTransport.close();

        boot.stopServer();
        blockedServer.cancel(true);
    }

    @Test(groups = {"it-all"})
    public void test_aimOperationsAllowed() throws RimpException, TException, VLanException
    {
        super.test_aimOperationsAllowed();
    }
}
