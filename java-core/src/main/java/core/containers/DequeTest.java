package main.java.core.containers;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 23:09:09
 * @Modified By:
 */
public class DequeTest {
    static void fillTest(Deque<Integer>  deque){
        for (int i = 0; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di = new Deque<>();
        fillTest(di);
        System.out.println(di);
        while (di.size() != 0){
            System.out.print(di.removeFirst() + " ");
        }
        System.out.println();
        fillTest(di);
        while (di.size() != 0){
            System.out.print(di.removeLast() + " ");
        }
    }
}
