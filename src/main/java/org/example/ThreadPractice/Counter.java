package org.example.ThreadPractice;

public class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
