package com.javabites.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    volatile AtomicInteger  counter = new AtomicInteger(0);

    public void increment() {
        counter.getAndIncrement();
    }

    public void decrement() {
       counter.getAndDecrement();
    }

    public int getCounter() {
        return counter.get();
    }
}
