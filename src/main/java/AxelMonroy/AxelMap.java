package AxelMonroy;

import java.util.*;

/**
 * Created by axel on 20/12/16.
 * github.com/AxelMonroyX
 */
class AxelMap<K, V> implements Map {
    private MyEntry<K, V>[] buckets;
    private int size = 0;

    AxelMap() {
        this.buckets = new MyEntry[10];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {

        return get(key) != null;
    }

    public boolean containsValue(Object value_x) {
        V value = (V) value_x;
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        for (MyEntry<K, V> bucket : buckets) {
            if (bucket != null && value.equals(bucket.getValue()))
                return true;
        }
        return false;
    }

    public Object get(Object key_x) {
        K key = (K) key_x;
        throwErrorKeyNull(key);
        MyEntry<K, V> entry = getEntryKey(key);

        while (entry != null && !key.equals(entry.getKey())) {
            entry = entry.getNext();
        }
        return entry != null ? entry.getValue() : null;
    }

    public Object put(Object key_x, Object value_x) {
        K key = (K) key_x;
        V value = (V) value_x;

        throwErrorKeyNull(key);
        int bucketIndex = key.hashCode() % buckets.length;
        MyEntry<K, V> entry = getEntryKey(key);
        if (entry != null) {
            boolean done = false;
            while (!done && entry != null) {
                if (key.equals(entry.getKey())) {
                    entry.setValue(value);
                } else if (entry.getNext() == null) {
                    entry.setNext(new MyEntry<K, V>(key, value));
                    done = true;

                }
                entry = entry.getNext();
            }

        } else {
            buckets[bucketIndex] = new MyEntry<K, V>(key, value);
            size++;
        }
        return new MyEntry<K, V>(key, value);
    }

    private MyEntry<K, V> getEntryKey(K key) {
        int bucketIndex = key.hashCode() % buckets.length;
        return buckets[bucketIndex];
    }


    public Object remove(Object key_x) {
        K key = (K) key_x;
        throwErrorKeyNull(key);
        MyEntry<K, V> entry = getEntryKey(key);

        while (entry != null && !key.equals(entry.getKey())) {
            entry = entry.getNext();
        }
        if (entry != null) {
            size--;
            entry.setValue(null);
        }
        return entry != null ? entry.getValue() : null;

    }

    public void putAll(Map map) {
        for (Entry<Object, Object> actual : (Iterable<Entry<Object, Object>>) map.entrySet()) {
            put(actual.getKey(), actual.getValue());
        }

    }

    public void clear() {
        this.size = 0;
        buckets = new MyEntry[10];

    }

    public Set keySet() {
        Set<K> totalSetOfKeys = new HashSet<K>();
        for (MyEntry<K, V> bucket : buckets) {
            if (bucket != null) totalSetOfKeys.add(bucket.getKey());
        }
        return totalSetOfKeys;
    }

    public Collection values() {
        Set<V> totalsetOfValues = new HashSet<V>();
        for (MyEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                totalsetOfValues.add(bucket.getValue());
                MyEntry<K, V> bucketAux = bucket.getNext();
                while (bucketAux != null) {
                    totalsetOfValues.add(bucketAux.getValue());
                    bucketAux = bucketAux.getNext();

                }
            }
        }
        return totalsetOfValues;
    }

    public Set<MyEntry<K, V>> entrySet() {
        Set<MyEntry<K, V>> entrySet = new LinkedHashSet<MyEntry<K, V>>();

        for (MyEntry<K, V> bucket : buckets) {

            if (bucket != null) entrySet.add(bucket);


        }
        return entrySet;
    }

    private void throwErrorKeyNull(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }
}
