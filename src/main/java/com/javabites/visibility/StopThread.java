package com.javabites.visibility;

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

        while((endTime - startTime) / 1000 >= 2)
            endTime = System.currentTimeMillis();

        stop = true;
    }
}
