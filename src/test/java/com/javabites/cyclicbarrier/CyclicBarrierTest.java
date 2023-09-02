package com.javabites.cyclicbarrier;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class CyclicBarrierTest {
    @Test
    public void cycleBarrierTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Barrier());

        List<Thread> players = Stream.generate(() -> new Thread(new Player(cyclicBarrier))).limit(5).toList();
        players.forEach(player -> executorService.submit(player));

        executorService.shutdown();

    }
}
