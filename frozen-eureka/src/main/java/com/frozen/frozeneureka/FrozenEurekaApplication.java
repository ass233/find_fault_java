package com.frozen.frozeneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FrozenEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrozenEurekaApplication.class, args);
    }

}
