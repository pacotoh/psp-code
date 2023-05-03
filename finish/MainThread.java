package org.threads.finish;

public class MainThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("T1"));
        Thread t2 = new Thread(new MyThread("T2"));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted.");
        }
        System.out.println("Main Thread Terminated.");
    }
}