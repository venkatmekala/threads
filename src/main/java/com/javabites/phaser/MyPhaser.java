package com.javabites.phaser;

import java.util.concurrent.Phaser;

public class MyPhaser {
    public static void main(String[] args) {
        Phaser myPhaser = new Phaser();
        myPhaser.register();

        System.out.println("let's start phaser example");

        int phase=0;

        MyThread cat = new MyThread(myPhaser, "cat");
        MyThread dog = new MyThread(myPhaser, "dog");
        MyThread elephant = new MyThread(myPhaser, "elephant");

        myPhaser.arriveAndAwaitAdvance();

        System.out.println("Ending phase one");

        myPhaser.arriveAndAwaitAdvance();

        System.out.println("Ending phase two");

        //MyThread horse = new MyThread(myPhaser, "Horse");
        //MyThread Dino = new MyThread(myPhaser, "Dino");

        myPhaser.arriveAndAwaitAdvance();

        System.out.println("Ending phase three");
    }
 }

