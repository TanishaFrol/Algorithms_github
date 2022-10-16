package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMyLinkedList {
    private static MyLinkedList<Integer> createLinkedList() {
        return new MyLinkedList<>();
    }

    @Test
    void testEmptyList() {
        Assertions.assertEquals("[]", createLinkedList().toString());
    }

    @Test
    void testAddLast() {
        MyLinkedList<Integer> list = createLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Assertions.assertEquals("[1 -> 2 -> 3]", list.toString());
    }

    @Test
    void testAddFirst() {
        MyLinkedList<Integer> list = createLinkedList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        Assertions.assertEquals("[1 -> 2 -> 3]", list.toString());
    }

    @Test
    void testGetFirst() {
        MyLinkedList<Integer> list = createLinkedList();
        Assertions.assertNull(list.getFirst());
        list.addFirst(3);
        Assertions.assertEquals(3, list.getFirst());
        list.addFirst(2);
        list.addFirst(1);
        Assertions.assertEquals(1, list.getFirst());
    }

    @Test
    void testGetLast() {
        MyLinkedList<Integer> list = createLinkedList();
        Assertions.assertNull(list.getLast());
        list.addFirst(3);
        Assertions.assertEquals(3, list.getLast());
        list.addFirst(2);
        list.addFirst(1);
        Assertions.assertEquals(3, list.getLast());
    }

    @Test
    void testGetByIndex() {
        MyLinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(5));
        list.addFirst(3);
        Assertions.assertEquals(3, list.get(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(1));
        list.addFirst(2);
        list.addFirst(1);
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(3));
    }

    @Test
    void testDeleteByIndex() {
        MyLinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(5));
        list.addFirst(3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(1));
        list.delete(0);
        Assertions.assertEquals("[]", list.toString());
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(5));
        list.delete(0);
        Assertions.assertEquals("[2 -> 3 -> 4 -> 5]", list.toString());
        list.delete(2);
        Assertions.assertEquals("[2 -> 3 -> 5]", list.toString());
    }

    @Test
    void testAddAtIndex() {
        MyLinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.add(-1, 5));
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.add(-1, 10));
        list.add(-1, 3);
        Assertions.assertEquals("[1 -> 2 -> 3 -> -1 -> 4 -> 5]", list.toString());
    }

}