package org.prashant.multith.blockingq;

public class ProducerConsumerCustom {

    public static void main(String[] args) {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(3);

        int numProducers = 3;
        int numConsumers = 3;
        int itemsPerProducer = 5; // each producer will produce 5 items

        // Start multiple producers
        for (int p = 1; p <= numProducers; p++) {
            final int producerId = p;
            Thread producer = new Thread(() -> {
                for (int i = 1; i <= itemsPerProducer; i++) {
                    int value = producerId * 100 + i; // encode which producer created it
                    try {
                        buffer.put(value);
                        System.out.println("Producer-" + producerId + " produced: " + value);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }, "Producer-" + producerId);
            producer.start();
        }

        // Total items produced = numProducers * itemsPerProducer.
        // We let each consumer take the same number of items so total consumed matches.
        int itemsPerConsumer = itemsPerProducer; // because numConsumers == numProducers

        // Start multiple consumers
        for (int c = 1; c <= numConsumers; c++) {
            final int consumerId = c;
            Thread consumer = new Thread(() -> {
                for (int i = 0; i < itemsPerConsumer; i++) {
                    try {
                        int item = buffer.take();
                        System.out.println("Consumer-" + consumerId + " consumed: " + item);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }, "Consumer-" + consumerId);
            consumer.start();
        }
    }
}
