package main.java.core.containers;

import java.util.WeakHashMap;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-27 09:48:48
 * @Modified By:
 */
class Element{
    private String ident;
    public Element(String id){
        ident = id;
    }
    public String toString(){
        return ident;
    }
    public int hashCode(){
        return ident.hashCode();
    }
    public boolean equals(Object r){
        return r instanceof Element && (((Element) r).ident.equals(ident));
    }
    protected void finalize(){
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}
class Key extends Element{
    public Key(String id){
        super(id);
    }
}
class Value extends Element{
    public Value(String val){
        super(val);
    }
}

public class CanonicalMappings {
    public static void main(String[] args) {
        int size = 100;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i%3 == 0){
                keys[i] = k;
            }
            map.put(k, v);
        }
        System.out.println(keys);
        System.out.println(map);
        System.gc();
    }
}
