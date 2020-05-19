package main.java.core.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-29 14:34:34
 * @Modified By:
 */
public class ConsumerProducer {
    private static final String EXIT_MSG = "good bye!";

    public static void main(String[] args) {
        new AtomicInteger();
        BlockingQueue<String> q = new ArrayBlockingQueue<String>(3);
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable{
        private BlockingQueue<String> queue;
        public Producer(BlockingQueue<String> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(20L);
                    String msg = "Message " + i;
                    System.out.println("Produce item " + i);
                    queue.put(msg);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            try{
                System.out.println("time to say good bye!");
                queue.put(EXIT_MSG);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable{
        private BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try{
                String msg;
                while (!EXIT_MSG.equalsIgnoreCase(msg=queue.take())){
                    System.out.println("Consumed item: " + msg);
                    Thread.sleep(10L);
                }
                System.out.println("Got exit message, bye!");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
