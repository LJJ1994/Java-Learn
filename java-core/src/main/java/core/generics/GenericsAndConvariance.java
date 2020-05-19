package main.java.core.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 06:59:59
 * @Modified By:
 */
class Fruit{}
class Apple extends Fruit{}
class Orange extends Fruit{}
class Jonathan extends Apple{}

public class GenericsAndConvariance {
    static Apple getApple(){
        return new Apple();
    }
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Fruit fruit = flist.get(0);
        System.out.println(fruit);
        System.out.println(flist.contains(fruit));
        System.out.println(flist.indexOf(fruit));
    }
}
