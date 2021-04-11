package com.self.allpractice;

import com.self.practice.comm_tools.Tree;
import edu.princeton.cs.algs4.In;

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
        head.right.right.left = new Tree(-1);

        System.out.println(headToAnyDown(head));
        System.out.println(headToLeaf(head));
        System.out.println(anyToDown(head));
        System.out.println(anyToDownLeaf(head));
        System.out.println(anyToAny(head));

    }

    /**
     * 输出从头节点向下方向最大路径和（节点值为负数情况下不一定会到叶子节点）
     *
     * @param head
     * @return
     */
    public static int headToAnyDown(Tree head) {
        if (null == head) return 0;
        int max = head.value;
        int left = max + headToAnyDown(head.left);
        int right = max + headToAnyDown(head.right);
        return Math.max(max, Math.max(left, right));
    }

    /**
     * 输出从头节点向下方向最大路径和（节点值为负数情况下一定会到叶子节点）
     *
     * @param head
     * @return
     */
    public static int headToLeaf(Tree head) {
        if (null == head) return 0;
        return head.value + Math.max(headToLeaf(head.left),
                headToLeaf(head.right));
    }


    private static class AnyToDownClass {
        private int allMax;// 包含当前节点的最大值
        private int max; // 不包含当前节点的最大值

        public AnyToDownClass(int allMax, int max) {
            this.allMax = allMax;
            this.max = max;
        }
    }

    /**
     * 从任意位置向下(任意)获取最大值
     *
     * @param head
     * @return
     */
    public static int anyToDown(Tree head) {
        if (null == head) return 0;
        AnyToDownClass result = anyToDown_recursion(head);
        return result.max;
    }

    private static AnyToDownClass anyToDown_recursion(Tree head) {
        if (null == head) return null;
        if (null == head.left && null == head.right) return new AnyToDownClass(head.value, head.value);

        AnyToDownClass left = anyToDown_recursion(head.left);
        AnyToDownClass right = anyToDown_recursion(head.right);
        int curr = head.value;
        int max = Integer.MIN_VALUE; // 最大值，不一定包含当前节点
        int allMax = curr; // 包含当前节点
        if (left != null) {
            allMax = Math.max(allMax, curr + left.allMax);
            max = Math.max(max, left.max);
        }

        if (right != null) {
            allMax = Math.max(allMax, curr + right.allMax);
            max = Math.max(max, right.max);
        }

        max = Math.max(max, allMax);
        return new AnyToDownClass(allMax, max);
    }


    /**
     * 获取任意节点到叶子节点的最大路径和
     *
     * @param head
     * @return
     */
    static int max_anyToDownLeaf = Integer.MIN_VALUE;

    public static int anyToDownLeaf(Tree head) {
        if (null == head) return 0;
        anyToDownLeaf_recursion(head);
        return max_anyToDownLeaf;
    }


    public static int anyToDownLeaf_recursion(Tree head) {
        if (null == head) return Integer.MIN_VALUE;
        if (null == head.left && null == head.right) return head.value;

        int left = anyToDownLeaf_recursion(head.left);
        if (left != Integer.MIN_VALUE) {
            left += head.value;
        }
        int right = anyToDownLeaf_recursion(head.right);
        if (right != Integer.MIN_VALUE) {
            right += head.value;
        }
        max_anyToDownLeaf = Math.max(max_anyToDownLeaf, Math.max(left, right));
        return Math.max(left, right);
    }


    private static class AnyToAnyClass {
        private int allMax;// 包含当前节点的最大值
        private int max; // 不包含当前节点的最大值

        public AnyToAnyClass(int allMax, int max) {
            this.allMax = allMax;
            this.max = max;
        }
    }

    public static int anyToAny(Tree head) {
        if (null == head) return 0;
        AnyToAnyClass any = anyToAny_recursion(head);
        return Math.max(any.allMax, any.max);
    }

    public static AnyToAnyClass anyToAny_recursion(Tree head) {
        if (null == head ) return null;
        if (null == head.left && null == head.right) return new AnyToAnyClass(head.value,head.value);

        int curr = head.value;
        AnyToAnyClass leftTree = anyToAny_recursion(head.left);
        AnyToAnyClass rightTree = anyToAny_recursion(head.right);

        int allMax = curr; // 包含当前节点
        int max = Integer.MIN_VALUE; // 不包含当前节点

        if (null != leftTree){
            allMax = Math.max(allMax,curr + leftTree.allMax);
            max = Math.max(max,leftTree.max);
        }

        if (null != rightTree){
            allMax = Math.max(allMax,curr + rightTree.allMax);
            max = Math.max(max,rightTree.max);
        }

        if (null != leftTree && null != rightTree){
            allMax = Math.max(allMax,curr + leftTree.allMax + rightTree.allMax);
        }

        return new AnyToAnyClass(allMax,max);
    }


}
