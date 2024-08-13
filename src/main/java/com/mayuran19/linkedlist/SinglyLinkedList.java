package com.mayuran19.linkedlist;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 10/8/24
 * @license iLex
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        singlyLinkedList.addFirst(node1);
        singlyLinkedList.addFirst(node2);
        singlyLinkedList.addFirst(node3);
        singlyLinkedList.addFirst(node4);
        singlyLinkedList.addFirst(node5);

        var removed1 = singlyLinkedList.removeFirst();
        var removed2 = singlyLinkedList.removeFirst();
        var removed3 = singlyLinkedList.removeFirst();
        var removed4 = singlyLinkedList.removeFirst();
        var removed5 = singlyLinkedList.removeFirst();

        System.out.println(removed1.data);
        System.out.println(removed2.data);
        System.out.println(removed3.data);
        System.out.println(removed4.data);
        System.out.println(removed5.data);

        singlyLinkedList.addLast(node1);
        singlyLinkedList.addLast(node2);

        var removed11 = singlyLinkedList.removeFirst();
        var removed12 = singlyLinkedList.removeFirst();

        System.out.println(removed11.data);
        System.out.println(removed12.data);
    }
    private Node head;
    private Node tail;
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node first(){
        return head;
    }

    public Node last(){
        return tail;
    }

    public void addFirst(Node node){
        if(size == 0){
            // first node
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(Node node){
        if(size == 0){
            addFirst(node);
        }else{
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Node removeFirst(){
        if(size == 0){
            return null;
        }
        var firstNode = head;
        head = head.next;
        size--;
        return firstNode;
    }

    private static class Node{
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public SinglyLinkedList(){

    }


}
