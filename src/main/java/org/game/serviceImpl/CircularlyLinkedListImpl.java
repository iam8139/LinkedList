package org.game.serviceImpl;

import org.game.service.CircularlyLinkedList;

public class CircularlyLinkedListImpl<T> implements CircularlyLinkedList<T> {
    private int size = 0;
    private Node<T> tail = null;
    private class Node<T> {
        private T value;
        private Node<T> next;
        public Node(T value) {
            this.value = value;
        }
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public T first() {
        if (isEmpty()) return null;
        return tail.next.value;
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        return tail.value;
    }

    @Override
    public void rotate() {
        if (tail != null) {
            tail = tail.next;
        }
    }

    @Override
    public void addFirst(T value) {
        if (tail != null) {
            tail.next = new Node<>(value, tail.next);
        } else {
            tail = new Node<>(value);
            tail.next = tail;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        addFirst(value);
        rotate();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        Node<T> head = tail.next;
        if (head == tail) tail = null;
        else tail.next = head.next;
        size--;
        return head.value;
    }
}
