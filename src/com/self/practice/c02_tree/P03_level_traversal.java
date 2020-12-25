package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Constants;
import com.self.practice.comm_tools.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class P03_level_traversal {

    public static void main(String[] args) {
        Tree head = new Tree(1);
        head.left = new Tree(2);
        head.right = new Tree(3);
        head.left.left = new Tree(4);
        head.left.right = new Tree(5);
        head.right.left = new Tree(6);
        head.right.right = new Tree(7);

        leveTraversalByStack(head);
        System.out.println();
        leveTraversalByRecursion(head);
        System.out.println();
        Tree tree = Tree.createTree(50);
        leveTraversalByStack(tree);
        System.out.println(        );
        leveTraversalByRecursion(tree);
    }


    /**
     * 层序遍历二叉树---利用栈实现
     * @param tree
     */
    public static void leveTraversalByStack(Tree tree){
        if (null == tree) return;

        Deque<Tree> stack = new ArrayDeque<>();
        stack.addLast(tree);
        while (!stack.isEmpty()){
            Tree temp = stack.pollFirst();
            System.out.print(temp.value+ Constants.SPACE);
            if (null != temp.left){
                stack.addLast(temp.left);
            }
            if (null != temp.right){
                stack.addLast(temp.right);
            }
        }
    }



    /**
     * 层序遍历二叉树---递归实现
     * @param tree
     */
    public static void leveTraversalByRecursion(Tree tree){
        if (null == tree) return;

        Deque<Tree> stack = new ArrayDeque<>();
        stack.addLast(tree);
        leveTraversalByRecursionBy(stack);
    }

    private static void leveTraversalByRecursionBy(Deque<Tree> stack) {
        if (stack.isEmpty())return;

        Tree temp = stack.pollFirst();
        System.out.print(temp.value+ Constants.SPACE);
        if (null != temp.left){
            stack.addLast(temp.left);
        }
        if (null != temp.right){
            stack.addLast(temp.right);
        }
        leveTraversalByRecursionBy(stack);

    }


}
