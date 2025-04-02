package org.mj.misctopics.multithreading.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DeadLockSimulator {

    public static void main(String[] args) {
        ReadWriteLock lock1 = new ReentrantReadWriteLock();
        ReadWriteLock lock2 = new ReentrantReadWriteLock();
        Runnable task1 = () -> {
            lock1.writeLock().lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock2.writeLock().lock();
            lock2.writeLock().unlock();
            lock1.writeLock().unlock();
            System.out.println("Task1 ends");
        };

        Runnable task2 = () -> {
            lock2.writeLock().lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock1.writeLock().lock();
            lock1.writeLock().unlock();
            lock2.writeLock().unlock();
            System.out.println("Task2 ends");
        };

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(task1);
        executorService.submit(task2);
        System.out.println("Tasks submitted");
        executorService.close();
        System.out.println("Executor service closed");
    }
}
