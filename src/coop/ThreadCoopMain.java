package org.threads.coop;


public class ThreadCoopMain {
    private static final int THREAD_NUMBER = 10;
    private static final int TOTAL_COUNT = 100000;

    public static void main(String[] args) {
        Count count = new Count();
        Thread[] threads = new Thread[THREAD_NUMBER];

        for (int i = 0; i < THREAD_NUMBER; i++) {
            Thread t = new Thread(new Adder(count, i, TOTAL_COUNT/THREAD_NUMBER));
            t.start();
            threads[i] = t;
        }

        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interruption");
            }
        }
        System.out.printf("Global Count: %s\n", count.getCount());
    }
}
