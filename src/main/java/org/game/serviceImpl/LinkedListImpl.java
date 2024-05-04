package org.game.serviceImpl;

import org.game.service.LinkedList;

public class LinkedListImpl<T> implements LinkedList<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;
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
        if (head != null) return head.value;
        return null;
    }

    @Override
    public T last() {
        if (tail != null) return tail.value;
        return null;
    }

    @Override
    public void addFirst(T val) {
        head = new Node<>(val, head);
        if (size == 0) tail = head;
        size++;
    }

    @Override
    public void addLast(T val) {
        if (tail != null) {
            Node<T> temp = new Node<>(val, null);
            tail.next = temp;
            tail = temp;
        } else {
            tail = new Node<>(val, null);
            head = tail;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        size--;
        if (size == 0) tail = null;
        return temp.value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        Node(T value) {
            this.value = value;
        }
        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
