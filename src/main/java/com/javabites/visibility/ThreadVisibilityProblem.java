package com.javabites.visibility;

public class ThreadVisibilityProblem {

    public static void main(String[] args) {
        Task t = new Task();
        Thread th = new Thread(t);
        th.start();
        t.keepRunning = false;
    }

    static class Task implements Runnable {
         boolean keepRunning = true;
        //volatile boolean keepRunning = true;
        @Override
        public void run() {
            int i = 0;
            while(keepRunning) {
                i++;
            }
        }
    }
}
