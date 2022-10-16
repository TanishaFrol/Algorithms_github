package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTreeDemo {
    public static void main(String[] args) {
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

        tree.dfs(System.out::println);
        List<Integer> integers = new ArrayList<>();
        tree.dfs(integers::add);
        System.out.println(integers);
    }
}
