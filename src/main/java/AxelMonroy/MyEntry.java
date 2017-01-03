package AxelMonroy;

/**
 * Created by axel on 2/01/17.
 * github.com/AxelMonroyX
 */
public class MyEntry<K, V> {
    private MyEntry<K, V> next;
    private K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return this.value;
    }

    public void setNext(MyEntry<K, V> next) {
        this.next = next;
    }

    public MyEntry<K, V> getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
