package aqs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: morris
 * @Date: 2020/8/11 17:13
 * @reviewer
 */
public class Aqs extends AbstractQueuedSynchronizer {
    public static void main(String[] args) {
        int a,b=1;
        a = b = 1+b;
        System.out.println(b);
    }
}
