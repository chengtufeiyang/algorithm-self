package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Tree;
import edu.princeton.cs.algs4.In;

public class P15_search_max_sub_tree {

    public static void main(String[] args) {

//        Tree tree = Tree.createTree(4);
//        Tree.prePrint(tree);
//        System.out.println();
//        Tree.prePrint(new P15_search_max_sub_tree().maxSubTree(tree));
//
//        System.out.println();
        Tree tree1 = new Tree(3);
        tree1.left = new Tree(1);
        tree1.right = new Tree(4);
        tree1.left.right = new Tree(2);
        Tree.prePrint(tree1);
        System.out.println();
        Tree.prePrint(new P15_search_max_sub_tree().maxSubTree(tree1));
    }


//    返回一个棵树符合搜索二叉树条件的最大子树（子树可能是其本身，也肯能不是）
        public Tree maxSubTree(Tree tree){
            if (null == tree) return null;
            return process(tree).sub;
        }

        private class Info{
            public Tree sub ;//最大子树
            public int max ;//当前树最大值
            public int min ;//当前树最小值
            public int num ;//当前树节点数量
            public int subNum;//最大子树的节点数量

            //若当前树节点数量与最大子树节点数量相等，则当前树即为搜索二叉树
            public Info(Tree sub, int max, int min, int num, int subNum) {
                this.sub = sub;
                this.max = max;
                this.min = min;
                this.num = num;
                this.subNum = subNum;
            }
        }

        private Info process(Tree tree){
            if (null == tree)return null;

            Info leftInfo = process(tree.left);
            Info rightInfo = process(tree.right);


            int max = tree.value;//当前树最大值
            int min = tree.value;;//当前树最小值
            int num =1;//当前树节点数量
            Tree sub = null;//最大子树
            int subNum = 0; // 最大子树的节点数量
            if (null != leftInfo){
                max = Math.max(max,leftInfo.max);
                min = Math.min(min,leftInfo.min);
                num += leftInfo.num;
            }

            if (null != rightInfo){
                max = Math.max(max,rightInfo.max);
                min = Math.min(min,rightInfo.min);
                num += rightInfo.num;
            }

            if (null != leftInfo && null == rightInfo){
                if ((leftInfo.subNum==leftInfo.num) && leftInfo.max < tree.value){
                    sub = tree;
                    subNum = num;
                }else {
                    sub = leftInfo.sub;
                    subNum = leftInfo.subNum;
                }
            }

            if (null == leftInfo && null != rightInfo){
                if ((rightInfo.subNum==rightInfo.num) && rightInfo.min > tree.value){
                    sub = tree;
                    subNum = num;
                }else {
                    sub = rightInfo.sub;
                    subNum = rightInfo.subNum;
                }
            }

            if (null != leftInfo && null != rightInfo){
                if (leftInfo.subNum==leftInfo.num && rightInfo.subNum == rightInfo.num
                        && leftInfo.max < tree.value && rightInfo.min > tree.value){
                    sub = tree;
                    subNum = num;
                }else {
                    sub = leftInfo.subNum > rightInfo.subNum ? leftInfo.sub : rightInfo.sub;
                    subNum = leftInfo.subNum > rightInfo.subNum ? leftInfo.subNum : rightInfo.subNum;
                }
            }

            if (null == leftInfo && null == rightInfo){
                sub = tree;
                subNum = num;
            }
            return new Info(sub,max,min,num,subNum);
        }

}
