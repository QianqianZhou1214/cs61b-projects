package deque;

import afu.org.checkerframework.checker.oigj.qual.O;
import org.junit.Test;

public class ArrayDeque<T> implements Deque<T> {
    private int nextFirst;
    private int nextLast;
    private int capacity;
    private T[] items;
    private int size;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        this.capacity = items.length;
        nextLast = 0;
        nextFirst = capacity - 1;
        size = 0;
    }

    public void resize(int newCapacity){
        T[] a = (T[]) new Object[newCapacity];
        int firstlen = capacity - nextFirst - 1;
        System.arraycopy(items, nextFirst + 1, a, 0, firstlen);
        System.arraycopy(items, 0, a, firstlen, nextLast);
        nextFirst = newCapacity -1;
        nextLast = size;
        items = a;
        capacity = newCapacity;
    }

    public void addFirst(T item) {
        if(size == capacity){
            resize(capacity * 2);
        }
        items[nextFirst] = item;
        size++;
        nextFirst = (nextFirst - 1 + capacity) % capacity;
    }

    public void addLast(T item) {
        if(size == capacity){
            resize(capacity * 2);
        }
        items[nextLast] = item;
        size++;
        nextLast = (nextLast + 1 +capacity) % capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }


    public void printDeque(){
        int index = (nextFirst + 1) % capacity;
        for(int i = 0; i < size; i++){
            System.out.print(items[index] + " ");
            index = (index + 1) % capacity;
        }
        System.out.println();
    }

    public T removeFirst(){
        if (isEmpty()) return null;
        nextFirst = (nextFirst + 1 + capacity) % capacity;
        T removedFirst = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if (capacity >= 16 && size < capacity / 4)
            resize(capacity / 2);
        return removedFirst;
    }

    public T removeLast(){
        if (isEmpty()) return null;
        nextLast = (nextLast - 1 + capacity) % capacity;
        T removedLast = items[nextLast];
        items[nextLast] = null;
        size--;
        if (capacity >= 16 && size < capacity / 4)
            resize(capacity / 2);
        return removedLast;
    }


    public T get(int index){
        if(index >= size || index < 0){
            return null;
        }
        return items[(nextFirst + 1 + index) % capacity];
    }



}
