package com.zjjw.zjjwserver.util;

import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Function:
 *
 * @author frozen
 *         Date: 22/05/2018 18:33
 * @since JDK 1.8
 */
public class SessionSocketHolder {
    private static final Map<String, NioSocketChannel> ALLUSER_CHANNEL_MAP = new ConcurrentHashMap<>(16);
    private static final Map<Long, NioSocketChannel> CHANNEL_MAP = new ConcurrentHashMap<>(16);

    synchronized public static void putUser(String sessionId,NioSocketChannel socketChannel) {
        ALLUSER_CHANNEL_MAP.put(sessionId,socketChannel);
    }

    synchronized public static void removeUser(String sessionId) {
        ALLUSER_CHANNEL_MAP.remove( sessionId);
    }

    public static void put(Long id, NioSocketChannel socketChannel) {
        CHANNEL_MAP.put(id, socketChannel);
    }

    public static NioSocketChannel get(Long id) {
        return CHANNEL_MAP.get(id);
    }

    public static Map<String, NioSocketChannel> getUserMAP() {
        return ALLUSER_CHANNEL_MAP;
    }

    public static Map<Long, NioSocketChannel> getMAP() {
        return CHANNEL_MAP;
    }

    public static void remove(NioSocketChannel nioSocketChannel) {
        CHANNEL_MAP.entrySet().stream().filter(entry -> entry.getValue() == nioSocketChannel).forEach(entry -> CHANNEL_MAP.remove(entry.getKey()));
    }

}
