package main.java.core.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 23:45:45
 * @Modified By:
 */
public class ArrayOfGeneric {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;
        System.out.println(ls);
        ls[0] = new ArrayList<>();
//        ls[1] = new ArrayList<Integer>();
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

        List<BerylliumSphere>[] lists = new List[10];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        System.out.println(Arrays.toString(lists));
    }
}
