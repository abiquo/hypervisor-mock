package com.abiquo.aimstub.finagle.mock;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abiquo.aimstub.finagle.Aim;

import com.twitter.finagle.builder.Server;
import com.twitter.finagle.builder.ServerBuilder;
import com.twitter.finagle.thrift.ThriftServerFramedCodec;
import com.twitter.util.Duration;
import com.twitter.util.ExecutorServiceFuturePool;
import com.twitter.util.Function0;
import com.twitter.util.Future;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Starts a thrift server exposing a mocked version of the {@link Aim} interface
 */
public class BootAimServerMock
{
    private final static Logger LOG = LoggerFactory.getLogger(BootAimServerMock.class);

    /** Server port. TODO configurable */
    public final static Integer SERVER_PORT = 7912;

    /** Thrift server. */
    private Server server;

    /** Mock implementation */
    protected Aim.ServiceIface serverImpl = new AimServerMock();

    /** Starts a Thrift server based on twitter finagle implementation. */
    public void startServer()
    {
        try
        {
            // IDE shows this as a type error, but compiles
            server =
                ServerBuilder.safeBuild(new Aim.Service(serverImpl, new TBinaryProtocol.Factory()),
                    ServerBuilder.get().//
                        name("AimServerMock").//
                        codec(ThriftServerFramedCodec.get()).//
                        bindTo(new InetSocketAddress(SERVER_PORT)));

            LOG.info("Aim Server Mock started at " + SERVER_PORT);
        }
        catch (Exception e)
        {
            LOG.error("can't start server {}", e);
        }
    }

    public void stopServer()
    {
        server.close(Duration.eternity()); // XXX
    }

    /** starts a blocking server */
    public static void main(final String[] args) throws Exception
    {
        BootAimServerMock srv = new BootAimServerMock();
        srv.startServer();
    }

}
