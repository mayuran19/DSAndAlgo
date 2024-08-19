package com.mayuran19.linkedlist;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 13/8/24
 * @license iLex
 */
public class ReverseLinkList {
    public static void main(String[] args) {
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        reverseLinkList.insertFirst(1);
        reverseLinkList.insertFirst(2);
        reverseLinkList.insertFirst(3);
        reverseLinkList.insertFirst(4);
        reverseLinkList.insertFirst(5);

        reverseLinkList.print();
        reverseLinkList.reverse();
        System.out.println();
        reverseLinkList.print();
    }

    private Node head;
    private Node tail;
    private int size;

    private static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void insertFirst(int data){
        if(head == null){
            // this is the first node
            var node = new Node(data);
            head = node;
            tail = node;
        }else{
            var node = new Node(data);
            node.next = head;
            head = node;
        }
        size++;
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr == null){
                head = prev;
            }
        }
    }

    public void print(){
        var curr = head;
        while (curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
