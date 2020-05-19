package main.java.core.concurrency;

import net.mindview.util.CountingGenerator;
import net.mindview.util.CountingIntegerList;
import net.mindview.util.MapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-08 11:51:51
 * @Modified By:
 */

abstract class MapTest extends Tester<Map<Integer, Integer>> {

    MapTest(String testId, int nReaders, int nWriters) {
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
                    testContainer.put(j, writeData[j]);
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

class SynchronizedHashMapTest extends MapTest{
    SynchronizedHashMapTest(int nReaders, int nWriters){
        super("Synched HashMap ", nReaders, nWriters);
    }
    @Override
    Map<Integer, Integer> containerInitializer() {
        return Collections.synchronizedMap(
                new HashMap<Integer, Integer>(
                        MapData.map(
                                new CountingGenerator.Integer(),
                                new CountingGenerator.Integer(),
                                containSize
                        )
                )
        );
    }
}

class ConcurrentHashMapTest extends MapTest{
    ConcurrentHashMapTest(int nReaders, int nWriters){
        super("ConcurrentHashMap ", nReaders, nWriters);
    }
    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ConcurrentHashMap<Integer, Integer>(
                MapData.map(new CountingGenerator.Integer(),
                        new CountingGenerator.Integer(),
                        containSize
                )
        );
    }
}

public class MapComparisons {
    public static void main(String[] args) {
        Tester.intMain(args);
        new SynchronizedHashMapTest(10, 0);
        new SynchronizedHashMapTest(9, 1);
        new SynchronizedHashMapTest(5, 5);
        new ConcurrentHashMapTest(10, 0);
        new ConcurrentHashMapTest(9, 1);
        new ConcurrentHashMapTest(5, 5);
        Tester.executorService.shutdownNow();
    }
}

