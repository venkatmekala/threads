package com.javabites.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample extends Thread {
    private String threadName;
    private Phaser phaser;
    public PhaserExample(String threadName, Phaser phaser) {
        super(threadName);
        this.phaser = phaser;
        this.threadName = threadName;
        phaser.register();

    }

    @Override
    public void run() {
        System.out.println(this.threadName + "Arrived Phase 1");
        phaser.arriveAndAwaitAdvance();

        randomWait();

        System.out.println(this.threadName + "Arrived Phase 2");
        phaser.arriveAndDeregister();
    }

    private void randomWait() {
        try {
            Thread.sleep((long)Math.random() * 1000);
        } catch (InterruptedException e) {

        }
    }
}
