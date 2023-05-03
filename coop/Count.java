package org.threads.coop;

public class Count {
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public synchronized void increment() {
        this.count++;
    }
}
