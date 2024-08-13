package com.mayuran19.linkedlist;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 11/8/24
 * @license iLex
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private static class Node{
        private Node prev;
        private Node next;
        private int data;

        public Node(int data){
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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

    public DoublyLinkedList(){
        // create the sentinel nodes
        var head = new Node(0);
        var tail = new Node(0);
        head.next = tail;
        head.prev = null;

        tail.prev = head;
        tail.next = null;
    }

    public void addFirst(Node node){
        node.next = head.next;
        node.prev = head;
        size++;
    }

    public void addLast(Node node){
        node.prev = tail.prev;
        node.next = tail;
        size++;
    }

    public void removeFirst(Node node){
        if(size > 0){
            var predecessor = node.prev;
            var successor = node.next;
            predecessor.next = successor;
            successor.prev = predecessor;
        }
    }
}
