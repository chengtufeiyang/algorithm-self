package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class P05_max_level_node_num {
    public static void main(String[] args) {

        Tree tree = Tree.createTree(3);
        System.out.println(nodeNumByContainer(tree));

    }


    /**
     * 容器法
     * @param tree
     * @return
     */
    public static int nodeNumByContainer(Tree tree){
        int result = 0;//最终得出最大数量
        if (null == tree) return result;
        Deque<Tree> stack = new ArrayDeque<>();//存储节点的容器
        stack.addLast(tree);
        int curr = 0;
        Tree last = tree ;//记录下一轮循环最后一个节点
        while (!stack.isEmpty()){
            Tree temp = stack.pollFirst();
            if (temp.right != null){
                stack.addLast(temp.right);
            }
            if (temp.left != null){
                stack.addLast(temp.left);
            }


            if (temp != last){
                curr++;
            }else {
                last = stack.peekLast();//设置比较分隔节点
                if ((curr+1) > result){
                    result = curr+1;
                }
                curr = 0;
            }
        }
        return result;
    }
}
