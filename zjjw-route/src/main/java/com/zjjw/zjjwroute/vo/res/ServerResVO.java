package com.zjjw.zjjwroute.vo.res;

import java.io.Serializable;

/**
 *
 */
public class ServerResVO implements Serializable {

    private String ip ;
    private Integer cimServerPort;
    private Integer httpPort;

    public ServerResVO(String ip, Integer cimServerPort, Integer httpPort) {
        this.ip = ip;
        this.cimServerPort = cimServerPort;
        this.httpPort = httpPort;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getCimServerPort() {
        return cimServerPort;
    }

    public void setCimServerPort(Integer cimServerPort) {
        this.cimServerPort = cimServerPort;
    }

    public Integer getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }
}
