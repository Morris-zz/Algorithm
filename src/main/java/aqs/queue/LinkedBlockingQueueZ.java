package aqs.queue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: morris
 * @Date: 2020/8/17 14:31
 * @reviewer
 */
public class LinkedBlockingQueueZ<E> {


    private LinkedList<E> list ;
    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();

    private final ReentrantLock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();
    private final int capacity;


    public LinkedBlockingQueueZ() {
//        capacity = Integer.MAX_VALUE;
        capacity = 2;
    }

    public void put(E e) throws InterruptedException {
        takeLock.lockInterruptibly();
        try {
            while (list.size() >= capacity){
                notFull.await();
            }

        }finally {
            takeLock.unlock();
        }
    }

    public E take() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                this.wait();
            }
            return list.removeFirst();
        }
    }

}
