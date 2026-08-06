package org.example.ThreadPractice.ThreadCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MordenConsumerProducer {
    // 4. Main Execution
    public static void main(String[] args) {
        ModernMessageDrop drop = new ModernMessageDrop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }

    // 1. The Shared Resource
    static class ModernMessageDrop {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        private String message;
        private boolean empty = true;

        public void put(String msg) {
            lock.lock();
            try {
                while (!empty) {
                    notFull.await(); // Wait in the "Not Full" room
                }
                this.message = msg;
                this.empty = false;
                System.out.println("Producer sent: " + msg);

                notEmpty.signal(); // Specifically wake up a Consumer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }

        public String take() {
            lock.lock();
            try {
                while (empty) {
                    notEmpty.await(); // Wait in the "Not Empty" room
                }
                this.empty = true;
                String retrievedMessage = this.message;
                System.out.println("Consumer received: " + retrievedMessage);

                notFull.signal(); // Specifically wake up a Producer
                return retrievedMessage;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            } finally {
                lock.unlock();
            }
        }
    }

    // 2. The Producer Thread
    static class Producer implements Runnable {
        private final ModernMessageDrop drop;

        public Producer(ModernMessageDrop drop) {
            this.drop = drop;
        }

        public void run() {
            String[] messages = {"Data A", "Data B", "Data C", "Data D"};
            for (String msg : messages) {
                drop.put(msg);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            drop.put("DONE");
        }
    }

    // 3. The Consumer Thread
    static class Consumer implements Runnable {
        private final ModernMessageDrop drop;

        public Consumer(ModernMessageDrop drop) {
            this.drop = drop;
        }

        public void run() {
            for (String message = drop.take(); message != null && !message.equals("DONE"); message = drop.take()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
