package com.self.allpractice;

import com.self.practice.comm_tools.Tree;

import java.awt.*;

public class Problem005_binaryTree_longPath {

    public static void main(String[] args) {
//        Tree head = new Tree(2);
//        head.left = new Tree(-3);
//        head.right = new Tree(4);
//        head.left.left = new Tree(10);
//        head.right.right = new Tree(9);

//        Tree head = new Tree(2);
//        head.left = new Tree(8);
//        head.right = new Tree(-4);
//        head.left.left = new Tree(-2);
//        head.left.right = new Tree(-7);
//        head.right.right = new Tree(9);

        Tree head = new Tree(-3);
        head.left = new Tree(2);
        head.right = new Tree(-1);
        head.left.left = new Tree(-8);
        head.left.right = new Tree(9);
        head.right.right = new Tree(19);

        System.out.println(headToAnyDown(head));
        System.out.println(headToLeaf(head));
        System.out.println(anyToDown(head));
    }

    /**
     * 输出从头节点向下方向最大路径和（节点值为负数情况下不一定会到叶子节点）
     * @param head
     * @return
     */
    public static int headToAnyDown(Tree head){
        if (null == head) return 0;
        int max = head.value;
        int left = max + headToAnyDown(head.left);
        int right = max + headToAnyDown(head.right);
        return Math.max(max,Math.max(left,right));
    }

    /**
     * 输出从头节点向下方向最大路径和（节点值为负数情况下不一定会到叶子节点）
     * @param head
     * @return
     */
    public static int headToLeaf(Tree head){
        if (null == head) return 0;
        return head.value +Math.max( headToLeaf(head.left),
                headToLeaf(head.right));
    }


    private static class AnyToDownClass{
        private int allMax;// 包含当前节点的最大值
        private int max; // 不包含当前节点的最大值

        public AnyToDownClass(int allMax, int max) {
            this.allMax = allMax;
            this.max = max;
        }
    }

    /**
     * 从任意位置向下(任意)获取最大值
     * @param head
     * @return
     */
    public static int anyToDown(Tree head){
        if (null == head) return 0;
        AnyToDownClass result = anyToDown_recursion(head);
        return Math.max(result.allMax, result.max);
    }

    private static AnyToDownClass anyToDown_recursion(Tree head) {
        if (null == head) return null;
        if (null == head.left && null == head.right ) return new AnyToDownClass(head.value,head.value);

        AnyToDownClass left = anyToDown_recursion(head.left);
        AnyToDownClass right = anyToDown_recursion(head.right);
        int curr = head.value;
        int max = Integer.MIN_VALUE; // 最大值，不一定包含当前节点
        int allMax = Integer.MIN_VALUE; // 包含当前节点
        if (left != null){
            allMax = Math.max(allMax,curr + left.allMax);
            max = Math.max(max,left.max);
        }

        if (right != null){
            allMax = Math.max(allMax,curr + right.allMax);
            max = Math.max(max,right.max);
        }

        max = Math.max(max,allMax);
        return new AnyToDownClass(allMax,max);
    }







}
