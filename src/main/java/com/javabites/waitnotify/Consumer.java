package com.javabites.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

class Consumer extends Thread {
  private volatile Queue<String> sharedQueue;
  private volatile boolean bExit;
 
  public Consumer(Queue<String> myQueue, boolean bExit) {
    this.sharedQueue = myQueue;
    this.bExit = bExit;
  }
 
  public void run() {
 
    while (!bExit) {
 
      synchronized (sharedQueue) {
        while (!sharedQueue.isEmpty()) {
          String item = sharedQueue.poll();
          System.out.println("Consumer removed : " + item);
          System.out.println("Consumer notifying Producer: " + item);
          sharedQueue.notify();
        }
      }
    }
  }

  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    Thread producer = new Thread(new Producer(queue, false));
    producer.start();
    Thread consumer = new Thread(new Consumer(queue, false));
    consumer.start();
  }
}

