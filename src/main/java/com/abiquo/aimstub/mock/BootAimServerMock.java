package com.abiquo.aimstub.mock;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
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

    /** Simple server does not publish its "stopped" var. */
    private boolean running;

    /** Mock implementation */
    protected Aim.Processor processor = new Aim.Processor(new AimServerMock());

    /** Starts a Thrift server based on {@link TServerSocket} implementation. */
    public void startServerBlocking()
    {
        this.startServerBlocking(SERVER_PORT);
    }

    /** Starts a Thrift server based on {@link TNonblockingServer} implementation. */
    public void startServerNonBlocking()
    {
        this.startServerNonBlocking(SERVER_PORT);
    }

    /** Starts a Thrift server based on {@link TServerSocket} implementation on the specified port. */
    public void startServerBlocking(int port)
    {
        try
        {
            final TServerSocket serverTransport = new TServerSocket(port);
            // vbox no need concurrency at aim
            // server = new TThreadPoolServer(processor, serverTransport);
            server = new TSimpleServer(processor, serverTransport);
            server.serve();
            running = Boolean.TRUE;
            LOG.info("Aim Server Mock started at {}", port);
        }
        catch (TTransportException e)
        {
            running = Boolean.FALSE;
            LOG.error("can't start server {}", e);
        }
    }

    /**
     * Starts a Thrift server based on {@link TNonblockingServer} implementation on the specified
     * port.
     */
    public void startServerNonBlocking(int port)
    {
        try
        {
            final TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(port);
            server = new TNonblockingServer(processor, serverTransport);
            server.serve();
            running = Boolean.TRUE;
            LOG.info("Aim Server Mock started at {}", port);
        }
        catch (TTransportException e)
        {
            running = Boolean.FALSE;
            LOG.error("can't start server {}", e);
        }
    }

    /**
     * used both for stopping a server from {@link BootAimServerMock#startServerBlocking()}
     * {@link BootAimServerMock#startServerNonBlocking()}
     */
    public void stopServer()
    {
        running = Boolean.FALSE;
        server.stop();
    }

    public boolean isRunning()
    {
        return running;
    }

    /** starts a blocking server */
    public static void main(final String[] args) throws Exception
    {
        BootAimServerMock srv = new BootAimServerMock();
        srv.startServerBlocking();
    }

}
