package org.game.serviceImpl;

import org.game.service.DoublyLinkedList;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {
    private int size = 0;
    private Node<T> header;
    private Node<T> trailer;
    public DoublyLinkedListImpl() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }
    private static class Node<T> {
        private T val;
        private Node<T> next;
        private Node<T> prev;
        public Node(T val) {
            this.val = val;
        }
        public Node(T val, Node<T> prev, Node<T> next) {
            this.val = val;
            this.prev = prev;
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
        return header.next.val;
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        return trailer.prev.val;
    }

    @Override
    public void addFirst(T val) {
        addBetween(val, header, header.next);
    }

    @Override
    public void addLast(T val) {
        addBetween(val, trailer.prev, trailer);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        return remove(header.next);
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.prev);
    }

    private void addBetween(T val, Node<T> pred, Node<T> succ) {
        pred.next = new Node<>(val, pred, succ);
        succ.prev = pred.next;
        size++;
    }

    private T remove(Node<T> node) {
        Node<T> predecessor = node.prev;
        Node<T> successor = node.next;
        predecessor.next = successor;
        successor.prev = predecessor;
        size--;
        return node.val;
    }
}
