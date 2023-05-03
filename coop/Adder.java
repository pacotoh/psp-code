package org.threads.coop;

public class Adder implements Runnable {

    private final Count count;
    private final int numThread;
    private int myCount;
    private final int toCount;

    public Adder(Count count, int numThread, int toCount) {
        this.count = count;
        this.numThread = numThread;
        this.toCount = toCount;
    }

    public int getMyCount() {
        return this.myCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < toCount; i++) {
            this.count.increment();
            myCount++;
        }
        System.out.printf("Thread %d finished, count: %d\n", numThread, getMyCount());
    }
}
