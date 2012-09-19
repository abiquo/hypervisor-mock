package com.abiquo.aimstub.mock;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.abiquo.vbox.VboxPortType_VboxServicePort_Server;

/**
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 */
@Test
public class ServerMockIT
{
    private VboxPortType_VboxServicePort_Server instance;

    @BeforeTest
    public void setup() throws Exception
    {
        instance = VboxPortType_VboxServicePort_Server.getInstance();
    }

    @Test
    public void start() throws Exception
    {

        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), instance.isAimRunning() && instance.isVboxRunning());
    }

    @Test
    public void stopAim() throws Exception
    {
        instance.stopAim();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), !instance.isAimRunning() && instance.isVboxRunning());
    }

    @Test
    public void startAim() throws Exception
    {
        instance.stopAim();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), !instance.isAimRunning() && instance.isVboxRunning());
        instance.startAim();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), instance.isAimRunning() && instance.isVboxRunning());
    }

    @Test
    public void stopVbox() throws Exception
    {

        instance.stopVbox();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), instance.isAimRunning() && !instance.isVboxRunning());
    }

    @Test
    public void startVbox() throws Exception
    {
        instance.stopVbox();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), instance.isAimRunning() && !instance.isVboxRunning());
        instance.stopVbox();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), instance.isAimRunning() && instance.isVboxRunning());
    }

    @Test
    public void stopAll() throws Exception
    {
        instance.stopVbox();
        instance.stopAim();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), !instance.isAimRunning() && !instance.isVboxRunning());
    }

    @Test
    public void startAll() throws Exception
    {

        instance.stopVbox();
        instance.stopAim();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), !instance.isAimRunning() && !instance.isVboxRunning());

        instance.startAim();
        instance.stopVbox();
        Assert.assertTrue("Aim is running: " + instance.isAimRunning() + " Vbox is running: "
            + instance.isVboxRunning(), instance.isAimRunning() && instance.isVboxRunning());
    }
}
