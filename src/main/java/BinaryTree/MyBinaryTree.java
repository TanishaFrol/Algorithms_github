package BinaryTree;

import java.util.*;
import java.util.function.Consumer;

public class MyBinaryTree<T extends Comparable<T>> implements Tree<T> {

    private int count;
    private List<Integer> counts;

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    @Override
    public void add(T item) {
        Objects.requireNonNull(item);
        root = appendNode(root, item);
    }

    private Node appendNode(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }
        int compare = value.compareTo(current.value);
        if (compare < 0) {
            current.left = appendNode(current.left, value);
        } else if (compare > 0) {
            current.right = appendNode(current.right, value);
        }
        return current;
    }

    @Override
    public boolean contains(T item) {
        return Objects.nonNull(findNode(root, item));
    }

    private Node findNode(Node current, T value) {
        if (Objects.isNull(current)) {
            return null;
        }
        int compare = value.compareTo(current.value);
        if (compare < 0) {
            return findNode(current.left, value);
        } else if (compare > 0) {
            return findNode(current.right, value);
        }
        return current;
    }

    @Override
    public void remove(T item) {
        root = remove(root, item);
    }

    private Node remove(Node current, T value) {
        if (Objects.isNull(current)) {
            return null;
        }
        int compare = value.compareTo(current.value);
        if (compare < 0) {
            current.left = remove(current.left, value);
            return current;
        } else if (compare > 0) {
            current.right = remove(current.right, value);
            return current;
        }
        if (current.left == null && current.right == null) {
            return null;
        }
        if (current.left == null) {
            return current.right;
        }
        if (current.right == null) {
            return current.left;
        }
        Node minOnTheRight = findMin(current.right);
        current.value = minOnTheRight.value;
        current.right = remove(current.right, minOnTheRight.value);
        return current;
    }

    private Node findMin(Node current) {
        Node left = current.left;
        return Objects.isNull(left) ? current : findMin(left);
    }

    public void dfs(Consumer<T> visitor) {
        dfs(root, visitor);
    }

    private void dfs(Node current, Consumer<T> visitor) {
        if (current != null) {
            dfs(current.left, visitor);
            visitor.accept(current.value);
            dfs(current.right, visitor);
        }
    }

    /*    public List<T> collectDfs() {
            List<T> items = new ArrayList<>();
            dfs(items::add);
            return items;
        }
        public void printDfs(){
            dfs(System.out::println);
        }*/
    public void bfs(Consumer<T> visitor) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            visitor.accept(node.value);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
/*    public List<T> collectBfs() {
        List<T> items = new ArrayList<>();
        bfs(items::add);
        return items;
    }

    public void printBfs(){
        bfs(System.out::println);
    }*/

    public void isBalanced() {
        if (root == null) {
            System.out.println("BinaryTree is empty!");
        }
        count = 0;
        counts = new ArrayList<>();
        findLeavesLevels(root);
        System.out.println("tree leaves levels: " + counts);
        isBalanced(counts);
    }

    private void findLeavesLevels(Node current) {
        if (current.left == null && current.right == null) {
            count++;
            counts.add(count);
            count--;
        }
        if (current.left != null) {
            count++;
            findLeavesLevels(current.left);
            count--;
        }
        if (current.right != null) {
            count++;
            findLeavesLevels(current.right);
            count--;
        }
    }

    private void isBalanced(List<Integer> counts) {
        Set<Integer> set = new TreeSet<>(counts);
        int max = findMax(set);
        int min = findMin(set);
        if ((max - min) > 1) {
            System.out.println("BinaryTree isn't balanced");
        } else {
            System.out.println("BinaryTree is balanced");
        }
    }

    private int findMax(Set<Integer> set) {
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private int findMin(Set<Integer> set) {
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public boolean isBalanced_v2() {
        return isBalanced_v2(root);
    }

    private boolean isBalanced_v2(Node current) {
        if (current == null) {
            return true;
        }
        return isBalanced_v2(current.left) && isBalanced_v2(current.right) && (Math.abs(height(current.left) - height(current.right)) <= 1);
    }

    private int height(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + Math.max(height(current.left), height(current.right));
    }
}
