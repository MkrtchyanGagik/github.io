package com.company.collections;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MyArrayList<E> implements List {


    private static int capacity = 10;

    public int currentIndex = 0;


    Object[] elementData;


    private int size;


    public MyArrayList() {
        this.elementData = new Object[capacity];
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
    public boolean contains(Object o) {


        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {

                return currentIndex < size;
            }

            @Override
            public Object next() {

                return elementData[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }


    @Override
    public boolean add(Object o) {

        if (size < elementData.length) {

            elementData[size++] = o;
            return true;
        } else {

            Object[] tempElementData = grow(capacity);
            System.arraycopy(elementData, 0, tempElementData, 0, elementData.length - 1);
            elementData = tempElementData;
            elementData[size++] = o;
            return true;
        }
    }


    @Override
    public boolean remove(Object o) {

        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;

    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public Object set(int index, Object element) {

        Object oldValue = elementData[index];
        elementData[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {

        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    public Object[] grow(int currentCapacity) {
        capacity += currentCapacity / 2;
        return new Object[capacity];
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }


}
