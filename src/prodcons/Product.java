package org.threads.prodcons;

public class Product {

    private int quantity;
    private static final int MAX_QUANTITY = 5;

    public Product(int quantity) {
        this.quantity = quantity;
    }

    public synchronized void consume() throws InterruptedException {

        while (this.quantity == 0)
            wait();

        this.quantity--;
        System.out.println("Consumer consume to: " + this.quantity);

        notify();
        Thread.sleep(1000);

    }

    public synchronized void produce() throws InterruptedException {

        while (this.quantity == MAX_QUANTITY)
            wait();

        this.quantity++;
        System.out.println("Producer produce to: " + this.quantity);

        notify();
        Thread.sleep(1000);
    }
}
