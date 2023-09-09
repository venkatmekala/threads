package com.javabites.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Cook implements Runnable {
    private CountDownLatch countDownLatch;
    public Cook(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        cookFood();
        countDownLatch.countDown();
        System.out.println("Cook "+ Thread.currentThread().getName() + " kept the dish on the plate");
    }

     void cookFood() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
