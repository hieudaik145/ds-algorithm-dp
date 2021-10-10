package com.github.hieuvv.da.tree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DemoBinaryTree {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        //    9
        //  4    20
        // 1 6 15 170
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println(gson.toJson(tree.getRoot()));
        Node node = tree.lookup(1);
        System.out.println(node);

        System.out.println("======Breath first search======");
        tree.breathFirstSearch();

        System.out.println("======Breath first search recursive======");
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.getRoot());
        tree.breathFirstSearchRecursive(queue);

        System.out.println("======Depth first search recursive InOrder======");
        List<Integer> listInOrder = new ArrayList<>();
        tree.depthFirstSearchInOrder(tree.getRoot(), listInOrder);
        printArray(listInOrder);

        System.out.println("======Depth first search recursive PreOrder======");
        List<Integer> listPreOrder = new ArrayList<>();
        tree.depthFirstSearchPreOrder(tree.getRoot(), listPreOrder);
        printArray(listPreOrder);

        System.out.println("======Depth first search recursive PostOrder======");
        List<Integer> listPostOrder = new ArrayList<>();
        tree.depthFirstSearchPostOrder(tree.getRoot(), listPostOrder);
        printArray(listPostOrder);
    }

    static void printArray(List<Integer> list) {
        list.forEach(x -> System.out.print(x + "\t"));
        System.out.println();
    }
}

class BinarySearchTree {

    private Node root;

    void insert(Integer value) {
        Node newNode = new Node(value);
        if (root == null) {
            this.root = newNode;
            return;
        }

        Node currentNode = root;
        while (true) {
            if (value < currentNode.getValue()) {
                // handle left
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    break;
                }
                currentNode = currentNode.getLeft();
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    break;
                }
                currentNode = currentNode.getRight();
            }
        }
    }
    
    Node lookup(Integer value) {
        if (root == null) {
            return null;
        }
        Node currentNode = root;
        while (currentNode != null) {
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    //    9
    //  4    20
    // 1 6 15 170
    void breathFirstSearch() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
            System.out.println(currentNode.getValue());
        }
    }

    void breathFirstSearchRecursive(Queue<Node> queue) {

        if (queue.isEmpty()) {
            return;
        }

        Node currentNode = queue.poll();
        System.out.println(currentNode.getValue());
        if (currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }

        breathFirstSearchRecursive(queue);
    }

    //    9
    //  4    20
    // 1 6 15 170
    // Depth first search
    // InOrder - [1, 4, 6, 9, 15, 20, 170]
    // PreOrder - [9, 4 , 1, 6, 20, 15, 170
    // PostOrder - [1, 6, 4, 15, 170, 20, 9]

    void depthFirstSearchInOrder(Node root, List<Integer> list) {
        if (root.getLeft() != null) {
            depthFirstSearchInOrder(root.getLeft(), list);
        }
        list.add(root.getValue());
        if (root.getRight() != null) {
            depthFirstSearchInOrder(root.getRight(), list);
        }
    }

    void depthFirstSearchPreOrder(Node root, List<Integer> list) {
        list.add(root.getValue());
        if (root.getLeft() != null) {
            depthFirstSearchPreOrder(root.getLeft(), list);
        }
        if (root.getRight() != null) {
            depthFirstSearchPreOrder(root.getRight(), list);
        }
    }

    void depthFirstSearchPostOrder(Node root, List<Integer> list) {
        if (root.getLeft() != null) {
            depthFirstSearchPostOrder(root.getLeft(), list);
        }
        if (root.getRight() != null) {
            depthFirstSearchPostOrder(root.getRight(), list);
        }
        list.add(root.getValue());
    }



    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

class Node {

    private Node left;

    private Node right;

    private Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
