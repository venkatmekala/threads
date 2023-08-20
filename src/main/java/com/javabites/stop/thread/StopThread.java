package com.javabits.stop.thread;

public class StopThread {
    static boolean stop = false;
    public static void runThread() {
        while(!stop) {
            //System.out.println("thread is running");
            long  startTime = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {
        long  startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();

        Thread t = new Thread(() -> runThread());
        t.start();

        stop = true;
    }
}
