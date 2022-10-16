package Deque;

import java.util.List;
import java.util.stream.IntStream;

/* ѕопробуйте реализовать двунаправленную очередь (чтобы элементы можно было добавл€ть и удал€ть
     не только в начало (из начала), но и в конец (с конца))*/

public class MyDeque<T> implements Deque<T> {

    private Object[] data;
    private int size;

    public MyDeque(int size) {
        this.data = new Object[size];
        this.size = 0;
    }

    @Override
    public boolean insertFirst(T item) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            data[size++] = item;
            return true;
        }
        Object[] newData = new Object[data.length + 1];
        newData[0] = item;
        for (int i = 0; i < data.length; i++) {
            newData[i + 1] = data[i];
        }
        data = newData;
        size++;
        return true;
    }

    @Override
    public boolean insertLast(T item) {
        if (isFull()) {
            return false;
        }
        data[size++] = item;
        return true;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T peak = peekFirst();
        Object[] newData = new Object[data.length];
        for (int i = 0; i < newData.length - 1; i++) {
            newData[i] = data[i + 1];
        }
        data = newData;
        size--;
        return peak;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T peak = peekLast();
        data[--size] = null;
        return peak;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[0];
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        List<String> dataInStack = IntStream.range(0, size)
                .mapToObj(i -> data[i])
                .map(String::valueOf)
                .toList();
        return "[" + String.join(", ", dataInStack) + "]";
    }
}
