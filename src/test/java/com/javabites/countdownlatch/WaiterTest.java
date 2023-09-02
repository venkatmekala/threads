package com.javabites.countdownlatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class WaiterTest {
    @Test
    public void whenParallelProcessing_thenMainThreadWillBlockUntilCompletion() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        List<Thread> cooks = Stream.generate(() -> new Thread(new Cook(countDownLatch))).limit(3).toList();
        cooks.forEach(cook -> executorService.submit(cook));
        try {
            countDownLatch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(0, countDownLatch.getCount());
        executorService.shutdown();
    }
}
