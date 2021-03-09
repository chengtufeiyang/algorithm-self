package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class P10_complete_binary_tree {


    public static void main(String[] args) {

    }

    // 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
    // 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树
    // 是否完全二叉树（1、有右无左，否；2、当第一次遇到左右孩子不双全的时候，剩下遍历的节点不是叶子节点，否）

    public boolean isComplete(Tree head){
        if (null == head) return true;
        Deque<Tree> stack = new ArrayDeque<>();
        boolean leaf = false ;//是否都存在左右节点不全情况
        Tree left = null;
        Tree right = null;
        Tree curr = null;
        stack.addLast(head);
        while (!stack.isEmpty()){ // 队列不为空
            curr = stack.pollFirst();
            left = curr.left;
            right = curr.right;
            if ( (leaf && (null != left || null != right))
                    ||
                (null == left && null != right)
            ) {
                return false;
            }

            if (null != left){
                stack.addLast(left);
            }
            if (null != right){
                stack.addLast(right);
            }
            if (null == left || null == right ){
                leaf = true;
            }
        }
        return true;
    }


}
