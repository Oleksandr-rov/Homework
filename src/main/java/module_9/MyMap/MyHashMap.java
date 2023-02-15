package module_9.MyMap;

import java.util.*;

public class MyHashMap<K,V> implements MyMap<K,V>{
    Node<K,V>[] table = new Node[16];
    int size;
    static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        @Override
        public String toString() { return "[" + key + " = " + value + "]"; }
        //public String toString() { return "[" + hash + "." + key + "." + value + "." + next + "]"; }
    }
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    private Node<K,V> findLastNode(Node<K,V> node){
        if(node.next == null)
            return node;
        return findLastNode (node.next);
    }
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }
    public void put(K key, V value) {
        int hash = hash(key);
        Node<K, V>[] tab = table;
        int n = table.length;
        int i = (n - 1) & hash;
        Node<K, V> node, e;
        node = tab[i];
        if (tab[i] == null) {
            tab[i] = newNode(hash,key,value,null);
            size++;
        }
        else {
            for (int count = 0; ; ++count) {
                if (node.hash == hash && Objects.equals(node.key, key)) {
                    node.value = value;
                    break;
                }
                if ((e = node.next) == null) {
                    node.next = newNode(hash,key,value,null);
                    size++;
                    break;
                }
                node = e;
            }
        }
        //System.out.println("Arrays.toString(table) = " + Arrays.toString(table));
    }
    public V get(K key) {
        int hash = hash(key);
        Node<K, V>[] tab = table;
        int n = table.length;
        int i = (n - 1) & hash;
        Node<K, V> node, e;
        node = tab[i];
        if (tab[i] != null) {
            if (node.hash == hash && Objects.equals(node.key, key))
                return node.value;
            while ((e = node.next) != null) {
                if (e.hash == hash && Objects.equals(e.key, key)) {
                    return e.value;
                }
                node = e;
            }
        }
        return null;
    }

    public K remove(K key) {
        int hash = hash(key);
        Node<K, V>[] tab = table;
        int n = table.length;
        int i = (n - 1) & hash;
        Node<K, V> node, e;
        node = tab[i];
        if ((tab != null) && (tab[i] != null)) {
            if (node.hash == hash && Objects.equals(node.key, key)){
                tab[i] = node.next;
                return node.key;
            }
            while ((e = node.next) != null) {
                if (e.hash == hash && Objects.equals(e.key, key)) {
                    node.next = node.next.next;
                    return e.key;
                }
                node = e;
            }
        }
        return null;
    }
    public int size() {
        return size;
    }
    public void clear() {
        if (size > 0) {
            size = 0;
            Arrays.fill(table, null);
        }
    }

    @Override
    public String toString() {
        String result = "MyHashMap = {";
        int cnt = 1;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                result += table[i];
                Node<K,V> node,e;
                node = table[i];
                while ((e = node.next) != null) {
                    cnt++;
                    node = e;
                    result += e;
                }
                result += ",";
            }
        }
        return result + "}";
    }
}
