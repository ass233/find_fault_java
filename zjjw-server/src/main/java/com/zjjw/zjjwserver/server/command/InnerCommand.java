package com.zjjw.zjjwserver.server.command;

/**
 * Function:
 *
 * @author frozen
 * Date: 2019-01-27 19:26
 * @since JDK 1.8
 */
public interface InnerCommand {

    /**
     * 执行
     * @param msg
     */
    void process(String msg) ;
}
