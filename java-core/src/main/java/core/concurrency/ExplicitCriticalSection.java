package main.java.core.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 08:57:57
 * @Modified By:
 */
class ExplicitPairManager1 extends PairManager{
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try{
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally{
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager{
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        Pair temp;
        lock.lock();
        try{
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally{
            lock.unlock();
        }
        store(temp);
    }
}

public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager pman1 = new ExplicitPairManager1();
        PairManager pman2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }
}
