package com.javabites.phaser;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Phaser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongRunningActionTest {
    @Test
    public void testPhaserLongRunning() {

        Phaser ph = new Phaser(1);
        assertEquals(0, ph.getPhase());

        System.out.println("Parties: " + ph.getRegisteredParties());


        Thread t1 = new Thread(new LongRunningAction("thread-1", ph));
        Thread t2 = new Thread(new LongRunningAction("thread-2", ph));
        Thread t3= new Thread(new LongRunningAction("thread-3", ph));

        System.out.println("Parties: " + ph.getRegisteredParties());

        t1.start();
        t2.start();
        t3.start();



        ph.arriveAndAwaitAdvance();
        assertEquals(1, ph.getPhase());
        System.out.println("Phase 1 evaluation is done");


        Thread t4 = new Thread(new LongRunningAction("thread-4", ph));
        Thread t5 = new Thread(new LongRunningAction("thread-5", ph));
        System.out.println("Parties: " + ph.getRegisteredParties());
        t4.start();
        t5.start();

        ph.arriveAndAwaitAdvance();

        System.out.println("Phase 2 evaluation is done");

        assertEquals(2, ph.getPhase());
        ph.arriveAndDeregister();

    }
}
