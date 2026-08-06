package org.example.ThreadPractice.ThreadCommunication;

public class ConsumerProducer {
    // 4. Main Execution
    public static void main(String[] args) {
        MessageDrop drop = new MessageDrop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }

    // 1. The Shared Resource
    static class MessageDrop {
        private String message;
        private boolean empty = true;

        public synchronized void put(String message) {
            while (!empty) {
                try {
                    wait(); // Wait for consumer to take the message
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.empty = false;
            this.message = message;
            System.out.println("Producer sent: " + message);
            notifyAll(); // Wake up the consumer
        }

        public synchronized String take() {
            while (empty) {
                try {
                    wait(); // Wait for producer to put a message
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.empty = true;
            String retrievedMessage = this.message;
            System.out.println("Consumer received: " + retrievedMessage);
            notifyAll(); // Wake up the producer
            return retrievedMessage;
        }
    }

    // 2. The Producer Thread
    static class Producer implements Runnable {
        private final MessageDrop drop;

        public Producer(MessageDrop drop) {
            this.drop = drop;
        }

        public void run() {
            String[] messages = {"Data 1", "Data 2", "Data 3", "Data 4"};
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
        private final MessageDrop drop;

        public Consumer(MessageDrop drop) {
            this.drop = drop;
        }

        public void run() {
            for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
