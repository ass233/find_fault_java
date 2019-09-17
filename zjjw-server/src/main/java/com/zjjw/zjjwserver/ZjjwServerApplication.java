package com.zjjw.zjjwserver;

import com.zjjw.zjjwserver.config.AppConfiguration;
import com.zjjw.zjjwserver.kit.RegistryZK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
public class ZjjwServerApplication  implements CommandLineRunner {
    @Autowired
    private AppConfiguration appConfiguration ;

    @Value("${server.port}")
    private int httpPort ;

    public static void main(String[] args) {
        SpringApplication.run(ZjjwServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //获得本机IP
        String addr = InetAddress.getLocalHost().getHostAddress();
        Thread thread = new Thread(new RegistryZK(addr, appConfiguration.getZjjwServerPort(),httpPort));
        thread.setName("registry-zk");
        thread.start() ;
    }

}
