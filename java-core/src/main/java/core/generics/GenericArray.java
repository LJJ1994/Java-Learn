package main.java.core.generics;

import org.omg.CORBA.Object;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 05:01:01
 * @Modified By:
 */
public class GenericArray<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int size){
        array = (T[])new Object[size];
    }
    public void add(int index, T item){
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }
    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray = new GenericArray<Integer>(10);
        java.lang.Object[] rep = genericArray.rep();
    }
}
