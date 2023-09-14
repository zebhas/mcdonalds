/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cola<T> implements Iterable<T> {
    private ItemCola<T> primero;
    private ItemCola<T> ultimo;
    private int tamanio;

    public boolean estaVacio() {
        return tamanio == 0;
    }

    public int tamanio() {
        return tamanio;
    }

    public void encolar(T valor) {
        ItemCola<T> nuevo = new ItemCola<T>(valor);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
    }

    public T desencolar() {
        if (estaVacio()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        T ret = primero.getValor();
        primero = primero.getSiguiente();
        tamanio--;
        return ret;
    }

    public T first() {
        if (estaVacio()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return primero.getValor();
    }

    @Override
    public Iterator<T> iterator() {
        return new ColaIterator();
    }

    private class ColaIterator implements Iterator<T> {
        private ItemCola<T> actual = primero;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T element = actual.getValor();
                actual = actual.getSiguiente();
                return element;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            // No implementado
        }
    }
}
