package main.java.core.concurrency;

import net.mindview.util.CountingIntegerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-08 10:05:05
 * @Modified By:
 */
abstract class ListTest extends Tester<List<Integer>> {

    ListTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    class Reader extends TestTask{
        long result = 0;
        @Override
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int j = 0; j < containSize; j++) {
                    result += testContainer.get(j);
                }
            }
        }

        @Override
        void putResults() {
            readResult += result;
            readTime += duration;
        }
    }

    class Writer extends TestTask{

        @Override
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int j = 0; j < containSize; j++) {
                    testContainer.set(j, writeData[j]);
                }
            }
        }

        @Override
        void putResults() {
            writeTime += duration;
        }
    }

    void startReadersAndWriter(){
        for (int i = 0; i < nReaders; i++) {
            executorService.execute(new Reader());
        }
        for (int i = 0; i < nWriters; i++) {
            executorService.execute(new Writer());
        }
    }
}

class SynchronizedArrayListTest extends ListTest{
    SynchronizedArrayListTest(int nReaders, int nWriters){
        super("Synch ArrayList ", nReaders, nWriters);
    }
    @Override
    List<Integer> containerInitializer() {
        return Collections.synchronizedList(
                new ArrayList<Integer>(new CountingIntegerList(containSize))
        );
    }
}

class CopyOnWriteArrayListTest extends ListTest{
    CopyOnWriteArrayListTest(int nReaders, int nWriters){
        super("CopyOnWriteArrayList ", nReaders, nWriters);
    }
    @Override
    List<Integer> containerInitializer() {
        return new CopyOnWriteArrayList<Integer>(
                new CountingIntegerList(containSize)
        );
    }
}

public class ListComparisons {
    public static void main(String[] args) {
        Tester.intMain(args);
        new SynchronizedArrayListTest(10, 0);
        new SynchronizedArrayListTest(9, 1);
        new SynchronizedArrayListTest(5, 5);
        new CopyOnWriteArrayListTest(10, 0);
        new CopyOnWriteArrayListTest(9, 1);
        new CopyOnWriteArrayListTest(5, 5);
        Tester.executorService.shutdownNow();
    }
}
