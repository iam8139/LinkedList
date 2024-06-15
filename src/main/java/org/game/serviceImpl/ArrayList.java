package org.game.serviceImpl;

import org.game.service.List;

public class ArrayList<T> implements List<T> {
    private static final int CAPACITY = 16;
    T[] arr;
    private int size = 0;
    public ArrayList(int capacity) {
        arr = (T[]) new Object[capacity];
    }
    public ArrayList() {
        this(CAPACITY);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int i) {
        checkIndex(i);
        return arr[i];
    }

    @Override
    public T set(int i, T val) {
        checkIndex(i);
        T temp = arr[i];
        arr[i] = val;
        return temp;
    }

    @Override
    public void add(int i, T val) {
        checkIndex(i);
        if (size == arr.length) throw new IllegalStateException("Array already full");
        for (int k = size-1; k >= i; k--) {
            arr[k+1] = arr[k];
        }
        arr[i] = val;
        size++;
    }

    @Override
    public T remove(int i) {
        checkIndex(i);
        T temp = arr[i];
        for (int j = i; j < size-1; j++) {
            arr[j] = arr[j+1];
        }
        arr[size-1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i) {
        if (i < 0 || i >= arr.length) throw new IndexOutOfBoundsException("Illegal Index: " + i);
    }
}
