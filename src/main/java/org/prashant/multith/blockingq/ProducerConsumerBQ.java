package org.prashant.multith.blockingq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBQ {

    private final BlockingQueue<Integer> buffer;

    public ProducerConsumerBQ(int capacity) {
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    public void start() {
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.put(i);
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int item = buffer.take();
                    System.out.println("Consumed: " + item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        producer.start();
        consumer.start();
    }

    public static void main(String[] args) {
        new ProducerConsumerBQ(3).start();
    }
}