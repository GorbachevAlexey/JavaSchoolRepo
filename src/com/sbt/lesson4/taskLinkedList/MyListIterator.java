package com.sbt.lesson4.taskLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListIterator<T> implements Iterator<T> {

    private Node<T> _current = null;

    public MyListIterator(Node current) {
        _current = current;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T item = _current.getItem();

        _current = _current.getNextNode();
        return item;
    }

    public boolean hasNext() {
        return _current != null;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}

