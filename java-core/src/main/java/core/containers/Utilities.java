package main.java.core.containers;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-27 08:09:09
 * @Modified By:
 */
public class Utilities {
    static List<String> list = new ArrayList<>(Arrays.asList("one Two three Four five six one".split(" ")));
    public static void main(String[] args) {
        System.out.println(list);
        System.out.println("list.disjoint(Four)" + Collections.disjoint(list, Collections.singletonList("Four")));

        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        System.out.println("max w/ comparator: " + Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator: " + Collections.min(list,String.CASE_INSENSITIVE_ORDER));
        List<String> subList = Arrays.asList("Four five six".split(" "));
        System.out.println("indexOfSublist: " + Collections.indexOfSubList(list, subList));
        System.out.println("lastIndexOfSublist: " + Collections.lastIndexOfSubList(list, subList));
        Collections.replaceAll(list, "one", "Yo");
        System.out.println("replaceAll: " + list);
        Collections.reverse(list);
        System.out.println("reverse: " + list);
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        System.out.println("copy: " + list);
        Collections.swap(list, 0, list.size()-1);
        System.out.println("swap: " + list);
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffle: " + list);
        Collections.fill(list, "pop");
        System.out.println("fill: " + list);
        System.out.println("frequncy: " + Collections.frequency(list, "pop"));

        List<String> dups = Collections.nCopies(3, "snap");
        System.out.println("dups: " +dups);
        System.out.println("list disjoint dups? " + Collections.disjoint(list, dups));
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<>();
        while (e.hasMoreElements()){
            v.addElement(e.nextElement());
        }
        ArrayList<String> arrayList = Collections.list(v.elements());
        System.out.println("arrayList: " + arrayList);
    }
}
