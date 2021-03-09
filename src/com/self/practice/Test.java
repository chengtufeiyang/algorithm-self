package com.self.practice;

import com.self.practice.comm_tools.Constants;
import com.self.practice.comm_tools.Node;
import com.self.practice.comm_tools.Tree;
import com.wz.array.PrintArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
//        System.out.println(3^3);
//
//
//        int[] arr = {2,4,53,3};
//        PrintArray.printByJDK(arr);
//
//        //create node  print node
//        Node.printNode(Node.createOnlyNextNode(10,100));


//        Tree tree = Tree.createTree(4);
//        Tree.prePrint(tree);


        int [] arr = {2,4,2,7,9,1};
        PriorityQueue<Integer> self = new PriorityQueue<>(
//                (a,b) -> (b - a)
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }
        );
        for (int i = 0; i < arr.length; i++) {
            self.add(arr[i]);
        }
        while (!self.isEmpty()){
            System.out.print(self.poll() + Constants.SPACE);
        }

    }
}
