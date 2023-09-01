package com.javabites.threadpool.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadRunnable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 1; i <= 20; i++) {
            //executorService.execute(new Task(i));
            Future future = executorService.submit(new Task(i));
            if(future.isDone()) {
                System.out.println("completed");
            }
        }
        executorService.shutdown();

    }

    static class Task implements Runnable {
        int id;
        public Task(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            try {
                System.out.println("Running task : "+ id);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
