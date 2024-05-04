package org.game.service;

public interface DoublyLinkedList<T> {
    int size();
    boolean isEmpty();
    T first();
    T last();
    void addFirst(T val);
    void addLast(T val);
    T removeFirst();
    T removeLast();
}
