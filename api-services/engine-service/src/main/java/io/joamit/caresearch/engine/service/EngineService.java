package io.joamit.caresearch.engine.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EngineService {

    public static void main(String[] args) {
        SpringApplication.run(EngineService.class, args);
    }
}
