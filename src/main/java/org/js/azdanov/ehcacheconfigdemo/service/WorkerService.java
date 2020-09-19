package org.js.azdanov.ehcacheconfigdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class WorkerService {

    private final Random random;

    @Cacheable(value = "worker1", key = "#bound")
    public int getFirstWork(int bound) {
        return random.nextInt(bound);
    }

    @Cacheable(value = "worker2", key = "#bound")
    public int getSecondWork(int bound) {
        return random.nextInt(bound);
    }
}
