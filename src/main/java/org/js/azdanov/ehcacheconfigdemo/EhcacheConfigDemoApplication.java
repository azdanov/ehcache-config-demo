package org.js.azdanov.ehcacheconfigdemo;

import lombok.extern.slf4j.Slf4j;
import org.js.azdanov.ehcacheconfigdemo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.Random;

@Slf4j
@EnableCaching
@Configuration
@SpringBootApplication
public class EhcacheConfigDemoApplication {

    @Autowired
    WorkerService workerService;

    public static void main(String[] args) {
        SpringApplication.run(EhcacheConfigDemoApplication.class, args);
    }

    @Bean
    Random random() {
        return new Random();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartup() {
        log.info("Running!");
        log.info("getFirstWork(100): {}", workerService.getFirstWork(100));
        log.info("getFirstWork(50): {}", workerService.getFirstWork(50));
        log.info("getFirstWork(100): {}", workerService.getFirstWork(100));
        log.info("getFirstWork(50): {}", workerService.getFirstWork(50));
        log.info("getSecondWork(100): {}", workerService.getSecondWork(100));
        log.info("getSecondWork(50): {}", workerService.getSecondWork(50));
        log.info("getSecondWork(100): {}", workerService.getSecondWork(100));
        log.info("getSecondWork(50): {}", workerService.getSecondWork(50));
    }
}

