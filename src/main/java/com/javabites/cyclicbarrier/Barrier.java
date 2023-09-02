package com.javabites.cyclicbarrier;

public class Barrier implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread barrier is invoked");
    }
}
