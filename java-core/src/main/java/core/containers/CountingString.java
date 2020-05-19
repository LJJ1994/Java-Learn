package main.java.core.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 10:42:42
 * @Modified By:
 */
public class CountingString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    public CountingString(String st){
        s = st;
        created.add(s);
        for (String s1 : created) {
            if (s1.equals(s)){
                id++;
            }
        }
    }

    public int hashCode(){
        int result = 37;
        result = result * 37 + s.hashCode();
        result = result * 37 + id;
        return result;
    }

    public boolean equals(Object obj){
        return (obj instanceof CountingString) &&
                s.equals(((CountingString)obj).s) &&
                (id==((CountingString)obj).id);
    }

    public String toString(){
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    public static void main(String[] args) {
        Map<CountingString, Integer> map = new HashMap<>();
        CountingString[] cs = new CountingString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountingString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountingString c : cs) {
            System.out.println("looking for up: " + c);
            System.out.println(map.get(c));
        }
    }
}
