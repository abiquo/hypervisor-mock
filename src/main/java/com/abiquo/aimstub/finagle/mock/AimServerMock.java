/**
 * Abiquo community edition
 * cloud management application for hybrid clouds
 * Copyright (C) 2008-2010 - Abiquo Holdings S.L.
 *
 * This application is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC
 * LICENSE as published by the Free Software Foundation under
 * version 3 of the License
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * LESSER GENERAL PUBLIC LICENSE v.3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package com.abiquo.aimstub.finagle.mock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abiquo.aimstub.finagle.Aim.ServiceIface;
import com.abiquo.aimstub.finagle.Datastore;
import com.abiquo.aimstub.finagle.NetInterface;
import com.twitter.util.ExecutorServiceFuturePool;
import com.twitter.util.Future;

/**
 * This pretends to be a aim-server, but it is not, it is a mock.
 */
public class AimServerMock implements ServiceIface
{
    private final static Logger LOG = LoggerFactory.getLogger(AimServerMock.class);

    // In Scala, one can call directly to the FuturePool, but Java gets confused
    // between the object and class, so it's best to instantiate an ExecutorServiceFuturePool
    // directly

    /* Number of threads to devote to blocking requests */
    private ExecutorService es = Executors.newFixedThreadPool(4);

    /* Pool to process blockng requests so server thread doesn't */
    private ExecutorServiceFuturePool esfp = new ExecutorServiceFuturePool(es);

    @Override
    public Future<Void> checkRimpConfiguration()
    {
        // TODO Auto-generated method stub
        LOG.debug("checkRimpConfiguration");
        return Future.value(null);
    }

    @Override
    public Future<Long> getDatastoreSize()
    {
        // TODO Auto-generated method stub
        LOG.debug("getDatastoreSize");
        return Future.value(0l);
    }

    @Override
    public Future<Long> getDiskFileSize(final String virtualImageDatastorePath)
    {
        // TODO Auto-generated method stub
        LOG.debug("getDiskFileSize");
        return Future.value(0l);
    }

    @Override
    public Future<List<Datastore>> getDatastores()
    {
        // TODO Auto-generated method stub
        LOG.debug("getDatastores");
        List<Datastore> datastores = new LinkedList<Datastore>();
        return Future.value(datastores);
    }

    @Override
    public Future<List<NetInterface>> getNetInterfaces()
    {
        // TODO Auto-generated method stub
        LOG.debug("getNetInterfaces");
        List<NetInterface> netIfaces = new LinkedList<NetInterface>();
        return Future.value(netIfaces);
    }

    @Override
    public Future<Void> copyFromRepositoryToDatastore(final String virtualImageRepositoryPath,
        final String datastorePath, final String virtualMachineUUID)
    {
        // TODO Auto-generated method stub
        LOG.debug("copyFromRepositoryToDatastore");
        return Future.value(null);
    }

    @Override
    public Future<Void> deleteVirtualImageFromDatastore(final String datastorePath,
        final String virtualMachineUUID)
    {
        // TODO Auto-generated method stub
        LOG.debug("deleteVirtualImageFromDatastore");
        return Future.value(null);

    }

    @Override
    public Future<Void> copyFromDatastoreToRepository(final String virtualMachineUUID,
        final String snapshot, final String destinationRepositoryPath,
        final String sourceDatastorePath)
    {
        // TODO Auto-generated method stub
        LOG.debug("copyFromDatastoreToRepository");
        return Future.value(null);
    }

    @Override
    public Future<Void> createVLAN(final int vlanTag, final String vlanInterface,
        final String bridgeInterface)
    {
        // TODO Auto-generated method stub
        LOG.debug("createVLAN");
        return Future.value(null);
    }

    @Override
    public Future<Void> deleteVLAN(final int vlanTag, final String vlanInterface,
        final String bridgeInterface)
    {
        // TODO Auto-generated method stub
        LOG.debug("deleteVLAN");
        return Future.value(null);
    }

    @Override
    public Future<Void> checkVLANConfiguration()
    {
        // TODO Auto-generated method stub
        LOG.debug("checkVLANConfiguration");
        return Future.value(null);

    }

    @Override
    public Future<String> getInitiatorIQN()
    {
        // TODO Auto-generated method stub
        LOG.debug("getInitiatorIQN");
        return Future.value("");
    }
}
