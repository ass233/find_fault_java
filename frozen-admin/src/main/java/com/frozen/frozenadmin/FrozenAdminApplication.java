package com.frozen.frozenadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession     // 启用ResisSession存储
@EnableCaching              // 启用缓存
public class FrozenAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrozenAdminApplication.class, args);
    }

}
