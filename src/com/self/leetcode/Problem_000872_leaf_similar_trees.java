package com.self.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_000872_leaf_similar_trees {

    public static void main(String[] args) {

        Problem_000872_leaf_similar_trees test = new Problem_000872_leaf_similar_trees();


        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);



        System.out.println(test.leafSimilar(root1,root2));
    }



//    Definition for a binary tree node.
    static class TreeNode {
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

    List<Integer> result1 = new ArrayList<>();
    List<Integer> result2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //默认不存在为null 空的情况

        leafSimilar_recursion(root1,result1);
        leafSimilar_recursion(root2,result2);

        if (result1.size() != result2.size()) return false;

        for (int i = 0; i < result1.size(); i++) {
            if (result1.get(i) != result2.get(i)) return false;
        }
        return true;
    }

    private void leafSimilar_recursion(TreeNode root, List<Integer> result) {
        if (root.left == null && null == root.right){
            result.add(root.val);
            return;
        }

        if (null != root.left){
            leafSimilar_recursion(root.left,result);
        }

        if (null != root.right){
            leafSimilar_recursion(root.right,result);
        }

    }
}
