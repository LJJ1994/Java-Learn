package main.java.core.containers;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 09:08:08
 * @Modified By:
 */
public class Pair<K, V> {
    public final K key;
    public final V value;
    public Pair(K k, V v){
        key = k;
        value = v;
    }
}
