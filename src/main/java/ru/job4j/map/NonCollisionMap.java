package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    public int indexFind(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    public boolean keyEquals(K key1, K key2) {
        boolean rsl = false;
        int hashCodeKey1 = Objects.hashCode(key1);
        int hashCodeKey2 = Objects.hashCode(key2);
        if (hashCodeKey1 == hashCodeKey2) {
            rsl = Objects.equals(key1, key2);
            }
        return rsl;
    }

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
        int index = indexFind(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            rsl = true;
            count++;
            modCount++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> capacity);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> el : table) {
            if (el != null) {
                int index = indexFind(el.key);
                newTable[index] = el;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = indexFind(key);
        V rsl = null;
        if (table[index] != null) {
            K keyFind = table[index].key;
            if (keyEquals(keyFind, key)) {
                  rsl = table[index].value;
            }
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFind(key);
        if (Objects.nonNull(table[index])) {
            K keyFind = table[index].key;
            if (keyEquals(keyFind, key)) {
                table[index] = null;
                rsl = true;
                count--;
                modCount++;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int exceptedModCount = modCount;
            int cursor = 0;


            @Override
            public boolean hasNext() {
                if (exceptedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < capacity && table[cursor] == null) {
                    cursor++;
                }
                return cursor < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return table[cursor++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
