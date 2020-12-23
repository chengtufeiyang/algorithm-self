package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Constants;
import com.self.practice.comm_tools.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class P01_order_tree {

    private static RecusionOrder recusionOrder = new RecusionOrder();
    private static NoRecusionOrder noRecusionOrder = new NoRecusionOrder();


    public static void main(String[] args) {

        Tree tree = Tree.createTree(10);
        System.out.println("-------前序遍历-------");
        order(tree, true, 0);
        System.out.println();
        order(tree, false, 0);
        System.out.println();
        System.out.println("-------中序遍历-------");
        order(tree, true, 1);
        System.out.println();
        order(tree, false, 1);
        System.out.println();
        System.out.println("-------后序遍历-------");
        order(tree, true, 2);
        System.out.println();
        order(tree, false, 2);


    }

    /**
     * 排序
     *
     * @param tree 源数据
     * @param flag true---递归方式，false---非递归方式
     * @param type 0---前序遍历，1---中序遍历，2---后序遍历
     */
    public static void order(Tree tree, boolean flag, int type) {

        if (flag) {//判断是否为递归遍历方式
            if (type == 0) recusionOrder.preOrder(tree);
            if (type == 1) recusionOrder.midOrder(tree);
            if (type == 2) recusionOrder.postOrder(tree);
        } else {
            if (type == 0) noRecusionOrder.preOrder(tree);
            if (type == 1) noRecusionOrder.midOrder2(tree);
            if (type == 2) noRecusionOrder.postOrder2(tree);
        }
    }


    /**
     * 递归遍历方式
     */
    private static class RecusionOrder {
        /**
         * 前序遍历---递归
         * 中-左-右
         *
         * @param tree
         */
        public void preOrder(Tree tree) {
            if (null == tree) return;

            System.out.print(tree.value + Constants.SPACE);
            preOrder(tree.left);
            preOrder(tree.right);
        }

        /**
         * 中序遍历---递归
         * 左-中-右
         *
         * @param tree
         */
        public void midOrder(Tree tree) {
            if (null == tree) return;
            midOrder(tree.left);
            System.out.print(tree.value + Constants.SPACE);
            midOrder(tree.right);
        }

        /**
         * 后序遍历---递归
         * 左-右-中
         *
         * @param tree
         */
        public void postOrder(Tree tree) {
            if (null == tree) return;
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.value + Constants.SPACE);
        }

    }

    /**
     * 非递归遍历方式
     */
    private static class NoRecusionOrder {

        /**
         * 前序遍历---非递归
         * 中-左-右
         *
         * @param tree
         */
        public void preOrder(Tree tree) {
            if (null == tree) return;
            Deque<Tree> stack = new ArrayDeque<>();
            stack.addLast(tree);
            while (!stack.isEmpty()) {
                Tree temp = stack.pollLast();
                System.out.print(temp.value + Constants.SPACE);
                if (null != temp.right) {
                    stack.addLast(temp.right);
                }
                if (null != temp.left) {
                    stack.addLast(temp.left);
                }
            }
        }


        /**
         * 中序遍历---非递归
         * 左-中-右
         *
         * @param tree
         */
        public void midOrder(Tree tree) {
            if (null == tree) return;
            Deque<Tree> stack = new ArrayDeque<>();
            prepareMid(stack, tree);

            while (!stack.isEmpty()) {
                System.out.print(stack.pollLast().value + Constants.SPACE);
            }
        }


        public void prepareMid(Deque<Tree> stack, Tree tree) {
            if (null == tree) return;
            if (null != tree.right) {
                prepareMid(stack, tree.right);
            }
            stack.addLast(tree);
            if (null != tree.left) {
                prepareMid(stack, tree.left);
            }

        }


        /**
         * 中序遍历---非递归
         * 左-中-右
         *
         * @param tree
         */
        public void midOrder2(Tree tree) {
            if (null == tree) return;
            Deque<Tree> stack = new ArrayDeque<>();

            while (!stack.isEmpty() || null != tree) {
                if (tree != null) {
                    stack.addLast(tree);
                    tree = tree.left;
                } else {
                    Tree temp = stack.pollLast();
                    System.out.print(temp.value + Constants.SPACE);
                    tree = temp.right;
                }
            }
        }

        /**
         * 后序遍历---非递归
         * 左-右-中
         *
         * @param tree
         */
        public void postOrder(Tree tree) {
            if (null == tree) return;
            Deque<Tree> stack = new ArrayDeque<>();
            Deque<Tree> result = new ArrayDeque<>();
            stack.addLast(tree);
            while (!stack.isEmpty()) {
                Tree temp = stack.pollLast();
                result.addLast(temp);
                if (null != temp.left) {
                    stack.addLast(temp.left);
                }
                if (null != temp.right) {
                    stack.addLast(temp.right);
                }
            }

            while (!result.isEmpty()) {
                System.out.print(result.pollLast().value + Constants.SPACE);
            }
        }

        /**
         * 后序遍历---非递归
         * 左-右-中
         *
         * @param tree
         */
        public void postOrder2(Tree tree) {
            if (null == tree) return;
            Deque<Tree> stack = new ArrayDeque<>();
            stack.addLast(tree);
            while (!stack.isEmpty()) {
                Tree temp  = stack.peekLast();
                if ( null != temp.left && tree != temp.left && tree != temp.right ){
                    stack.addLast(temp.left);
                }else if(null != temp.right && tree != temp.right ){
                    stack.addLast(temp.right);
                }else {
                    System.out.print(stack.pollLast().value + Constants.SPACE);
                    tree = temp;
                }
            }

        }

    }


}
