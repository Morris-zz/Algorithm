package aqs.queue;

import java.util.LinkedList;

/**
 * @Author: morris
 * @Date: 2020/8/17 14:31
 * @reviewer
 */
public class LinkedBlockingQueueZ<E> {


    private LinkedList<E> list = new LinkedList<E>();

    public void put(E e) {
        synchronized (this) {
            list.add(e);
            this.notify();
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
