package ru.job4j.iterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        Node<T> nodeLast = head;
        final Node<T> newNode = new Node<>(value, null);
        if (nodeLast == null) {
            head = newNode;
        } else {
            while (nodeLast.next != null) {
                nodeLast = nodeLast.next;
            }
            nodeLast.next = newNode;
        }
        size++;
        modCount++;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T result = head.item;
        Node<T> first = head.next;
        head.item = null;
        head.next = null;
        head = first;
        size--;
        modCount++;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int exceptedModCount = modCount;
            Node<T> cursor = head;

            @Override
            public boolean hasNext() {
                if (exceptedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> el = cursor;
                cursor = cursor.next;
                return el.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
    }
