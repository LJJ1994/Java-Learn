package main.java.core.generics;

import net.mindview.simple.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 07:13:13
 * @Modified By:
 */
public class Holder<T> {
    private T value;
    public Holder(){}
    public Holder(T val){
        value = val;
    }
    public T get(){
        return value;
    }
    public void set(T newValue){
        value = newValue;
    }
    public boolean equals(Object obj){
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        main.java.core.generics.Apple d = Apple.get();
        Apple.set(d);
//        Holder<Fruit> fruit = Apple;
        Holder<? extends Fruit> fruit = Apple;
        Fruit p = fruit.get();
        d = (main.java.core.generics.Apple)fruit.get();
        try{
            Orange c = (Orange) fruit.get();
        } catch (Exception e){
            System.out.println(e);
        }
//        Apple.set(new Apple());
//        fruit.set(new Apple()); compile error!
        System.out.println(fruit.equals(d));
    }
}
