package main.java.core.arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 08:04:04
 * @Modified By:
 */
public class CompType implements Comparable<CompType>{
    public int i;
    public int j;
    private static int count = 1;
    public CompType(int i, int j){
        this.i = i;
        this.j = j;
    }
    public String toString(){
        String result = "[i=" + i + ", " + "j=" + j + "]";
        if(count++ % 3 == 0){
            result += "\n";
        }
        return result;
    }
    @Override
    public int compareTo(CompType other) {
        return (i < other.i ? -1 : (i == other.i ? 0 : 1));
    }
    public static Random rand = new Random(47);
    public static Generator<CompType> generator(){
        return new Generator<CompType>(){
            @Override
            public CompType next() {
                return new CompType(rand.nextInt(100), rand.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] array = Generated.array(new CompType[12], generator());
        System.out.println("before sorted");
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("after sored");
        System.out.println(Arrays.toString(array));
    }
}
