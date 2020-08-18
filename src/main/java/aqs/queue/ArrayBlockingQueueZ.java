package aqs.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: morris
 * @Date: 2020/8/18 11:11
 * @reviewer
 */
public class ArrayBlockingQueueZ<E> {
    final Object[] queue;
    private final ReentrantLock lock;
    final Condition notFull;
    final Condition notEmpty;
    final int capacity;
    private int count;
    private int putIndex = 0;
    private int takeIndex = 0;

    public ArrayBlockingQueueZ(int capacity, Boolean fair) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.lock = new ReentrantLock(fair);
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
        this.count = 0;
    }

    public void put(E o) throws Exception {
        checkNotNull(o);
        lock.lockInterruptibly();
        try {
            while (count == capacity) {
                notFull.await();
            }
            enqueue(o);
        } finally {
            lock.unlock();
        }

    }

    public E take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return dequeue();
        } finally {
            lock.unlock();
        }

    }

    private E dequeue() {
        final Object[] items = this.queue;
        Object item = items[takeIndex];
        E e = (E) item;
        items[takeIndex] = null;
        if (++takeIndex == capacity) {
            takeIndex = 0;
        }
        notFull.signal();
        return e;


    }

    private void enqueue(E o) {
        final Object[] queue = this.queue;
        queue[putIndex] = o;
        if (++putIndex == queue.length) {
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
    }

    private void checkNotNull(E o) {
        if (o == null) {
            throw new NullPointerException();

        }
    }
}
