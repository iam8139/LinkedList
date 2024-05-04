package org.game.service;

public interface CircularlyLinkedList<T> {
    int size();
    boolean isEmpty();
    T first();
    T last();
    void rotate();
    void addFirst();
    void addLast();
    T removeFirst();
}
