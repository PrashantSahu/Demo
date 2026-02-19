package org.prashant.multith.blockingq;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer<T> {

    private final Object[] items;
    private int head;       // next position to consume from
    private int tail;       // next position to produce into
    private int count;      // current number of items

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public BoundedBuffer(int capacity) {
        this.items = new Object[capacity];
    }

    public void put(T item) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();      // buffer full — wait
            }
            items[tail] = item;
            tail = (tail + 1) % items.length;
            count++;
            notEmpty.signal();        // wake one waiting consumer
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();     // buffer empty — wait
            }
            T item = (T) items[head];
            items[head] = null;       // help GC
            head = (head + 1) % items.length;
            count--;
            notFull.signal();         // wake one waiting producer
            return item;
        } finally {
            lock.unlock();
        }
    }
}