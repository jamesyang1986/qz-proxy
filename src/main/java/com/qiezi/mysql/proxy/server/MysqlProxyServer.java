package com.qiezi.mysql.proxy.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MysqlProxyServer implements Runnable {

    private static Logger LOG = LoggerFactory.getLogger(MysqlProxyServer.class);

    private int listenPort;
    private Selector selector;

    private boolean isStop;

    public MysqlProxyServer() {
        try {
            selector = Selector.open();
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress(listenPort));
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
//        System.out.println("start the mysql proxy.");
        LOG.info("start the mysql proxy.");
    }

    @Override
    public void run() {
        while (!isStop) {
            try {
                selector.select(100);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    if (key.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel client = channel.accept();
                    } else {
                        it.remove();
                    }
                }
            } catch (IOException e) {
                LOG.error("receive IOException", e);
            }
        }
    }
}
