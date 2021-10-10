package com.github.hieuvv.da.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class DriveTestLinkedList {

    // 10 ---> 5 ---> 16

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);

//        System.out.println(myLinkedList.toString());
        myLinkedList.append(5);

        myLinkedList.append(16);
//        System.out.println(myLinkedList.toString());
        myLinkedList.prepend(1);

        myLinkedList.printList();
        myLinkedList.insert(2, 99);
        myLinkedList.insert(-1, 15);
        myLinkedList.insert(100, 33);

        myLinkedList.printList();

        myLinkedList.remove(3);
        myLinkedList.printList();
        myLinkedList.remove(-1);
        myLinkedList.printList();
        myLinkedList.remove(99);
        myLinkedList.printList();

        myLinkedList.reverse2();
        myLinkedList.printList();

        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(0, 23);
    }
}

class MyLinkedList {

    private Node head;

    private Node tail;

    private int length;

    public MyLinkedList() {

    }

    public MyLinkedList(Object value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = head;
        this.length = 1;
    }

    public void append(Object value) {
        Node node = new Node(value);
        if (length == 0) {
            this.head = node;
            this.tail = head;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.length++;
    } //O(1) time complexity

    public void prepend(Object value) {
        Node node = new Node(value);

        if (length == 0) {
            this.head = node;
            this.tail = head;
        } else {
            node.setNext(this.head);
            this.head = node;
        }

        this.length++;
    } // O(1) time complexity

    public void insert(int index, Object value) {
        Node newNode = new Node(value);
        if (index <= 0) {
            prepend(value);
            return;
        }
        if (index >= length) {
            append(value);
            return;
        }

        Node leader = traverseToIndex(index - 1);
        Node holdingPointer = leader.getNext();
        leader.setNext(newNode);
        newNode.setNext(holdingPointer);
        this.length++;
    } // O(n) time complexity

    public void remove(int index) {

        if (index <= 0) {
            this.head = head.getNext();
            this.length--;
            return;
        }
        if (index >= length) {
            printList();
            index = length - 1;
        }

        Node leader = traverseToIndex(index - 1);
        Node unwantedNode = leader.getNext();
        leader.setNext(unwantedNode.getNext());
        this.length--;
    } // O(n) time complexity

    private Node traverseToIndex(int index) {
        Node currentNode = head;
        int counter = 0;
        while (counter++ != index) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Assume give a linked list [0, 2, 8, 5, 16, 9] reverse:
     * should be [9, 16, 5, 8, 2, 0]
     */
    public void reverse() {

        if (this.length == 0) {
            return;
        }

        Node currentNode = head;

        MyLinkedList reverseLinkedList = new MyLinkedList();

        while (currentNode != null) {
            reverseLinkedList.prepend(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        this.head = reverseLinkedList.getHead();
        this.tail = reverseLinkedList.getTail();
        this.length = reverseLinkedList.getLength();
    }

    /**
     * Assume give a linked list [0, 2, 8, 5, 16, 9] reverse:
     * should be [9, 16, 5, 8, 2, 0]
     */
    public void reverse2() {
        if (this.head.getNext() == null) {
            return;
        }
        Node first = this.head;
        this.tail = this.head;
        Node second = first.getNext();
        while (second != null) {
            Node temp = second.getNext();
            second.setNext(first);
            first = second;
            second = temp;
        }
        this.head.setNext(null);
        this.head = first;
    }

    public void printList() {

        Node currentNode = head;

        StringBuilder sb = new StringBuilder("[ ");
        boolean first = true;
        while (currentNode != null) {
            if (first) {
                sb.append(currentNode.getValue());
                first = false;
            } else {
                sb.append(", ").append(currentNode.getValue());
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head.toString() +
                ", tail=" + tail.toString() +
                ", length=" + length +
                '}';
    }

}

class Node {

    private Object value;

    private Node next;

    public Node() {
    }

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}