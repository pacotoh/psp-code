package org.threads.simplethread;

public class MainThreads {
    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++) {
            MyThread mt = new MyThread("Thread" + i);
            mt.start();
        }*/

        for (int i = 0; i < 5; i++) {
            MyThreadWait mt = new MyThreadWait("Thread" + i);
            mt.start();
        }

        /*for (int i = 0; i < 5; i++) {
            StateThread mt = new StateThread("Thread" + i);
            mt.start();
        }*/
    }
}
