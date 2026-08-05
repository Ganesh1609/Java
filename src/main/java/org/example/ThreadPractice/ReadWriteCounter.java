package org.example.ThreadPractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private int count = 0;

    public static void main(String[] args) {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " Read : " + readWriteCounter.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    readWriteCounter.increment();
                    System.out.println(Thread.currentThread().getName() + " Incremented : " + readWriteCounter.getCount());
                }
            }
        };
        Thread writerThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(writeTask);

        writerThread.start();
        readThread1.start();
        readThread2.start();
        try {
            writerThread.join();
            readThread1.join();
            readThread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }
}
