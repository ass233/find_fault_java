package com.zjjw.zjjwserver.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2018/8/24 01:43
 * @since JDK 1.8
 */
@Component
@Data
public class AppConfiguration {

    @Value("${app.zk.root}")
    private String zkRoot;

    @Value("${app.zk.addr}")
    private String zkAddr;

    @Value("${app.zk.switch}")
    private boolean zkSwitch;

    @Value("${zjjw.server.port}")
    private int zjjwServerPort;

    @Value("${zjjw.clear.route.request.url}")
    private String clearRouteUrl ;

    @Value("${zjjw.heartbeat.time}")
    private long heartBeatTime ;

    @Value("${app.zk.connect.timeout}")
    private int zkConnectTimeout;

}
