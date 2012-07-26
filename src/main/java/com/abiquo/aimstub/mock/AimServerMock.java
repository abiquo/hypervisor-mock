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

package com.abiquo.aimstub.mock;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.apache.thrift.TException;

import com.abiquo.aimstub.Aim.Iface;
import com.abiquo.aimstub.Datastore;
import com.abiquo.aimstub.NetInterface;
import com.abiquo.aimstub.RimpException;
import com.abiquo.aimstub.VLanException;
import com.abiquo.mock.domain.DomainService;

/**
 * This pretends to be a aim-server, but it is not, it is a mock.
 */
public class AimServerMock implements Iface
{
    private final static Logger LOG = Logger.getLogger(AimServerMock.class.getName());

    @Override
    public void checkRimpConfiguration() throws RimpException, TException
    {
        // TODO Auto-generated method stub
//        LOG.info("checkRimpConfiguration");
    }

    @Override
    public long getDatastoreSize() throws RimpException, TException
    {
        // TODO Auto-generated method stub
        LOG.info("getDatastoreSize");

        return 0;
    }

    @Override
    public long getDiskFileSize(final String virtualImageDatastorePath) throws RimpException,
        TException
    {
        // TODO Auto-generated method stub
        LOG.info("getDiskFileSize");

        return 0;
    }

    @Override
    public List<Datastore> getDatastores() throws RimpException, TException
    {
//        LOG.info("getDatastores");

        return DomainService.getInstance().getDatastores();
        //return Collections.EMPTY_LIST;
    }

    @Deprecated
    @Override
    public List<NetInterface> getNetInterfaces() throws RimpException, TException
    {
        LOG.severe("getNetInterfaces shouldn't be called");

        return Collections.EMPTY_LIST;
    }

    @Override
    public void copyFromRepositoryToDatastore(final String virtualImageRepositoryPath,
        final String datastorePath, final String virtualMachineUUID) throws RimpException,
        TException
    {
        // TODO Auto-generated method stub
        LOG.info("copyFromRepositoryToDatastore");

    }

    @Override
    public void deleteVirtualImageFromDatastore(final String datastorePath,
        final String virtualMachineUUID) throws RimpException, TException
    {
        // TODO Auto-generated method stub
        LOG.info("deleteVirtualImageFromDatastore");

    }

    @Override
    public void copyFromDatastoreToRepository(final String virtualMachineUUID,
        final String snapshot, final String destinationRepositoryPath,
        final String sourceDatastorePath) throws RimpException, TException
    {
        // TODO Auto-generated method stub
        LOG.info("copyFromDatastoreToRepository");

    }

    @Override
    public void createVLAN(final int vlanTag, final String vlanInterface,
        final String bridgeInterface) throws VLanException, TException
    {
        // TODO Auto-generated method stub
        LOG.info("createVLAN");

    }

    @Override
    public void deleteVLAN(final int vlanTag, final String vlanInterface,
        final String bridgeInterface) throws VLanException, TException
    {
        // TODO Auto-generated method stub
        LOG.info("deleteVLAN");

    }

    @Override
    public void checkVLANConfiguration() throws VLanException, TException
    {
        // TODO Auto-generated method stub
        LOG.info("checkVLANConfiguration");

    }

    @Override
    public String getInitiatorIQN() throws TException
    {
        // TODO Auto-generated method stub
        LOG.info("getInitiatorIQN");
        return "";
    }
}
