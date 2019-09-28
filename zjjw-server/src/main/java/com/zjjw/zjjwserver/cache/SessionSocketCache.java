package com.zjjw.zjjwserver.cache;

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
public class SessionSocketCache {
    //通道的缓存信息
    private static final Map<String, NioSocketChannel> ALLUSER_CHANNEL_MAP = new ConcurrentHashMap<>(16);

    synchronized public static void removeUser(String sessionId) {
        ALLUSER_CHANNEL_MAP.remove( sessionId);
    }
    public static Map<String, NioSocketChannel> getUserMAP() {
        return ALLUSER_CHANNEL_MAP;
    }

    synchronized public static void remove(NioSocketChannel nioSocketChannel) {
        ALLUSER_CHANNEL_MAP.entrySet().stream().filter(entry -> entry.getValue() == nioSocketChannel).forEach(entry -> ALLUSER_CHANNEL_MAP.remove(entry.getKey()));
    }
    synchronized public static void put(String sessionId, NioSocketChannel socketChannel) {
        ALLUSER_CHANNEL_MAP.put(sessionId, socketChannel);
    }

    public static NioSocketChannel get(String sessionId) {
        return ALLUSER_CHANNEL_MAP.get(sessionId);
    }

}
