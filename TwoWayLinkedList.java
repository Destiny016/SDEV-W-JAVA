// TwoWayLinkedList.java
// Name: Destiny Harris
// Date: 09-26-2025
// Assignment: Exercise 24.3

import java.util.*;

public class TwoWayLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    /** Create an empty list */
    public TwoWayLinkedList() {
    }

    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
        super(objects);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node<E> newNode = new Node<>(e);

        if (size == 0) { // empty list
            head = tail = newNode;
        } else if (index == 0) { // insert at beginning
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (index == size) { // insert at end
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else { // insert in middle
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }

        size++;
    }

    /** Add element to the end (needed for MyList interface) */
    @Override
    public void add(E e) {
        add(size, e); // reuse your existing add(int, E)
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            if (current.element.equals(e)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        int index = size - 1;
        for (Node<E> current = tail; current != null; current = current.previous) {
            if (current.element.equals(e)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Node<E> current;
        if (index == 0) { // remove first
            current = head;
            head = head.next;
            if (head != null) head.previous = null;
            if (head == null) tail = null;
        } else if (index == size - 1) { // remove last
            current = tail;
            tail = tail.previous;
            if (tail != null) tail.next = null;
            if (tail == null) head = null;
        } else { // remove from middle
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        size--;
        return current.element;
    }

    @Override
    public Object set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Object old = current.element;
        current.element = e;
        return old;
    }

    /** Basic forward iterator */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) throw new NoSuchElementException();
                E e = current.element;
                current = current.next;
                return e;
            }
        };
    }

    /** Full list iterator starting at head */
    public ListIterator<E> listIterator() {
        return new TwoWayListIterator(0);
    }

    /** Full list iterator starting at given index */
    public ListIterator<E> listIterator(int index) {
        return new TwoWayListIterator(index);
    }

    /** Internal list iterator class */
    private class TwoWayListIterator implements ListIterator<E> {
        private Node<E> current;
        private int index;

        public TwoWayListIterator(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            this.index = index;
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) throw new NoSuchElementException();
            E e = current.element;
            current = current.next;
            index++;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return (current != null && current.previous != null) ||
                   (current == null && tail != null);
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (current == null) {
                current = tail;
            } else {
                current = current.previous;
            }
            index--;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /** Doubly linked node */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        Node(E element) {
            this.element = element;
        }
    }
}





