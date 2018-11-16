package com.tvion.forth;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;


    @Override
    public Iterator<E> iterator() {
        return new MyIter();
    }

    @Override
    public void add(E element) {
        if (first == null) {
            first = new Node<>(element, null, null);
            last = first;
        } else {
            Node<E> RecNode = new Node<>(element, last, null);
            last.setNext(RecNode);
            last = RecNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        Node<E> newNode = new Node<>(element, null, null);
        Node<E> prevNode = null;
        Node<E> nextNode = null;
        if (index == size) {
            add(element);
            return;
        }
        if (index < size || index > 0) {
            nextNode = getNode(index);
            prevNode = getNode(index - 1);
            nextNode.setPrev(newNode);
            prevNode.setNext(newNode);
        }
        newNode.setNext(nextNode);
        newNode.setPrev(prevNode);
        if (index == 0) {
            first = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).getDatum();
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        for (E nextElem : this) {
            if (nextElem.equals(element)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index == 0) {
            E backValue = first.getDatum();
            first = first.getNext();
            size--;
            return backValue;
        }
        if (index == size - 1) {
            E backValue = first.getDatum();
            last = last.getPrev();
            size--;
            return backValue;
        }
        Node<E> prev = getNode(index - 1);
        E removed = prev.getNext().getDatum();
        Node<E> next = prev.getNext().getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return removed;
    }

    @Override
    public E set(int index, E element) {
        Node<E> modNode = getNode(index);
        E modDatum = modNode.getDatum();
        modNode.setDatum(element);
        return modDatum;
    }

    @Override
    public int size() {
        return size;
    }


    @SuppressWarnings("uncheked")
    public E[] toArray() {
        if (size == 0) return null;
        Class classOfE = first.getDatum().getClass();
        // Далее в цикле защита на случай, если первым элементов в коллекции будет подкласс E
        while (true) {
            try {
                E[] resultArray = (E[]) Array.newInstance(classOfE, size);
                MyIter iter = (MyIter) iterator();
                for (int i = 0; iter.hasNext(); i++) {
                    resultArray[i] = iter.next();
                }
                return resultArray;
            } catch (ArrayStoreException ase) {
                // Да, ловится unchecked exception, но мы же знаем чем она вызвана и как исправить)
                classOfE = classOfE.getSuperclass();
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }


    private Node<E> getNode(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        if (index < size / 2) {
            Node<E> targetNode = first;
            for (int i = 0; i < index; i++) {
                targetNode = targetNode.getNext();
            }
            return targetNode;
        } else {
            Node<E> targetNode = last;
            for (int i = size - 1; i > index; i--) {
                targetNode = targetNode.getPrev();
            }
            return targetNode;
        }
    }


    private class MyIter implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        MyIter() {
            next = first;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = next;
            next = next.getNext();
            nextIndex++;
            return lastReturned.getDatum();
        }

        private Node<E> getLastReturned() {
            return lastReturned;
        }
    }

}






