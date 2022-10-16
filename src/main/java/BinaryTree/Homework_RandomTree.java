package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*Написать реализацию метода isBalanced - проверки, является ли дерево сбалансированным.*/

public class Homework_RandomTree {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        int nodesNumber = (int) (Math.random() * 10 + 10);
        System.out.println("\nnodesNumber: " + nodesNumber);
        for (int i = 0; i < nodesNumber; i++) {
            tree.add((int) (Math.random() * 100));
        }
        List<Integer> integers = new ArrayList<>();
        tree.dfs(integers::add);
        System.out.println("dfs: " + integers);
        integers.clear();
        tree.bfs(integers::add);
        System.out.println("bfs: " + integers);

        tree.isBalanced();
    }
}
