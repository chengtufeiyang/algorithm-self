package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Tree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.omg.CORBA.TRANSACTION_MODE;

public class P14_full_binary_tree {


    public static void main(String[] args) {
        Tree tree = Tree.createTree(5);
        Tree.prePrint(tree);
        System.out.println();
        System.out.println(new P14_full_binary_tree().isFullTree(tree));
    }

//全部节点数量 2（k次方） -1  满足这个条件即为满二叉树

    public boolean isFullTree(Tree tree){
        if (null == tree) return true;
        Info info = process(tree);
        return info.num == Math.pow(2,info.h)-1 ? true : false;
    }

    /**
     * 分析结构体，核心部分
     */
    private class Info{
        public int h;//树高度
        public int num;//统计数的节点数

        public Info(int h, int num) {
            this.h = h;
            this.num = num;
        }
    }

    /**
     * 根据结构体设计具体统计过程
     * @param tree
     * @return
     */
    public Info process(Tree tree){
        if (null == tree){
            return new Info(0,0);
        }
        int h = Math.max(process(tree.left).h,process(tree.right).h) +1;
        int num = process(tree.left).num+process(tree.right).num +1;
        return new Info(h,num);
    }

}
