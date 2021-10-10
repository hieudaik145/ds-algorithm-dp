package com.github.hieuvv.da.linkedlist;

public class DriveTestDoubleLinkedList {

    // 10 ---> 5 ---> 16

    public static void main(String[] args) {
        MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList(10);

        System.out.println(myDoubleLinkedList.toString());
        myDoubleLinkedList.append(5);

        myDoubleLinkedList.append(16);
        System.out.println(myDoubleLinkedList.toString());

        myDoubleLinkedList.prepend(1);

        myDoubleLinkedList.printList();
        myDoubleLinkedList.insert(2, 99);
        myDoubleLinkedList.printList();
        myDoubleLinkedList.insert(-1, 15);
        myDoubleLinkedList.insert(100, 33);
        myDoubleLinkedList.printList();

        myDoubleLinkedList.remove(3);
        myDoubleLinkedList.printList();
        myDoubleLinkedList.remove(-1);
        myDoubleLinkedList.printList();
        myDoubleLinkedList.remove(99);
        myDoubleLinkedList.printList();
    }
}

class MyDoubleLinkedList {

    private NodeDoubleLinked head;

    private NodeDoubleLinked tail;

    private int length;

    public MyDoubleLinkedList(Object value) {
        NodeDoubleLinked node = new NodeDoubleLinked(value);
        this.head = node;
        this.tail = head;
        this.length = 1;
    }

    // 1 <---> 10
    public void append(Object value) {
        NodeDoubleLinked newNode = new NodeDoubleLinked(value);
        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);
        this.tail = newNode;
        this.length++;
    } //O(1) time complexity

    public void prepend(Object value) {
        NodeDoubleLinked node = new NodeDoubleLinked(value);
        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
        this.length++;
    } // O(1) time complexity

    public void insert(int index, Object value) {
        NodeDoubleLinked newNode = new NodeDoubleLinked(value);
        if (index <= 0) {
            prepend(value);
            return;
        }
        if (index >= length) {
            append(value);
            return;
        }

        NodeDoubleLinked leader = traverseToIndex(index - 1);
        NodeDoubleLinked holdingPointer = leader.getNext();
        leader.setNext(newNode);
        newNode.setNext(holdingPointer);
        newNode.setPrev(leader);
        holdingPointer.setPrev(newNode);
        this.length++;
    } // O(n) time complexity

    public void remove(int index) {

        if (index <= 0) {
            this.head = head.getNext();
            this.head.setPrev(null);
            this.length--;
            return;
        }
        if (index >= length) {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            this.length--;
            return;
        }

        NodeDoubleLinked leader = traverseToIndex(index - 1);
        NodeDoubleLinked unwantedNode = leader.getNext();
        NodeDoubleLinked follower = unwantedNode.getNext();
        leader.setNext(follower);
        follower.setPrev(leader);
        this.length--;
    } // O(n) time complexity

    /**
     * Assume give an linked list [0, 2, 8, 5, 16, 9] reverse:
     * should be [9, 16, 5, 8, 2, 0]
     */
    public void reverse() {



    }

    private NodeDoubleLinked traverseToIndex(int index) {
        NodeDoubleLinked currentNode = head;
        int counter = 0;
        while (counter++ != index) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public void printList() {

        NodeDoubleLinked currentNode = head;

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
        sb.append("]").append(" - length = ").append(this.length);
        System.out.println(sb.toString());
    }

    public NodeDoubleLinked getHead() {
        return head;
    }

    public void setHead(NodeDoubleLinked head) {
        this.head = head;
    }

    public NodeDoubleLinked getTail() {
        return tail;
    }

    public void setTail(NodeDoubleLinked tail) {
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
        return "MyDoubleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}

class NodeDoubleLinked {

    private Object value;

    private NodeDoubleLinked next;

    private NodeDoubleLinked prev;

    public NodeDoubleLinked() {
    }

    public NodeDoubleLinked(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public NodeDoubleLinked getNext() {
        return next;
    }

    public void setNext(NodeDoubleLinked next) {
        this.next = next;
    }

    public NodeDoubleLinked getPrev() {
        return prev;
    }

    public void setPrev(NodeDoubleLinked prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "NodeDoubleLinked{" +
                "value=" + value +
                '}';
    }
}