package com.mayuran19.linkedlist;

public class LinkedList {
    private Node head;

    public void insert(int data){
        Node node = new Node();
        node.setData(data);
        if(head == null){
            //empty list
            this.head = node;
        }else{
            //go to last and insert
            Node tmp = head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            //Reached the last node
            tmp.setNext(node);
        }
    }

    public void print(){
        if(head != null){
            Node node = head;
            do{
                System.out.println(node.getData());
                node = node.getNext();
            }while (node != null);
        }
    }
}
