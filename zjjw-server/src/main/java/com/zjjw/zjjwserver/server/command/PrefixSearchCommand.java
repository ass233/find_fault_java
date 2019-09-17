package com.zjjw.zjjwserver.server.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 *
 * @author frozen
 * Date: 2019-01-27 19:37
 * @since JDK 1.8
 */
@Service
public class PrefixSearchCommand implements InnerCommand {
    private final static Logger LOGGER = LoggerFactory.getLogger(PrefixSearchCommand.class);

    @Override
    public void process(String msg) {
        try {

            String[] split = msg.split(" ");
            String key = split[1];
            List<String> list = new ArrayList<>();

            for (String res : list) {
                res = res.replace(key, "\033[31;4m" + key + "\033[0m");
                System.out.println(res);
            }

        } catch (Exception e) {
            LOGGER.error("Exception", e);
        }
    }
}
