package main.java.core.containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 10:14:14
 * @Modified By:
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    private static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        boolean found = false;
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        ListIterator<MapEntry<K, V>> iterator = bucket.listIterator();
        while (iterator.hasNext()){
            MapEntry<K, V> iPair = iterator.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                iterator.set(pair);
                found = true;
                break;
            }
        }
        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            return null;
        }
        LinkedList<MapEntry<K, V>> pair = buckets[index];
        for (MapEntry<K, V> entry : pair) {
            if (entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> entry : bucket) {
                set.add(entry);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Map<String, String> map = new SimpleHashMap<>();
        map.putAll(Countries.capitals(5));
        System.out.println(map);
        System.out.println(map.get("BURKINA FASO"));
    }
}
