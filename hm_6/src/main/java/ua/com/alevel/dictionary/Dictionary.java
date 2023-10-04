package ua.com.alevel.dictionary;
import java.util.*;

public class Dictionary<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    private static final int sizeArrays = 3;

    public Dictionary() {
        size = 0;
        keys = (K[]) new Object[size];
        values = (V[]) new Object[size];
    }

    private void ensureCapacity() {
        if (size == keys.length) {
            int newCapacity = keys.length + 1;
            K[] newKeys = (K[]) new Object[newCapacity];
            V[] newValues = (V[]) new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newKeys[i] = keys[i];
                newValues[i] = values[i];
            }

            keys = newKeys;
            values = newValues;
        }
    }

    public boolean put(K key, V value) {
        ensureCapacity();

        keys[size] = key;
        values[size] = value;
        size++;

        return true;
    }

    public boolean putAll(Dictionary<K, V> secondDictionary) {
        for (int i = 0; i < secondDictionary.size; i++) {
            K key = (K) secondDictionary.keys[i];
            V value = (V) secondDictionary.values[i];
            put(key, value);
        }

        return false;
    }

    public Set<K> keySet() {
        Set<K> keyList = new HashSet<>();

        for (int i = 0; i < size; i++) {
            K key = (K) keys[i];
            keyList.add(key);
        }

        return keyList;
    }

    public boolean remove(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                keys[i] = keys[size - 1];
                values[i] = values[size - 1];
                keys[size - 1] = null;
                values[size - 1] = null;
                size--;
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public V get(K key ) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V) values[i];
            }
        }

        return null;
    }

    public Collection<V> values() {
        Set<V> valuesList = new HashSet<>();

        for (int i = 0; i < size; i++) {
            V value = values[i];
            valuesList.add(value);
        }

        return valuesList;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, values[i])) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        if(size == 0) {
            System.out.println("Пустой");
            return true;
        }

        System.out.println("Не пустой, э " + size + " елемента");
        return false;
    }

    public boolean clear() {
        size = 0;
        keys = (K[]) new Object[size];
        values = (V[]) new Object[size];

        return true;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println("Ключ: " + keys[i] + ", Значення: " + values[i]);
        }
    }

    public void noteTest() {
        put((K) "1", (V)  "apple");
        put((K) "2", (V)  "banana");
        put((K) "3", (V)  "orange");
    }

    public void secondNoteTest() {
        put((K) "4", (V)  "apple2");
        put((K) "5", (V)  "banana2");
        put((K) "6", (V)  "orange2");
    }

}


