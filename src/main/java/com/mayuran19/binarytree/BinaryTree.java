package com.mayuran19.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Builds a binary tree from a LeetCode/NeetCode level-order array.
     * Nulls represent absent nodes, e.g. [1,2,3,null,null,4,5].
     */
    public static TreeNode buildTree(Integer[] vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) return null;

        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();

            if (i < vals.length && vals[i] != null) {
                node.left = new TreeNode(vals[i]);
                queue.offer(node.left);
            }
            i++;

            if (i < vals.length && vals[i] != null) {
                node.right = new TreeNode(vals[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    /** Serialises the tree back to LeetCode level-order format for verification. */
    public static List<Integer> serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Trim trailing nulls
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    /** Prints the tree sideways (right subtree on top) for quick debugging. */
    public static void print(TreeNode root) {
        printHelper(root, "", 0);
    }

    private static void printHelper(TreeNode node, String prefix, int depth) {
        if (node == null) return;
        printHelper(node.right, prefix + "    ", depth + 1);
        System.out.println(prefix + node.val);
        printHelper(node.left, prefix + "    ", depth + 1);
    }

    // Quick smoke test
    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildTree(input);

        System.out.println("Tree (sideways, right branch on top):");
        print(root);

        System.out.println("\nSerialized back: " + serialize(root));
    }
}