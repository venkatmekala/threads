package com.javabites.multiplelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocks {


    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static Random random = new Random();

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    static  void setOne() {
        synchronized (lock1) {
            for (int i = 0; i < 10000; i++) {
                list1.add(random.nextInt(100));
            }
        }
    }

    static   void setTwo() {
        synchronized (lock2) {
            for (int i = 0; i < 10000; i++) {
                list2.add(random.nextInt(100));
            }
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            setOne();
            setTwo();
        });

        Thread t2 = new Thread(() -> {
            setOne();
            setTwo();
        });

        long timeStart = System.currentTimeMillis();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("list 1 : "+ list1.size());
        System.out.println("list 2 : "+ list2.size());

        System.out.println(endTime - timeStart);
    }
}
