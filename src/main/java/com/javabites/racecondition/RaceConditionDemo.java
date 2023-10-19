package com.javabites.racecondition;

public class RaceConditionDemo {
    public RaceConditionDemo() {
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();
        Thread incThread = new Thread(() -> {
            for(int i = 1; i < 1_000_000; i++)
                counter.increment();
        });

        Thread decThread = new Thread(() -> {
            for(int i = 1; i < 1_000_000; i++)
                counter.decrement();
        });

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println(counter.getCounter());
    }
}
