package com.self.leetcode;

public class Problem_000993_cousins_in_binary_tree {

    public static void main(String[] args) {

    }

//    The number of nodes in the tree will be between 2 and 100.
//    Each node has a unique integer value from 1 to 100.
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    TreeNode root_x;
    TreeNode root_y ;
    int len_x ;
    int len_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (null == root) return false;

        isCousins_cursion(null,root,x,y,0);

        return (len_x == len_y && root_x != root_y) ? true : false;
    }

    private void isCousins_cursion(TreeNode parent,TreeNode root, int x, int y, int currLayer) {
        if (null == root) return;
        if (root.val == x){
            root_x = parent;
            len_x = currLayer;
        }
        if (root.val == y){
            root_y = parent;
            len_y = currLayer;
        }
        isCousins_cursion(root,root.left,x,y,currLayer + 1);
        isCousins_cursion(root,root.right,x,y,currLayer + 1);

    }
}
