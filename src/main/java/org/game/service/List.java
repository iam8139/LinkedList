package org.game.service;

public interface List<T> {
    int size();
    boolean isEmpty();
    T get(int i);
    T set(int i, T val);
    void add(int i, T val);
    T remove(int i);
}
