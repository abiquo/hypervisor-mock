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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TMessageType;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TType;

import com.abiquo.aimstub.Aim;
import com.abiquo.aimstub.Aim.Iface;
import com.abiquo.aimstub.Datastore;
import com.abiquo.aimstub.NetInterface;
import com.abiquo.aimstub.RimpException;
import com.abiquo.aimstub.StorageException;
import com.abiquo.aimstub.VLanException;
import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.configuration.Constants;
import com.abiquo.mock.domain.DomainService;

/**
 * This pretends to be a aim-server, but it is not, it is a mock.
 */
public class AimServerMock implements Iface
{
    private final static Logger LOG = Logger.getLogger(AimServerMock.class.getName());

    private static final Map<String, List<Object[]>> fails = Collections
        .synchronizedMap(new HashMap<String, List<Object[]>>());

    private static final Random random = new Random();

    public static class Processor extends Aim.Processor
    {

        private static final Map<String, Long> delays = Collections
            .synchronizedMap(new HashMap<String, Long>());

        public Processor(final Iface iface)
        {
            super(iface);
        }

        @Override
        public boolean process(final TProtocol iprot, final TProtocol oprot) throws TException
        {
            TMessage msg = iprot.readMessageBegin();
            ProcessFunction fn = processMap_.get(msg.name);
            if (fn == null)
            {
                TProtocolUtil.skip(iprot, TType.STRUCT);
                iprot.readMessageEnd();
                TApplicationException x =
                    new TApplicationException(TApplicationException.UNKNOWN_METHOD,
                        "Invalid method name: '" + msg.name + "'");
                oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
                x.write(oprot);
                oprot.writeMessageEnd();
                oprot.getTransport().flush();
                return true;
            }

            applyDelay(msg.name);

            fn.process(msg.seqid, iprot, oprot);
            return true;
        }

        private void applyDelay(final String method)
        {
            try
            {
                long methodDelay = getDelay(method);
                if (methodDelay > 0)
                {
                    Thread.sleep(methodDelay);
                }
                AimServerMock.LOG.finer("Adding delay for " + method + ", " + methodDelay + "ms ");
            }
            catch (Exception e)
            {
                AimServerMock.LOG.severe("Error applying delay, " + method + ", " + e.getMessage());
            }
        }

        private long getDelay(final String method)
        {
            Long d = delays.get(method);

            if (d == null)
            {

                d =
                    ConfigurationService
                        .getInstance()
                        .pathvalue(Long.valueOf(0), Number.class, Constants.BEHAVIOR,
                            method.substring(0, 1).toLowerCase().concat(method.substring(1)),
                            Constants.DELAY).longValue();

                delays.put(method, d);
            }

            return d;

        }
    }

    @Override
    public void checkRimpConfiguration() throws RimpException, TException
    {
        LOG.info("checkRimpConfiguration");
        Exception e = checkFailure("checkRimpConfiguration");
        if (e instanceof RimpException)
        {
            throw (RimpException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }

    @Override
    public long getDiskFileSize(final String virtualImageDatastorePath) throws RimpException,
        TException
    {
        LOG.info("getDiskFileSize");
        Exception e = checkFailure("getDiskFileSize");
        if (e instanceof RimpException)
        {
            throw (RimpException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
        return 0;
    }

    @Override
    public List<Datastore> getDatastores() throws RimpException, TException
    {
        LOG.info("getDatastores");
        Exception e = checkFailure("getDatastores");
        if (e instanceof RimpException)
        {
            throw (RimpException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
        return DomainService.getInstance().getDatastores();
    }

    @Deprecated
    @Override
    public List<NetInterface> getNetInterfaces() throws RimpException, TException
    {
        LOG.severe("getNetInterfaces shouldn't be called");
        Exception e = checkFailure("getNetInterfaces");
        if (e instanceof RimpException)
        {
            throw (RimpException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
        return Collections.emptyList();
    }

    @Override
    public void copyFromRepositoryToDatastore(final String virtualImageRepositoryPath,
        final String datastorePath, final String virtualMachineUUID) throws RimpException,
        TException
    {
        LOG.info("copyFromRepositoryToDatastore");
        Exception e = checkFailure("copyFromRepositoryToDatastore");

        if (e instanceof RimpException)
        {
            throw (RimpException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }

    @Override
    public void deleteVirtualImageFromDatastore(final String datastorePath,
        final String virtualMachineUUID) throws RimpException, TException
    {
        LOG.info("deleteVirtualImageFromDatastore");
        Exception e = checkFailure("deleteVirtualImageFromDatastore");
        if (e instanceof RimpException)
        {
            throw (RimpException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }

    @Override
    public void copyFromDatastoreToRepository(final String virtualMachineUUID,
        final String snapshot, final String destinationRepositoryPath,
        final String sourceDatastorePath) throws RimpException, TException
    {
        LOG.info("copyFromDatastoreToRepository");
        Exception e = checkFailure("copyFromDatastoreToRepository");
        if (e instanceof RimpException)
        {
            throw (RimpException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }

    @Override
    public void createVLAN(final int vlanTag, final String vlanInterface,
        final String bridgeInterface) throws VLanException, TException
    {
        LOG.info("createVLAN");
        Exception e = checkFailure("createVLAN");

        if (e instanceof VLanException)
        {
            throw (VLanException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }

    @Override
    public void deleteVLAN(final int vlanTag, final String vlanInterface,
        final String bridgeInterface) throws VLanException, TException
    {
        LOG.info("deleteVLAN");
        Exception e = checkFailure("deleteVLAN");

        if (e instanceof VLanException)
        {
            throw (VLanException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }

    @Override
    public void checkVLANConfiguration() throws VLanException, TException
    {
        LOG.info("checkVLANConfiguration");
        Exception e = checkFailure("checkVLANConfiguration");

        if (e instanceof VLanException)
        {
            throw (VLanException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }

    @Override
    public String getInitiatorIQN() throws StorageException, TException
    {
        LOG.info("getInitiatorIQN");
        Exception e = checkFailure("getInitiatorIQN");
        if (e instanceof StorageException)
        {
            throw (StorageException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
        return "";
    }

    private Exception checkFailure(final String method)
    {
        List<Object[]> list = fails.get(method);
        if (list == null)
        {
            list = addToCache(method);

            fails.put(method, list);
        }

        for (Object[] o : list)
        {
            Integer ratio = (Integer) o[1];
            String msg = (String) o[3];

            if (ratio > 0 && ratio >= random.nextInt(101))
            {
                LOG.info("Error raised method " + method + " " + o[0] + " " + o[1] + " " + o[2]
                    + " " + o[3]);
                String excName = (String) o[2];
                if ("VLanException".equals(excName))
                {
                    return new VLanException(msg);
                }
                else if ("RimpException".equals(excName))
                {
                    return new RimpException(msg);
                }
                else
                {
                    return new TException(msg);
                }
            }
        }
        return null;
    }

    /** This method checks if there is a fail condition and add exception to the payload. */
    private List<Object[]> addToCache(final String method)
    {
        List<Map<String, Object>> fails =
            ConfigurationService.getInstance().pathvalue(List.class, Constants.BEHAVIOR,
                method.substring(0, 1).toLowerCase().concat(method.substring(1)),
                Constants.FAILURES);

        List<Object[]> list = new ArrayList<Object[]>();
        if (fails == null)
        {
            return list;
        }
        for (Map<String, Object> o : fails)
        {
            // These entries are : ratio, message and exception
            try
            {
                String exc = (String) o.remove(Constants.EXCEPTION);
                String msg = (String) o.remove(Constants.MESSAGE);
                Set<Entry<String, Object>> e = o.entrySet();
                if (e.size() != 1)
                {
                    continue;
                }
                Entry<String, Object>[] array = e.toArray(new Entry[0]);
                String description = array[0].getKey();
                Integer ratio = (Integer) array[0].getValue();

                Object[] fail = new Object[] {description, ratio, exc, msg};
                list.add(fail);
            }
            catch (ClassCastException e)
            {
                LOG.severe("Error in ratio, expecting a number" + e);
            }
        }
        return list;
    }

    @Override
    public void rescanISCSI(List<String> arg0) throws StorageException, TException
    {
        LOG.info("rescanISCSI");

        Exception e = checkFailure("rescanISCSI");
        if (e instanceof StorageException)
        {
            throw (StorageException) e;
        }
        if (e instanceof TException)
        {
            throw (TException) e;
        }
    }
}
