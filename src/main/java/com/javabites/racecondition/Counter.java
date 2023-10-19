package com.javabites.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    volatile int  counter = 0;

    public  void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
