package main.java.core.innerclasses.holding;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 23:30:30
 * @Modified By:
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(collection);

        Integer[] moreInts = {4,5,6};
        collection.addAll(Arrays.asList(moreInts));
        System.out.println(collection);

        Collections.addAll(collection, 11, 12, 13);
        System.out.println(collection);

        Integer[] moreInts1 = {14,15,16};
        Collections.addAll(collection, moreInts1);
        System.out.println(collection);

        List<Integer> list = Arrays.asList(100, 200,300);
        list.set(0, 101);
        // list.add(400);
        System.out.println(list);

    }
}
