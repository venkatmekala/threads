package com.javabites.waitnotify;

import java.util.Queue;

class Producer extends Thread {
  private volatile Queue<String> sharedQueue;
  private volatile boolean bExit;
 
  public Producer(Queue<String> myQueue, boolean bExit) {
    this.sharedQueue = myQueue;
    this.bExit = bExit;
  }
 
  public void run() {
    while (!bExit) {
      synchronized (sharedQueue) {
        while (sharedQueue.isEmpty()) {
          String item = String.valueOf(System.nanoTime());
          sharedQueue.add(item);
          System.out.println("Producer added : " + item);
          try {
            System.out.println("Producer sleeping by calling wait: " + item);
            sharedQueue.wait();
            System.out.println("Producer wake up: ");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}

