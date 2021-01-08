package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Tree;
import edu.princeton.cs.algs4.In;

public class P13_max_dis {

    public static void main(String[] args) {

        Tree tree = Tree.createTree(0);
        Tree.prePrint(tree);
        System.out.println();
        System.out.println(new P13_max_dis().maxDis(tree));

    }

//    给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离

    //含有当前核心点  不包含当前核心节点

    public int maxDis(Tree tree){
        if (null == tree)return 0;
        return process(tree).maxDis;
    }


    private class Info{
        public int maxDis;//最大距离
        public int h ; //最大高度

        public Info(int maxDis, int h) {
            this.maxDis = maxDis;
            this.h = h;
        }
    }


    public Info process(Tree tree){
        if (null == tree){
            return new Info(0,0);
        }

        Info leftInfo = process(tree.left);
        Info rightInfo = process(tree.right);

        int h = Math.max(leftInfo.h,rightInfo.h) +1; //当前节点造就子树的高度
        int maxDis = Math.max(leftInfo.h+rightInfo.h +1,Math.max(leftInfo.maxDis,rightInfo.maxDis));
        return new Info(maxDis,h);
    }

}
