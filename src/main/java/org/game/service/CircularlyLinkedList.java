package org.game.service;

public interface CircularlyLinkedList<T> {
    int size();
    boolean isEmpty();
    T first();
    T last();
    void rotate();
    void addFirst(T value);
    void addLast(T value);
    T removeFirst();
}
