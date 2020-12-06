package com.self.practice;

import com.self.practice.comm_tools.Node;
import com.wz.array.PrintArray;

public class Test {
    public static void main(String[] args) {
        System.out.println(3^3);


        int[] arr = {2,4,53,3};
        PrintArray.printByJDK(arr);

        //create node  print node
        Node.printNode(Node.createOnlyNextNode(10,100));


    }
}
