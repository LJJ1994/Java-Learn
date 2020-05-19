package main.java.core.arrays;

import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 08:19:19
 * @Modified By:
 */
class CompTypeComparator implements Comparator<CompType>{

    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
    }
}
public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] array = Generated.array(new CompType[6], CompType.generator());
        System.out.println("before sort");
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new CompTypeComparator());
        System.out.println("after sort");
        System.out.println(Arrays.toString(array));
    }
}
