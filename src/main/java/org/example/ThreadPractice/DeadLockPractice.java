package org.example.ThreadPractice;

public class DeadLockPractice {
    /*
    If Thread 1 calls methodOne() and Thread 2 simultaneously calls methodTwo(),
    a deadlock is almost guaranteed:

Thread 1 acquires lockA.

Thread 2 acquires lockB.

Thread 1 tries to acquire lockB (and waits for Thread 2).

Thread 2 tries to acquire lockA (and waits for Thread 1).
Result: Both threads are stuck forever.
     */
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void methodOne() {
        synchronized (lockA) {
            System.out.println("Thread 1: Holding lock A...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            System.out.println("Thread 1: Waiting for lock B...");
            synchronized (lockB) {
                System.out.println("Thread 1: Acquired lock A and B!");
            }
        }
    }

    public void methodTwo() {
        synchronized (lockB) {
            System.out.println("Thread 2: Holding lock B...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            System.out.println("Thread 2: Waiting for lock A...");
            synchronized (lockA) {
                System.out.println("Thread 2: Acquired lock B and A!");
            }
        }
    }
}
