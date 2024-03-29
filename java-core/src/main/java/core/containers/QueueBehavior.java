package main.java.core.containers;

import net.mindview.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 22:36:36
 * @Modified By:
 */
public class QueueBehavior {
    public static int count = 10;
    static <T> void test(Queue<T> queue, Generator<T> gen){
        for (int i = 0; i < count; i++) {
            queue.offer(gen.next());
        }
        while(queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
    static class Gen implements Generator<String>{
        int i = 0;
        String[] s = "one two three four five six seven eight nine ten".split(" ");
        @Override
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
        test(new ArrayBlockingQueue<String>(count), new Gen());
        test(new ConcurrentLinkedDeque<>(), new Gen());
        test(new LinkedBlockingQueue<>(), new Gen());
        test(new PriorityBlockingQueue<>(), new Gen());
    }
}
