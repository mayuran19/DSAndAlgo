package com.mayuran19.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBT {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }

        // first element of preorder is root
        TreeNode root = new TreeNode(preorder[0]);
        return null;
    }

    public List<List<TreeNode>> levelOrder(TreeNode root){
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);

            while (!queue.isEmpty()){
                int levelSize = queue.size();
                List<TreeNode> levelNodes = new ArrayList<>();
                for(int i = 0; i < levelSize; i++){
                    var node = queue.poll();
                    levelNodes.add(node);

                    if(node.left != null){
                        queue.offer(node.left);
                    }

                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }

                result.add(levelNodes);
            }
        }

        return result;
    }
}
