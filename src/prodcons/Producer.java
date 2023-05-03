package org.threads.prodcons;

public class Producer implements Runnable {

    private String name;
    private Product product;

    public Producer(String name, Product product){
        this.name = name;
        this.product = product;
    }

    @Override
    public void run() {
        while(true) {
            try {
                this.product.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
