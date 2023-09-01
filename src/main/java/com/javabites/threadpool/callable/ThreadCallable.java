package com.javabites.threadpool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadCallable {
    static class Task implements Callable<Task> {
        int id;
        boolean flag;
        public Task(int id) {
            this.id = id;
        }
        @Override
        public Task call() throws Exception {
            flag = true;
            return this;
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Task>> futures = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            Future<Task> result = executorService.submit(new Task(i));
            //result.isDone()
            //result.isCancelled()
            futures.add(result);
        }
        for(Future<Task> result : futures) {
            Task task = null;
            try {
                //task = result.get(); // blocking
                task = result.get(2, TimeUnit.SECONDS); // blocking
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task "+ task.id + " got completed");

        }

        System.out.println("main terminated");
        executorService.shutdown();
    }
}
