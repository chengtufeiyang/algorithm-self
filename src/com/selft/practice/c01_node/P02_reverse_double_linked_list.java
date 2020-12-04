package com.selft.practice.c01_node;

import com.selft.practice.comm_tools.DoubleNode;
import com.selft.practice.comm_tools.Node;

public class P02_reverse_double_linked_list {

    public static void main(String[] args) {

        DoubleNode node = new DoubleNode(1);
        node.next = new DoubleNode(2);
        node.next.next  = new DoubleNode(3);
        node.next.pre = node;
        node.next.next.pre = node.next;
        node = new P02_reverse_double_linked_list().reverse(node);
        System.out.println(node);

    }


    /**
     * 双向链表翻转
     * @param node
     * @return
     */
    public DoubleNode reverse(DoubleNode node){
        if (node == null || (null == node.next && null== node.pre )) return node;

        DoubleNode result = null;

        while (null != node ){
            DoubleNode next = node.next;

            node.next = result;
            if (null != result){
                result.pre = node;
            }
            result = node;
            node = next;
        }
        result.pre = null;
        return result;
    }


}
