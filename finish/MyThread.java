package org.threads.finish;

import java.util.Random;

public class MyThread implements Runnable{
    private final String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("Hi! I'm the Thread: %s.\n", this.name);
        Random rnd = new Random();

        int pause;

        for(int i = 0; i < 5; i++){
            pause = 500;//10 + rnd.nextInt(490);
            System.out.printf("Thread: %s pauses %d ms.\n", this.name, pause);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                System.out.printf("Thread %s interrupted. \n", this.name);
            }
        }
        System.out.printf("Thread %s terminated. \n", this.name);
    }
}
