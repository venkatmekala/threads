package com.javabites.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Waiter {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        List<Thread> cooks = Stream.generate(() -> new Thread(new Cook(countDownLatch))).limit(3).toList();
        //cooks.forEach(Thread :: start);
        cooks.forEach(cook -> executorService.submit(cook));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Food is ready to be served");
        executorService.shutdown();
    }
}
