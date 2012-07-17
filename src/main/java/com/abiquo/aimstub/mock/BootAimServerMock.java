package com.abiquo.aimstub.mock;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abiquo.aimstub.Aim;

/**
 * Starts a thrift server exposing a mocked version of the {@link Aim} interface
 */
public class BootAimServerMock
{
    private final static Logger LOG = LoggerFactory.getLogger(BootAimServerMock.class);

    /** Server port. TODO configurable */
    public final static Integer SERVER_PORT = 8889;

    /** Thrift server. */
    private TServer server;

    /** Mock implementation */
    protected Aim.Processor processor = new Aim.Processor(new AimServerMock());

    /** Starts a Thrift server based on {@link TServerSocket} implementation. */
    public void startServerBlocking()
    {
        try
        {
            final TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            server = new TThreadPoolServer(processor, serverTransport);
            server.serve();

            LOG.info("Aim Server Mock started at {}", SERVER_PORT);
        }
        catch (TTransportException e)
        {
            LOG.error("can't start server {}", e);
        }
    }

    /** Starts a Thrift server based on {@link TNonblockingServer} implementation. */
    public void startServerNonBlocking()
    {
        try
        {
            final TNonblockingServerTransport serverTransport =
                new TNonblockingServerSocket(SERVER_PORT);
            server = new TNonblockingServer(processor, serverTransport);
            server.serve();

            LOG.info("Aim Server Mock started at {}", SERVER_PORT);
        }
        catch (TTransportException e)
        {
            e.printStackTrace();
            LOG.error("can't start server {}", e);
        }
    }

    /**
     * used both for stopping a server from {@link BootAimServerMock#startServerBlocking()}
     * {@link BootAimServerMock#startServerNonBlocking()}
     */
    public void stopServer()
    {
        server.stop();
    }

    /** starts a blocking server */
    public static void main(final String[] args) throws Exception
    {
        BootAimServerMock srv = new BootAimServerMock();
        srv.startServerBlocking();
    }

}
