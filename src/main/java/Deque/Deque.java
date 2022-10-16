package Deque;

public interface Deque<T> {
    boolean insertFirst(T item);

    boolean insertLast(T item);

    T removeFirst();

    T removeLast();

    T peekFirst();

    T peekLast();

    boolean isEmpty();

    boolean isFull();
}
