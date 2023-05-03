package org.threads.simplethread;

public class MyThreadWait extends Thread {

    public MyThreadWait(String name) {
        super(name);
        System.out.println("Creating Thread: " + getName());
    }

    public void run() {
        if (this.getName().equals("Thread3")){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Running Thread: " + getName());
    }
}
