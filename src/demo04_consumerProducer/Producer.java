package demo04_consumerProducer;

import java.util.Random;

public class Producer implements Runnable {

    private MyStack stack;
    private int counter;
    private Random rand;

    public Producer(MyStack stack, int counter, Random rand) {
        this.stack = stack;
        this.counter = counter;
        this.rand = rand;
    }

    @Override
    public void run() {
        System.out.println("Producer started ...");
        for(int i = 0; i < counter; i++) {
            synchronized (stack) {
                while(stack.isFull()) {
                    
                }
            }
        }
    }
}
