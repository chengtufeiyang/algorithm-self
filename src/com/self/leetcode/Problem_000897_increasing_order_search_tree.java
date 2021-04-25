package com.self.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Problem_000897_increasing_order_search_tree {

    public static void main(String[] args) {

        Problem_000897_increasing_order_search_tree test = new Problem_000897_increasing_order_search_tree();
        TreeNode root = new TreeNode(5,new TreeNode(1),new TreeNode(7));
//        TreeNode result = test.increasingBST(root);
//        System.out.println(result.toString());

        TreeNode result = test.increasingBST2(root);
        System.out.println(result.toString());

    }

//    树中节点数的取值范围是 [1, 100]
//            0 <= Node.val <= 1000

//    https://leetcode-cn.com/problems/increasing-order-search-tree/


//   Definition for a binary tree node.
   public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

    public TreeNode increasingBST(TreeNode root) {
        if (null == root) return root;
        List<TreeNode> result = new ArrayList<TreeNode>();
        increasingBST_recursion(root,result);
        TreeNode temp = new TreeNode(1);
        TreeNode hehe = temp;
        for (int i = 0; i < result.size(); i++) {
            result.get(i).left = null;
            hehe.right =    result.get(i);
            hehe = hehe.right;
        }
        return temp.right;
    }

    private void increasingBST_recursion(TreeNode root, List<TreeNode> result) {
        if (root == null){
            return;
        }

        increasingBST_recursion(root.left,result);
        result.add(root);
        increasingBST_recursion(root.right,result);
    }



    public TreeNode increasingBST2(TreeNode root) {
        if (null == root) return root;

        return increasingBST2_recursion(root)[0];
    }


    private TreeNode[] increasingBST2_recursion(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode[] left = increasingBST2_recursion(root.left);
        TreeNode[] right = increasingBST2_recursion(root.right);

        TreeNode start = null;
        TreeNode end = null;
        if (left != null){
            root.left = null;
            left[1].right = root;
            start = left[0];
        }else {
            start = root;
        }

        if (right != null) {
            root.left = null;
            root.right = right[0];
            end = right[1];
        }else {
            end = root;
        }
        return new TreeNode[]{start,end};
    }



}
