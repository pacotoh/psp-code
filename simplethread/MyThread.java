package org.threads.simplethread;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
        System.out.println("Creating Thread: " + getName());
    }

    public void run() {
        System.out.println("Running Thread: " + getName());
    }
}
