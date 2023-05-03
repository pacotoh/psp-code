package org.threads.simplethread;

public class StateThread extends Thread {

    public StateThread(String name) {
        super(name);
        System.out.println("Creating Thread: " + getName() + " with Id: " + this.getId());
        System.out.println("Thread state at construction stage: " + this.getState());
    }

    public void run() {
        if (this.getName().equals("Thread3")){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread state at running stage: " + this.getState());
        System.out.println("Running Thread: " + getName() + " with Id: " + this.getId());
    }
}
