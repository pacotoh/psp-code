package org.threads.prodcons;

public class MainProdCons {
    public static void main(String[] args) {
        Product product = new Product(0);

        Thread producer = new Thread(new Producer("Producer", product));
        Thread consumer = new Thread(new Consumer("Consumer", product));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
