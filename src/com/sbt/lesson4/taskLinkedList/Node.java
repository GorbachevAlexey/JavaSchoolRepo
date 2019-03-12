package com.sbt.lesson4.taskLinkedList;

public class Node<T>
{
    private T _item;
    private Node<T> _next;
    public Node<T> _prev;

    /**
     * конструктор класса
     * @param item значение
     * @param prev ссылка на предудущий элемент
     * @param next ссылка на следующий элемент
     */
    public Node(T item, Node<T> prev,Node<T> next)
    {
        _item = item;
        _next = next;
        _prev = prev;
    }

    /**
     * Получение значение элемента
     * @return
     */
    public T getItem()
    {
        return _item;
    }

    /**
     * Установить значение элемента
     * @param val - значение
     */
    public void setItem(T val)
    {
        _item = val;
    }

    /**
     * Получение ссылки на следующий элемент
     * @return ссылка на следующий элемент списка
     */
    public Node<T> getNextNode()
    {
        return  _next;
    }

    /**
     * Установить ссылку на следующий элемент
     * @param next
     */
    public void setNextNode(Node<T> next)
    {
        _next = next;
    }

    /**
     * получение ссылки на предыдущий элемент
     * @return
     */
    public Node<T> getPrevNode()
    {
        return  _prev;
    }

    /**
     * установка ссылки на следующий элемент
     * @param prev
     */
    public void setPrevNode(Node<T> prev)
    {
        _prev = prev;
    }
}