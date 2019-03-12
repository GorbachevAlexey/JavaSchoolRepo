package com.sbt.lesson4.taskLinkedList;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements Collection<E> {
    /** начальный элемент списка */
    Node<E> _head = null;
    /** конечный элемента*/
    Node<E> _tail = null;
    /** количество элементов в списке*/
    int _countElement = 0;

    /**
     * добавление элемента в конец списка
     * @param e - значение элемента
     */
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("try add null pointer");
        }

        final Node<E> x = _tail;

        final Node<E> temp = (x != null) ? x.getPrevNode() : null;
        final Node<E> newNode = new Node<E>(e, temp, null);

        _tail = newNode;

        if (x == null)
            _head = newNode;
        else {
            x.setNextNode(newNode);
            _tail.setPrevNode(x);
        }

        ++_countElement;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    /**
     * Добавление элемента по индексу
     * @param index - индекс позиции куда добавлять
     * @param element - значение элемента
     */
    public void add(int index, E element) {
        if (index > _countElement) {
            System.out.println("index > size of list");
        }

        if (index == _countElement)
            add(element);

        else {
            Node<E> x = at(index);

            if (x == null)
                return;

            final Node<E> prev = x.getPrevNode();

            final Node<E> temp = (prev != null) ? prev.getPrevNode() : null;

            final Node<E> newNode = new Node<>(element, temp, x);

            x.setPrevNode(newNode);

            if (prev == null)
                _head = newNode;
            else
                prev.setNextNode(newNode);

            ++_countElement;
        }
    }

    /**
     * Получение значеия по индексу
     * @param index - индекс элемента
     * @return значение
     */
    public E get(int index) {

        Node<E> x = at(index);
        if (x != null)
            return x.getItem();

        return null;
    }
    /**
     * Удаление элемента по индексу
     * @param index - индекс позиции куда добавлять
     * @param  - значение элемента
     */
    public E remove(int index) {

        if (index > _countElement) {
            System.out.println("index > size of list");
            return null;
        }

        Node<E> x = at(index);

        final Node<E> next = x.getNextNode();
        final Node<E> prev = x.getPrevNode();

        if (prev == null) {
            _head = next;
        } else {

            prev.setNextNode(next);
            x.setPrevNode(null);
        }

        if (next == null) {
            _tail = prev;

        } else {
            next.setPrevNode(prev);
            x.setNextNode(null);
        }

        x.setItem(null);

        _countElement--;

        return null;
    }

    /**
     * добавление элементов в конец листа из другой коллекции
     * @param с - ссылка на коллекцию
     * @return
     */
    public boolean addAll(Collection<? extends E> c) {
        Iterator<? extends E> iter = c.iterator();

        while (iter.hasNext())
            add(iter.next());

        return true;
    }

    /**
     * копирование в другую коллекцию элементов данной коллеции
     * @param c ссылка на коллекцию ,в которую требуется выполнить копировать
     * @return
     */
    public boolean copy(Collection<? super E> c) {
        Iterator<E> iter = iterator();

        while (iter.hasNext())
            c.add(iter.next());
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return _countElement;
    }

    @Override
    public boolean isEmpty() {
        return (_countElement == 0);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return new MyListIterator<E>(_head);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this)
            s.append(item + " ");
        return s.toString();
    }

    private Node<E> at(int index) {
        Node<E> x = _head;
        for (int i = 0; i <= index; ++i) {
            if (i == index)
                return x;

            x = x.getNextNode();
        }
        return null;
    }

}