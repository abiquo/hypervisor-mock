package com.abiquo.aimstub.mock;

import java.util.concurrent.Executors;

import org.apache.thrift.TException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abiquo.aimstub.RimpException;
import com.abiquo.aimstub.StorageException;
import com.abiquo.aimstub.TTransportProxy;
import com.abiquo.aimstub.VLanException;

/**
 * Starts a {@link BootAimServerMock#startServerBlocking()} and check it is available using a
 * TTransport client
 */
public class AimServerMockBlockingIT extends AbsAimServerMockIT
{

    @Override
    @BeforeClass(groups = {"it-all"})
    public void startAimServerMock() throws TException
    {
        blockedServer = Executors.newSingleThreadExecutor().submit(new Runnable()
        {
            @Override
            public void run()
            {
                boot.startServerBlocking();
            }
        });

        aimclient = TTransportProxy.getInstance("localhost", BootAimServerMock.SERVER_PORT);

        // be sure the Server Runnable is executed before returning
        int timeout = 10;
        boolean serverIsStarted = false;
        TException lastException = null;
        while (!serverIsStarted && timeout > 0)
        {
            try
            {

                aimclient.checkRimpConfiguration();
                serverIsStarted = true;
            }
            catch (RimpException e)
            {
                // aim logic error, the server is started
            }
            catch (TException e)
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
        if(!serverIsStarted)
        {
            throw lastException;
        }
    }

    @Override
    @AfterClass(groups = {"it-all"})
    public void stopAimServerMock()
    {
        boot.stopServer();
        blockedServer.cancel(true);
    }

    @Test(groups = {"it-all"})
    public void test_aimOperationsAllowed() throws RimpException, TException, VLanException, StorageException
    {
        super.test_aimOperationsAllowed();
    }
}
