package com.javabites.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Cook implements Runnable {
    private CountDownLatch countDownLatch;
    public Cook(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        doSomeWork();
        countDownLatch.countDown();
        System.out.println("Cook "+ Thread.currentThread().getName() + " kept the dish on the plate");
    }

    synchronized void doSomeWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}