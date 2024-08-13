package com.mayuran19.tree;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 11/8/24
 * @license iLex
 */
public class BinaryLinkedTree {
    public static void main(String[] args) {
        BinaryLinkedTree binaryLinkedTree = new BinaryLinkedTree();
        binaryLinkedTree.insert(5);
        binaryLinkedTree.insert(4);
        binaryLinkedTree.insert(6);
        binaryLinkedTree.insert(7);
        binaryLinkedTree.insert(1);

        System.out.println(binaryLinkedTree);
    }

    private static class Node{
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
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

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node(int data){
            this.data = data;
        }
    }

    private Node root = null;
    private int size = 0;

    public void insert(int data){
        if(root == null){
            var node = insert(data, null);
            root = node;
        }else{
            insert(data, root);
        }
    }

    public Node insert(int data, Node root){
        if(root == null){
            return new Node(data);
        }else if(data < root.getData()){
            var node = insert(data, root.getLeft());
            root.setLeft(node);
        }else{
            var node =insert(data, root.getRight());
            root.setRight(node);
        }

        return root;
    }
}
