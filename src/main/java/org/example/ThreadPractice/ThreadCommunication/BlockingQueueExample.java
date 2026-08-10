package org.example.ThreadPractice.ThreadCommunication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Create a queue with a maximum capacity of 2 items
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        Thread consumerThread = new Thread(new Consumer(queue));
        Thread producerThread = new Thread(new Producer(queue));

        consumerThread.start();
        producerThread.start();
    }

    static class Producer implements Runnable {
        // 1. The Producer Thread
        private final BlockingQueue<String> queue;

        Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String[] messages = {"Data X", "Data Y", "Data Z", "DONE"};
            try {
                for (String s : messages) {
                    queue.put(s);
                    System.out.println("Producer produced: " + s);
                    Thread.sleep(500); // Simulate work
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.getMessage();
            }
        }
    }

    // 2. The Consumer Thread
    static class Consumer implements Runnable {
        private final BlockingQueue<String> queue;

        Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // queue.take() automatically BLOCKS if the queue is empty
                    String message = queue.take();
                    System.out.println("Consumer consumed: " + message);
                    if (message.equalsIgnoreCase("Done")) {
                        System.out.println("Consumer received DONE signal. Terminating.");
                        break;
                    }
                    Thread.sleep(2000);// Simulate processing time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
