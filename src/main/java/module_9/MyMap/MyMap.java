package module_9.MyMap;

public interface MyMap<K,V> {
    void put(K key, V value);
    V get(K key);
    K remove(K key);
    int size();
    void clear();
}
