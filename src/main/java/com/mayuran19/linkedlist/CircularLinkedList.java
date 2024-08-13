package com.mayuran19.linkedlist;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 10/8/24
 * @license iLex
 */
public class CircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        circularLinkedList.addFirst(node1);
        circularLinkedList.addFirst(node2);
        circularLinkedList.addFirst(node3);
        circularLinkedList.addFirst(node4);
        circularLinkedList.addFirst(node5);



        var size = circularLinkedList.size;
        var head = circularLinkedList.tail.next;
        while (size > 0){
            System.out.println(head.data);
            head = head.next;
            size--;
        }

        circularLinkedList.rotate();

        System.out.println();

        size = circularLinkedList.size;
        head = circularLinkedList.tail.next;
        while (size > 0){
            System.out.println(head.data);
            head = head.next;
            size--;
        }

        circularLinkedList.removeFirst();
        circularLinkedList.removeFirst();
        circularLinkedList.removeFirst();
        circularLinkedList.removeFirst();
        circularLinkedList.removeFirst();

        System.out.println(circularLinkedList.tail);
    }
    private static class Node{
        public Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node tail;

    public void addFirst(Node node){
        if(size == 0){
            tail = node;
        }else{
            node.next = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void addLast(Node node){
        if(size == 0){
            addFirst(node);
        }else{
            node.next = tail.next; // node next is head
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void removeFirst(){
        if(size == 0){
            return;
        }else{
            tail.next = tail.next.next;
            if(size == 1){
                tail = null;
            }
        }
        size--;
    }

    public void rotate(){
        tail = tail.next;
    }
}
