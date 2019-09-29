package com.zjjw.zjjwroute.vo.res;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 */
@Data
@ToString
public class ServerResVO implements Serializable {

    private String ip ;
    private Integer cimServerPort;
    private Integer httpPort;
}
