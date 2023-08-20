package com.javabites.synchronization;


import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSynchronization {
    static AtomicInteger count = new AtomicInteger();
    //static int count = 0;
    private synchronized static void increment() {
        //compound operation
        //count++;
        count.getAndIncrement();

    }
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
           for(int i = 1; i <= 10000; i++)
               increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++)
               increment();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);
    }
}
