package com.xr.chain.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xps15 on 2016/12/12.
 */
@SpringBootApplication
@ImportResource(locations={"classpath:spring-application.xml"})
public class ApplicationBoot {
    public static void main(String[] args) throws  Exception {
        SpringApplication app = new SpringApplication();
        app.run(ApplicationBoot.class,args);
    }
}
