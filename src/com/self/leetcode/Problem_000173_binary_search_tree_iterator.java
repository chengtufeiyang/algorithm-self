package com.self.leetcode;

import edu.princeton.cs.algs4.In;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem_000173_binary_search_tree_iterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7,
                new TreeNode(3),
                new TreeNode(15,
                        new TreeNode(9),
                        new TreeNode(20)));

        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }


    //    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    static class BSTIterator2 {


        TreeNode curr;
        Deque<TreeNode> stack ;

        public BSTIterator2(TreeNode root) {

            stack = new ArrayDeque<>();
            curr = root;
        }

        public int next() {
            if (!hasNext()) return Integer.MIN_VALUE; // 无意义，返回整型最小值

            while (curr != null){
                stack.addLast(curr);
                curr = curr.left;
            }

            curr = stack.pollLast();
            int temp = curr.val;
            curr = curr.right;

            return temp;
        }

        public boolean hasNext() {
            return null != curr || !stack.isEmpty();
        }
    }


    static class BSTIterator {

        List<Integer> result;
        int num;
        int index = 0;

        public BSTIterator(TreeNode root) {
            result = new ArrayList<>();

            initTreeNode(root, result);
            num = result.size();
        }

        private void initTreeNode(TreeNode root, List<Integer> result) {
            if (root == null) return;

            initTreeNode(root.left, result);

            result.add(root.val);

            initTreeNode(root.right, result);

        }

        public int next() {
            if (!hasNext()) return Integer.MIN_VALUE; // 无意义，返回整型最小值
            num--;
            return result.get(index++);
        }

        public boolean hasNext() {
            return num > 0 ? true : false;
        }
    }




}
