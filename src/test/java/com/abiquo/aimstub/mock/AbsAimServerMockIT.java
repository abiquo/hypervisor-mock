package com.abiquo.aimstub.mock;

import java.util.Arrays;
import java.util.concurrent.Future;

import org.apache.thrift.TException;

import com.abiquo.aimstub.Aim;
import com.abiquo.aimstub.Aim.Iface;
import com.abiquo.aimstub.RimpException;
import com.abiquo.aimstub.StorageException;
import com.abiquo.aimstub.VLanException;

/**
 * Base test class to setup a thrift server running the {@link Aim} protocol
 */
public abstract class AbsAimServerMockIT
{
    protected BootAimServerMock boot = new BootAimServerMock();

    protected Future< ? > blockedServer;

    protected Iface aimclient;

    public abstract void startAimServerMock() throws TException;

    public abstract void stopAimServerMock();

    public void test_aimOperationsAllowed() throws RimpException, TException, VLanException,
        StorageException
    {
        int vlanTag = 0;

        aimclient.checkRimpConfiguration();

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

        aimclient.rescanISCSI(Arrays.asList("ISCSI"));
        
        aimclient.getInitiatorIQN();
    }
}
