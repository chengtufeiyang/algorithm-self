package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Tree;

public class P12_binary_search_tree {


    public static void main(String[] args) {
        Tree tree = Tree.createTree(3);
        Tree.prePrint(tree);
        System.out.println(new P12_binary_search_tree().isSearch(tree));

        Tree tree1 = new Tree(4);
        tree1.left = new Tree(3);
        tree1.right = new Tree(6);
        tree1.left.left = new Tree(1);
        tree1.left.right = new Tree(2);

        Tree.prePrint(tree1);
        System.out.println(new P12_binary_search_tree().isSearch(tree1));
    }

    public boolean isSearch(Tree tree){
        if (null == tree) return true;
        return process(tree).flag;
    }

    private class Info{
        public boolean flag;  //当前二叉树是否为搜索二叉树
        public int max;//树种最大值
        public int min; //树的最小值

        public Info(boolean flag, int max, int min) {
            this.flag = flag;
            this.max = max;
            this.min = min;
        }
    }

    private Info process(Tree tree){
        if (null == tree){
            return  new Info(true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        int max = tree.value;
        int min = tree.value;
        Info leftInfo = process(tree.left);
        Info rightInfo = process(tree.right);
        max = Math.max(max,Math.max(leftInfo.max,rightInfo.max));
        min = Math.min(min,Math.min(leftInfo.min,rightInfo.min));
        boolean flag = leftInfo.max < tree.value && rightInfo.min > tree.value ? true:false;
        if (flag || !leftInfo.flag || !rightInfo.flag){
            flag = false;
        }
        return new Info(flag,max,min);
    }
}
