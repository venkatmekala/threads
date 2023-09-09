package com.javabites.phaser;


import org.junit.jupiter.api.Test;

import java.util.concurrent.Phaser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhaserExampleTest {

    @Test
    public void testPhaserExample() {
        Phaser phaser = new Phaser();
        phaser.register();
        new PhaserExample("Dog ", phaser).start();
        new PhaserExample("Cat ", phaser).start();
        new PhaserExample("Rabbit ", phaser).start();
        System.out.println("Main Arrived at Phase 1");
        phaser.arriveAndAwaitAdvance();

        assertEquals(1, phaser.getPhase());
        assertEquals(0, phaser.getArrivedParties());

        phaser.arriveAndAwaitAdvance();
        System.out.println("Main Arrived at Phase 2");
        assertEquals(2, phaser.getPhase());
        assertEquals(0, phaser.getArrivedParties());

        System.out.println("------------------------------------------");

        new PhaserExample("Horse ", phaser).start();
        new PhaserExample("Elephant ", phaser).start();
        phaser.arriveAndAwaitAdvance();

        assertEquals(3, phaser.getPhase());
        assertEquals(2, phaser.getArrivedParties());

        phaser.arriveAndAwaitAdvance();
        assertEquals(4, phaser.getPhase());
        assertEquals(0, phaser.getArrivedParties());
    }
}
