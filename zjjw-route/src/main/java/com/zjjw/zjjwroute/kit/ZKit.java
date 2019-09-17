package com.zjjw.zjjwroute.kit;

import com.alibaba.fastjson.JSON;
import com.zjjw.zjjwroute.cache.ServerCache;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Function: Zookeeper 工具
 *
 * @author crossoverJie
 *         Date: 2018/8/19 00:33
 * @since JDK 1.8
 */
@Component
@Slf4j
public class ZKit {
    @Autowired
    private ZkClient zkClient;

    @Autowired
    private ServerCache serverCache ;


    /**
     * 监听事件
     *
     * @param path
     */
    public void subscribeEvent(String path) {
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                log.info("清除/更新本地缓存 parentPath=【{}】,currentChilds=【{}】", parentPath,currentChilds.toString());
                //更新所有缓存/先删除 再新增
                serverCache.updateCache(currentChilds) ;
            }
        });


    }


    /**
     * 获取所有注册节点
     * @return
     */
    public List<String> getAllNode(){
        List<String> children = zkClient.getChildren("/route");
        log.info("查询所有节点成功=【{}】", JSON.toJSONString(children));
       return children;
    }


}
