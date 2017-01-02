package github.com.AxelMonroyX;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by axel on 20/12/16.
 * github.com/AxelMonroyX
 */
public class AxelMap<K, V> implements Map {
    private MyEntry<K, V>[] buckets;
    private int size = 0;

    public AxelMap() {
        this.buckets = new MyEntry[10];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object o) {
        return false;
    }

    public boolean containsValue(Object o) {
        return false;
    }

    public Object get(Object keyx) {
        K key = (K) keyx;
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int bucketIndex = key.hashCode() % buckets.length;
        MyEntry<K, V> entry = buckets[bucketIndex];

        while (entry != null && !key.equals(entry.getKey())) {
            entry = entry.getNext();
        }
        return entry != null ? entry.getValue() : null;
    }

    public Object put(Object keyx, Object valuex) {
        K key = (K) keyx;
        V value = (V) valuex;

        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int bucketIndex = key.hashCode() % buckets.length;
        MyEntry<K, V> entry = buckets[bucketIndex];
        if (entry != null) {
            boolean done = false;
            while (!done && entry!= null) {
                if ( key.equals(entry.getKey())) {
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
        return new MyEntry(key, value);
    }


    public Object remove(Object o) {
        return null;
    }

    public void putAll(Map map) {

    }

    public void clear() {

    }

    public Set keySet() {
        return null;
    }

    public Collection values() {
        return null;
    }

    public Set<Entry> entrySet() {
        return null;
    }
}