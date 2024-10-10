package org.mj.from17to21.JEP444_virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreads {
    public static void main(String[] args) {
        testPlatformThreads(1000);
        testPlatformThreads(10_000);
        testPlatformThreads(100_000);
        //testPlatformThreads(1_000_000);
    }

    private static void testPlatformThreads(int maximum) {
        long time = System.currentTimeMillis();

        // for Virtual threads use -> Executors.newVirtualThreadPerTaskExecutor()
        try (var executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, maximum).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }

        time = System.currentTimeMillis() - time;
        System.out.println("Number of threads = " + maximum + ", Duration(ms) = " + time);
    }
}
