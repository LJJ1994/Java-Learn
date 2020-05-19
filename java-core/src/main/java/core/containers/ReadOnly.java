package main.java.core.containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-27 09:01:01
 * @Modified By:
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableList(new ArrayList<>(data));
        System.out.println(c);
//        c.add("one");
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> it = a.listIterator();
        System.out.println(it.next());
//        it.add("one");

        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        System.out.println(s);
//        s.add("one");
        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<String, String>(Countries.capitals(6)));
        System.out.println(m);
//        m.put("one", "two");

        SortedMap<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<String, String>(Countries.capitals(7)));
        System.out.println(sm);
    }
}
