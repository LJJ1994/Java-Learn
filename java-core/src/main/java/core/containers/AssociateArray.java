package main.java.core.containers;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 00:15:15
 * @Modified By:
 */
public class AssociateArray<K, V> {
    private int index;
    private Object[][] pairs;

    public AssociateArray(int length){
        pairs = new Object[length][2];
    }

    public void put(K key, V value){
        if(index >= pairs.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key){
        for (int i = 0; i < index; i++) {
            if(key.equals(pairs[i][0])){
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0]).toString();
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index-1){
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociateArray<String, String> map = new AssociateArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tail");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try{
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("to many pair!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}
