package org.threads.prodcons;

public class Consumer implements Runnable {
    private String name;
    private Product product;

    public Consumer(String name, Product product){
        this.name = name;
        this.product = product;
    }

    @Override
    public void run() {
        while(true) {
            try {
                this.product.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
