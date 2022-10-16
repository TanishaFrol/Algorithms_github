package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class TestMyBinaryTree {
    private MyBinaryTree<Integer> createTree() {
        return new MyBinaryTree<>();
    }

    @org.junit.jupiter.api.Test
    void testAddAndContains() {
        MyBinaryTree<Integer> tree = createTree();
        assertFalse(tree.contains(5));
        tree.add(5);
        assertTrue(tree.contains(5));

        tree.add(3);
        tree.add(4);
        tree.add(9);
        tree.add(8);
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(8));

    }

    @org.junit.jupiter.api.Test
    void remove() {
        MyBinaryTree<Integer> tree = createTree();
        tree.add(5);
        assertTrue(tree.contains(5));

        tree.remove(5);
        assertFalse(tree.contains(5));

        tree = createTree();
        tree.add(8);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(1);
        tree.add(1);

        tree.remove(8);
        assertFalse(tree.contains(8));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(1));
    }

    @org.junit.jupiter.api.Test
    void testDfs() {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(10);
        tree.add(14);
        tree.add(13);

        Queue<Integer> integers = new ArrayDeque<>();
        tree.dfs(integers::add);
        assertEquals(9, integers.size());
        assertEquals(1, integers.poll());
        assertEquals(3, integers.poll());
        assertEquals(4, integers.poll());
        assertEquals(6, integers.poll());
        assertEquals(7, integers.poll());
        assertEquals(8, integers.poll());
        assertEquals(10, integers.poll());
        assertEquals(13, integers.poll());
        assertEquals(14, integers.poll());
        assertNull(integers.poll());
    }

    @org.junit.jupiter.api.Test
    void testBfs() {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(10);
        tree.add(14);
        tree.add(13);

        Queue<Integer> integers = new ArrayDeque<>();
        tree.bfs(integers::add);
        assertEquals(9, integers.size());

        assertEquals(8, integers.poll());
        assertEquals(3, integers.poll());
        assertEquals(10, integers.poll());
        assertEquals(1, integers.poll());
        assertEquals(6, integers.poll());
        assertEquals(14, integers.poll());
        assertEquals(4, integers.poll());
        assertEquals(7, integers.poll());
        assertEquals(13, integers.poll());
        assertNull(integers.poll());
    }
}