package com.self.practice.comm_tools;

import java.util.ArrayDeque;
import java.util.Deque;

public class Tree {

    public int value;

    /**
     * 左子树
     */
    public Tree left;
    /**
     * 右子树
     */
    public Tree right;


    public Tree(int value) {
        this.value = value;
    }

    /**
     * 根据总数量生成对应二叉树
     * @param capacity
     * @return
     */
    public static Tree createTree(int capacity){
        if (capacity<1) return null;

        Deque<Integer> stack = new ArrayDeque<>();
        int temp_capacity = capacity;
        while (temp_capacity>=0){  //初始化栈
            stack.addLast(temp_capacity--);
        }

        //生成二叉树
        Tree tree = new Tree(stack.pollLast());
        Deque<Tree> temp = new ArrayDeque<>();
        temp.addLast(tree);
        while (!stack.isEmpty()){
            Tree tm = temp.pollLast();
            tm.left = new Tree(stack.pollLast());
            temp.addFirst(tm.left);
            if (!stack.isEmpty()){
                tm.right = new Tree(stack.pollLast());
                temp.addFirst(tm.right);
            }
        }
        return tree;
    }


    /**
     * 递归中序遍历打印
     */
    public static void prePrint(Tree tree){
        if (null == tree ) {
            return;
        }
        prePrint(tree.left);
        System.out.print(tree.value+Constants.RIGHT_ARROW);
        prePrint(tree.right);
    }


}
