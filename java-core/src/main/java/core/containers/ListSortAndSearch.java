package main.java.core.containers;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-27 08:47:47
 * @Modified By:
 */
public class ListSortAndSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Utilities.list);
        list.addAll(Utilities.list);
        System.out.println(list);
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffle: " + list);

        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println("Trim: " + list);
        Collections.sort(list);
        System.out.println("sort: " + list);
        String key = list.get(7);
        int i = Collections.binarySearch(list, key);
        System.out.println("Location of " + key + " is " + i + ", list.get(" + i + ")= " + list.get(i));
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
        key = list.get(7);
        i = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Location of " + key + " is " + i + ", list.get(" + i + ")= " + list.get(i));
    }
}
