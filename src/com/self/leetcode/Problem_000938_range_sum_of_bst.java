package com.self.leetcode;

public class Problem_000938_range_sum_of_bst {


//    https://leetcode-cn.com/problems/range-sum-of-bst/


//    Definition for a binary tree node.
    public class TreeNode {
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



    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int left = rangeSumBST(root.left,low,high);
        int right = rangeSumBST(root.right,low,high);
        return left + right + (root.val >= low && root.val <= high ? root.val : 0);
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        return rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high) + (root.val >= low && root.val <= high ? root.val : 0);
    }
}
