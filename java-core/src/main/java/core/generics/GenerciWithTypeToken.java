package main.java.core.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 05:18:18
 * @Modified By:
 */
class GenericWithTypeToken<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericWithTypeToken(Class<T> type, int size){
        array = (T[])Array.newInstance(type, size); // 加上类型标签
    }
    public void put(int index, T item){
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }
    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericWithTypeToken<Integer> genericArray = new GenericWithTypeToken<Integer>(Integer.class, 10);
        for (int i = 0; i < 10; i++) {
            genericArray.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(genericArray.get(i));;
        }
        Integer[] rep = genericArray.rep();
        System.out.println(Arrays.toString(rep));
    }
}
