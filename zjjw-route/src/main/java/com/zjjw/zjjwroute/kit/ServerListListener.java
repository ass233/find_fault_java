package com.zjjw.zjjwroute.kit;

import com.zjjw.zjjwroute.config.AppConfiguration;
import com.zjjw.zjjwroute.util.SpringBeanFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2018/12/23 00:35
 * @since JDK 1.8
 */
@Slf4j
public class ServerListListener implements Runnable{

    private ZKit zkUtil;

    private AppConfiguration appConfiguration ;


    public ServerListListener() {
        zkUtil = SpringBeanFactory.getBean(ZKit.class) ;
        appConfiguration = SpringBeanFactory.getBean(AppConfiguration.class) ;
    }

    @Override
    public void run() {
        //注册监听服务
        zkUtil.subscribeEvent(appConfiguration.getZkRoot());

    }
}
