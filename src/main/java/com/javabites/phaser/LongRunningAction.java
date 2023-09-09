package com.javabites.phaser;

import java.util.concurrent.Phaser;

class LongRunningAction implements Runnable {
    private String threadName;
    private Phaser ph;

    LongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        this.randomWait();
        ph.register();
    }

    @Override
    public void run() {
        ph.arriveAndAwaitAdvance();
        randomWait();
        ph.arriveAndDeregister();
    }

    // Simulating real work
    private void randomWait() {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}