package org.prashant.multith;

import java.util.concurrent.Semaphore;

public class OddEvenPrinter {

    private final int limit;
    private final Semaphore oddPermit  = new Semaphore(1);  // odd goes first
    private final Semaphore evenPermit = new Semaphore(0);

    public OddEvenPrinter(int limit) {
        this.limit = limit;
    }

    public void start() {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= limit; i += 2) {
                oddPermit.acquireUninterruptibly();
                System.out.println("Odd-Thread:  " + i);
                evenPermit.release();
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= limit; i += 2) {
                evenPermit.acquireUninterruptibly();
                System.out.println("Even-Thread: " + i);
                oddPermit.release();
            }
        });

        oddThread.start();
        evenThread.start();
    }

    public static void main(String[] args) {
        new OddEvenPrinter(10).start();
    }
}
