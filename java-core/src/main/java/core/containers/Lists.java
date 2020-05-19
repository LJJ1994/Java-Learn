package main.java.core.containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 20:53:53
 * @Modified By:
 */
public class Lists {
    private static boolean b;
    private static int i;
    private static String s;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> a){
        a.add(1, "x");
        a.add("x");
        a.addAll(Countries.names(25));
        a.addAll(3, Countries.names(25));
        b = a.contains("1");
        b = a.containsAll(Countries.names(25));
        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);
        i = a.lastIndexOf("1");
        a.remove(1);
        a.remove("3");
        a.set(1, "y");
        a.retainAll(Countries.names(25));
        a.removeAll(Countries.names(25));
        a.clear();
    }

    public static void iterMotion(List<String> a){
        ListIterator<String> iterator = a.listIterator();
        b = iterator.hasNext();
        b = iterator.hasPrevious();
        s = iterator.next();
        i = iterator.nextIndex();
        s = iterator.previous();
        i = iterator.previousIndex();
    }

    public static void iterManipulate(List<String> a){
        ListIterator<String> iterator = a.listIterator();
        iterator.add("47");
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.set("47");
    }

    public static void testVisual(List<String> a){
        System.out.println(a);
        List<String> b = Countries.names(25);
        System.out.println("b = " + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);

        x = a.listIterator(a.size());
        while(x.hasNext()){
            System.out.println(x.previous() + " ");
        }
        System.out.println(" ");
        System.out.println("testVisual finished!");
    }

    public static void testLinkedList(){
        LinkedList<String> ll = new LinkedList<>();
        ll.addAll(Countries.names(10));
        System.out.println(ll);
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        System.out.println(ll.getFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }

    public static void main(String[] args) {
//        testVisual(new ArrayList<String>(Countries.names(25)));
        testLinkedList();
    }
}
