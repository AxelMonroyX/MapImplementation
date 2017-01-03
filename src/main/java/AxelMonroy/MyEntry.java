package AxelMonroy;

/**
 * Created by axel on 2/01/17.
 * github.com/AxelMonroyX
 */
class MyEntry<K, V> {
    private MyEntry<K, V> next;
    private K key;
    private V value;

    MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return this.key;
    }

    void setValue(V value) {
        this.value = value;
    }

    V getValue() {
        return this.value;
    }

    void setNext(MyEntry<K, V> next) {
        this.next = next;
    }

    MyEntry<K, V> getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
