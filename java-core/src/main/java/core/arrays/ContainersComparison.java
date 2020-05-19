package main.java.core.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 22:58:58
 * @Modified By:
 */
class BerylliumSphere{
    private static long counter=0;
    private final long id = counter++;
    public String toString(){
        return "Sphere " + id;
    }
}
public class ContainersComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);
        System.out.println("====================");

        ArrayList<BerylliumSphere> berylliumSpheres = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            berylliumSpheres.add(new BerylliumSphere());
        }
        System.out.println(berylliumSpheres);
        System.out.println(berylliumSpheres.get(4));
        System.out.println("====================");

        int[] integers = {0,1,2,3,4,5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[3]);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        System.out.println(integerList);
        integerList.add(97);
        System.out.println(integerList);
        System.out.println(integerList.get(5));
    }
}
