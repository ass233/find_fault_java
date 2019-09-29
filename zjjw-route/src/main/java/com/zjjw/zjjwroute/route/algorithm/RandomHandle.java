package com.zjjw.zjjwroute.route.algorithm;

import com.zjjw.zjjwroute.cache.ServerCache;
import com.zjjw.zjjwroute.vo.res.ServerResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class RandomHandle {

    @Autowired
    private ServerCache serverCache;

    public String routeServer( String key) {
        List<String> values=serverCache.getAll();
        int size = values.size();
        if (size == 0) {
            throw new RuntimeException("CIM 服务器可用服务列表为空");
        }
        int offset = ThreadLocalRandom.current().nextInt(size);
        return values.get(offset);
    }

    public ServerResVO routeServerVo() {
        List<String> values=serverCache.getAll();
        int size = values.size();
        if (size == 0) {
            throw new RuntimeException("CIM 服务器可用服务列表为空");
        }
        int offset = ThreadLocalRandom.current().nextInt(size);
        String server = values.get(offset);
        String[] serverInfo = server.split(":");
        ServerResVO serverResVO = new ServerResVO();
        serverResVO.setIp(serverInfo[0]);
        serverResVO.setCimServerPort(Integer.parseInt(serverInfo[1]));
        serverResVO.setHttpPort(Integer.parseInt(serverInfo[2]));
        return serverResVO;
    }

    public String getServerUrl(String requestUrl){
        ServerResVO serverResVO = this.routeServerVo();
        String url = "http://" + serverResVO.getIp() + ":" + serverResVO.getHttpPort() + requestUrl ;
        return url;
    }

    public String getImServerUrl(ServerResVO serverResVO,String requestUrl){
        String url = "http://" + serverResVO.getIp() + ":" + serverResVO.getHttpPort() + requestUrl ;
        return url;
    }
}
