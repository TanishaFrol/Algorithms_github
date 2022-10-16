package HashTable;

import java.util.ArrayList;

public class MyHashTableChainMethod<K, V> implements HashTable<K, V> {

    private final ArrayList<Item<K, V>>[] data;
    private int size;
    private final Item<K, V> emptyItem;

    public MyHashTableChainMethod(int initialCapacity) {
        this.data = new ArrayList[initialCapacity * 2];
        emptyItem = new Item<>(null, null);
    }

    public MyHashTableChainMethod() {
        this(16);
    }

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }
        int index = hashFunc(key);
        if (data[index] != null) {
            for (int i = 0; i < data[index].size(); i++) {
                if (isKeysEquals(data[index].get(i), key)) {
                    data[index].get(i).setValue(value);
                    return true;
                }
            }
            data[index].add(new Item<>(key, value));
        } else {
            data[index] = new ArrayList<>();
            data[index].add(new Item<>(key, value));
        }
        size++;
        return true;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        return (item.getKey() == null) ? (key == null) : (item.getKey().equals(key));
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return null;
        }
        for (int i = 0; i < data[index].size(); i++) {
            if (isKeysEquals(data[index].get(i), key)) {
                return data[index].get(i).getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return null;
        }
        for (int i = 0; i < data[index].size(); i++) {
            if (isKeysEquals(data[index].get(i), key)) {
                Item<K, V> removed = data[index].get(i);
                data[index].remove(i);
                return removed.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = %s%n", i, data[i]));
        }
        return sb.toString();
    }
}
