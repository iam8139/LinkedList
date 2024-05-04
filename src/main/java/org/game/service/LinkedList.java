package org.game.service;

public interface LinkedList<T> {
    int size();
    boolean isEmpty();
    T first();
    T last();
    void addFirst(T node);
    void addLast(T node);
    T removeFirst();
}
