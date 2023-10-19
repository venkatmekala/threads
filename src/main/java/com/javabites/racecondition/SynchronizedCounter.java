package com.javabites.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedCounter {
    volatile int  counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
