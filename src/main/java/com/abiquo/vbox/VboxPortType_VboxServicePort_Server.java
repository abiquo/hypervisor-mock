package com.abiquo.vbox;

import java.io.IOException;

import javax.xml.ws.Endpoint;

import com.abiquo.aimstub.mock.BootAimServerMock;
import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.configuration.Constants;
import com.abiquo.vbox.mock.VboxPortTypeMock;

/**
 * This class implements the logic of the mock server. <br>
 * Both AIM and Vbox WS
 * 
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 * @author <a href="mailto:eruiz@abiquo.com">Enric Ruiz</a>
 */
public class VboxPortType_VboxServicePort_Server
{

    private static final String ADDRESS = "http://0.0.0.0";

    private volatile static VboxPortType_VboxServicePort_Server SERVER;

    private final BootAimServerMock aim = new BootAimServerMock();

    private final Endpoint vbox = Endpoint.create(new VboxPortTypeMock());

    /**
     * This returns the instance. The instance is volatile so no thread sees a partially initialized
     * instance.
     * 
     * @return the instance
     * @throws Exception
     */
    public static VboxPortType_VboxServicePort_Server getInstance() throws Exception
    {
        if (SERVER == null)
        {
            SERVER = new VboxPortType_VboxServicePort_Server();
        }
        return SERVER;
    }

    /**
     * The execution of this method starts both aim and vbox ws servers.
     * 
     * @throws java.lang.Exception
     */
    protected VboxPortType_VboxServicePort_Server() throws java.lang.Exception
    {
        final Integer vboxPort =
            ConfigurationService.getInstance().pathvalue(Integer.class, Constants.CONFIGURATION,
                Constants.VBOX_PORT);
        if (!isVboxRunning())
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    System.out.println("Starting Server");
                    vbox.publish(ADDRESS + ":" + vboxPort + "/");
                }
            }).start();
        }

        final Integer aimPort =
            ConfigurationService.getInstance().pathvalue(Integer.class, Constants.CONFIGURATION,
                Constants.AIM_PORT);
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                aim.startServerBlocking(aimPort);
            }
        }).start();
    }

    /** This method can return false but the mock migth be down emulating a power off */
    public boolean isVboxRunning()
    {

        return vbox != null && vbox.isPublished();
    }

    /**
     * Tries to start an AIM mock in a Future. Only one request should start the server, thats why
     * the actual start is syncrhonized. If the aim is already running the method will do nothing
     * but return true.
     */
    public void startAim() throws InterruptedException, Exception
    {
        startAimServer();
    }

    /**
     * Only one call at a time. If the aim is already running the method will do nothing.
     * 
     * @return
     */
    synchronized private void startAimServer() throws Exception
    {
        final Integer aimPort =
            ConfigurationService.getInstance().pathvalue(Integer.class, Constants.CONFIGURATION,
                Constants.AIM_PORT);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                aim.startServerBlocking(aimPort);
            }
        }).start();
    }

    /**
     * Endpoint. Only one request should start the server, thats why the actual start is
     * syncrhonized.If the vbox ws is already running the method will do nothing.
     * 
     * @throws IOException
     */
    public void startVbox() throws IOException
    {
        startVboxWS();
    }

    /**
     * Only one call at a time. If the vbox ws is already running the method will do nothing.
     * 
     * @throws IOException
     */
    synchronized private void startVboxWS() throws IOException
    {
        if (!isVboxRunning())
        {
            System.out.println("Starting Server");
            vbox.publish(ADDRESS);
        }
    }

    /**
     * Tries to cancel the Future in which is running the Aim mock. This method enables the
     * cancellation of a running thread
     */
    public void stopAim()
    {
        aim.stopServer();
    }

    /** Stops the endpoint */
    public void stopVbox()
    {
        vbox.stop();
    }
}
