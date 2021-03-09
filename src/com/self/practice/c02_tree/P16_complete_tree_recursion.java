package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Tree;

public class P16_complete_tree_recursion {


    public static void main(String[] args) {

    }

//    判断二叉树是否是完全二叉树---递归套路
// 1、有右无左

    public static boolean normal(Tree head){
        if (null == head) return true;
        return normalRecursion(head).isFull;
    }

    private static TreeInfo normalRecursion(Tree head) {
        if (null == head){
            return new TreeInfo(true,true,0);
        }

        TreeInfo leftInfo = normalRecursion(head.left);
        TreeInfo rightInfo = normalRecursion(head.right);
        int h = Math.max(leftInfo.h,rightInfo.h);
        boolean isFull = false;
        boolean isComp = false;

        if (leftInfo.isFull && leftInfo.isFull){

            isFull = true;
            isComp = true;
        }

        if (leftInfo.isFull && rightInfo.isFull && leftInfo.h == rightInfo.h +1){
            isFull = true;
            isComp = true;
        }

        if (leftInfo.isComp && rightInfo.isFull && leftInfo.h == rightInfo.h +1){
            isComp = true;
        }

        if (leftInfo.isFull && rightInfo.isComp && leftInfo.h == rightInfo.h){
            isComp = true;
        }
        return new TreeInfo(isFull,isComp,h);
    }


    private static class TreeInfo{
        private boolean isFull;
        private boolean isComp;
        private int h;

        public TreeInfo(boolean isFull, boolean isComp, int h) {
            this.isFull = isFull;
            this.isComp = isComp;
            this.h = h;
        }
    }


}
