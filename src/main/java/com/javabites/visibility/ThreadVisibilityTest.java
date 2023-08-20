package com.javabites.visibility;

import java.util.concurrent.TimeUnit;

public class ThreadVisibilityTest {

    //Shared variable to send a signal to the thread
     volatile static boolean stopped = false;
    public static void main(String[] args) throws Exception {
        Thread targetThread = new Thread(new Runnable() {
                public void run() {
                    while(!stopped) {

                    }
                    System.out.println("Target thread gets signal and stops...");
                }
     });

        targetThread.start();

        TimeUnit.SECONDS.sleep(5);
        stopped=true;
        System.out.println("Main thread has sent stop signal to the thread...");
    }
}