package com.self.practice.c02_tree;


import com.self.practice.comm_tools.Tree;
import com.self.practice.comm_tools.enums.OrderTreeEnum;

/**
 * 二叉树的序列化和反序列化（先序、后序、按层方式均可，，中序方式存在歧义，无序列化）
 */
public class P04_serialize_tree {


    public static void main(String[] args) {
        Tree tree = Tree.createTree(5);
        P01_order_tree.order(tree,true, OrderTreeEnum.PRE.getValue());
        System.out.println();
        P01_order_tree.order(tree,true,OrderTreeEnum.MID.getValue());
        System.out.println();
        P01_order_tree.order(tree,true,OrderTreeEnum.POST.getValue());


    }

}
