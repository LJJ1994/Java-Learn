package main.java.core.arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 00:07:07
 * @Modified By:
 */
public class GeneratorTest {
    public static final int SIZE=10;
    public static void test(Class<?> surroundingClass){
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName() + ": ");
            try{
                Generator<?> generator = (Generator<?>)type.newInstance();
                for (int i = 0; i < SIZE; i++) {
                    System.out.print(generator.next() + " ");;
                }
            } catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        test(CountingGenerator.class);
        test(RandomGenerator.class);
    }
}
