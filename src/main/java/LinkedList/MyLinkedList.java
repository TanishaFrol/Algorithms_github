package LinkedList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyLink<T> {


    protected class Node<T> {

        protected T value;
        protected Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    protected Node<T> head;

    protected Node<T> getLastNode() {
        if (head == null) {
            return null;
        }
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    protected T extractNodeValue(Node<T> node) {
        return node == null ? null : node.value;
    }

    protected Node<T> getNode(int index) {
        if (head == null) {
            throw new IllegalArgumentException("Index " + index + " out of bounds");
        }
        int count = 0;
        Node<T> currentNode = head;
        while (count != index && currentNode.next != null) {
            currentNode = currentNode.next;
            count++;
        }
        if (count != index) {
            throw new IllegalArgumentException("Index " + index + " out of bounds");
        }
        return currentNode;
    }

    @Override
    public void addFirst(T element) {
        Node<T> newHead = new Node<>(element);
        if (head == null) {
            head = newHead;
            return;
        }
        newHead.next = head;
        head = newHead;
    }

    @Override
    public void addLast(T element) {
        Node<T> newLastNode = new Node<>(element);
        if (head == null) {
            head = newLastNode;
            return;
        }
        Node<T> last = getLastNode();
        last.next = newLastNode;
    }

    @Override
    public T getFirst() {
        return extractNodeValue(head);
    }

    @Override
    public T getLast() {
        return extractNodeValue(getLastNode());
    }

    @Override
    public T get(int index) {
        return extractNodeValue(getNode(index));
    }

    @Override
    public void delete(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IllegalArgumentException("Index " + index + " out of bounds");
            }
            head = head.next;
            return;
        }
        Node<T> node = getNode(index - 1);
        Node<T> nodeForRemove = node.next;
        if (nodeForRemove == null) {
            throw new IllegalArgumentException("Index " + index + " out of bounds");
        }
        Node<T> newNextNode = nodeForRemove.next;
        node.next = newNextNode;
    }

    @Override
    public void add(T element, int index) {
        if (index == 0) {
            addFirst(element);
        }
        Node<T> node = getNode(index - 1);
        Node<T> newNextNode = node.next;
        Node<T> newNode = new Node<>(element, newNextNode);
        node.next = newNode;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node<T> iterator = head;
        while (iterator != null) {
            output.append(iterator.value).append(" -> ");
            iterator = iterator.next;
        }
        if (output.length() > 4) {
            output.deleteCharAt(output.length() - 1);
            output.deleteCharAt(output.length() - 1);
            output.deleteCharAt(output.length() - 1);
            output.deleteCharAt(output.length() - 1);
        }
        return "[" + output + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> cursor = head;

        @Override
        public boolean hasNext() {
            Node<T> iterator = cursor;
            while (iterator != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            Node<T> iterator = cursor;
            while (iterator != null) {
                cursor = cursor.next;
                return extractNodeValue(iterator);
            }
            return null;
        }
    }
}
