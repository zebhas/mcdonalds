/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package McDonalds;

import java.util.Iterator;

public class ListaDobleEncadenada<E> implements Iterable<E>, Comparable<ListaDobleEncadenada<E>> {

    private NodoLista<E> first;
    private NodoLista<E> last;
    private int size;

    public ListaDobleEncadenada() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        NodoLista<E> newNode = new NodoLista<>(element);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
            first = newNode;
        }
        size++;
    }

    public void addLast(E element) {
        NodoLista<E> newNode = new NodoLista<>(element);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (size == 1) {
                first = null;
                last = null;
            } else {
                first = first.getNext();
                first.setPrev(null);
            }
            size--;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (size == 1) {
                first = null;
                last = null;
            } else {
                last = last.getPrev();
                last.setNext(null);
            }
            size--;
        }
    }

    public E first() {
        if (!isEmpty()) {
            return first.getElement();
        }
        return null;
    }

    public E last() {
        if (!isEmpty()) {
            return last.getElement();
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListaDobleIterator();
    }

    private class ListaDobleIterator implements Iterator<E> {

        private NodoLista<E> current = first;
        private NodoLista<E> lastReturned = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E element = current.getElement();
                lastReturned = current;
                current = current.getNext();
                return element;
            }
            return null;
        }

        @Override
        public void remove() {
            if (lastReturned != null) {
                NodoLista<E> prev = lastReturned.getPrev();
                NodoLista<E> next = lastReturned.getNext();

                if (prev != null) {
                    prev.setNext(next);
                } else {
                    first = next;
                }

                if (next != null) {
                    next.setPrev(prev);
                } else {
                    last = prev;
                }

                lastReturned = null;
                size--;
            }
        }
    }

    @Override
    public int compareTo(ListaDobleEncadenada<E> otraLista) {
        // Implementa la lógica de comparación según tus necesidades.
        // Devuelve un valor negativo si esta lista es menor, 0 si son iguales y positivo si es mayor.
        // Por ejemplo, puedes comparar los tamaños de las listas:
        return Integer.compare(this.size, otraLista.size);
    }
}
