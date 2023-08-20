package com.javabites.multiplelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker2 {

    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static Random random = new Random();

    static synchronized   void stageOne() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));

    }

    static synchronized   void stageTwo() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));

    }

    static void process() {
        for(int i = 0 ; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            process();
        });

        Thread t2 = new Thread(() -> {
            process();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();

        System.out.println("list 1 : "+ list1.size());
        System.out.println("list 2 : "+ list2.size());

        System.out.println(end - start);
    }

}
