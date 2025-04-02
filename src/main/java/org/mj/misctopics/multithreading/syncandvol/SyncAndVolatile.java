package org.mj.misctopics.multithreading.syncandvol;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Counter {
    int count; // making this volatile is not solving race condition

    public synchronized void inc() { // remove 'synchronized' and see race condition
        count++;
    }
}

public class SyncAndVolatile {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 1; i <= 1000; i++) {
                counter.inc();
            }
        };
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        try (executorService) {
            executorService.submit(task);
            executorService.submit(task); // race condition
        }

        System.out.println("Count: " + counter.count);
    }
}
