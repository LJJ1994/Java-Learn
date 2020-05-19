package main.java.core.containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 10:34:34
 * @Modified By:
 */
public class CollectionMethod {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);
        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));
        String[] str = c.toArray(new String[0]);
        System.out.println("Collection.max() " + Collections.max(c));
        System.out.println("Collection.min() " + Collections.min(c));

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);

        c.remove(Countries.DATA[0][0]);
        System.out.println(c);
        c.remove(Countries.DATA[1][0]);
        System.out.println(c);

        c.removeAll(c2);
        System.out.println(c);
        c.addAll(c2);
        System.out.println(c);

        System.out.println("c contains c2? " + c.containsAll(c2));
        String s = Countries.DATA[3][0];
        System.out.println(s);
        System.out.println("c contains s ?" + c.contains(s));

        Collection<String> c3 = ((List<String>)c).subList(3, 5);
        System.out.println(c3);
        c2.retainAll(c3); // 交集，保留参数中的元素
        System.out.println(c2);

        c2.removeAll(c3);
        System.out.println("c2 isEmpty() " + c2.isEmpty());

        c = new ArrayList<>();
        c.addAll(Countries.names(6));
        System.out.println(c);
        c.clear();
        System.out.println("c.clear() " + c);
    }
}
