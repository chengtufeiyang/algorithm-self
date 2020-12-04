package com.selft.practice.c01_node;

import com.selft.practice.comm_tools.Node;

public class P01_reverse_single_linked_list {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node =new P01_reverse_single_linked_list().reverse(node);
        System.out.println(node);
    }

    /**
     * 单链表翻转：
     * 设定结果链表result,
     * 每次从源链表中拿取一个节点，与结果链表进行拼接，
     * 直至源链表数据取完
     * @param node
     * @return
     */
    public Node reverse(Node node){
        if (null == node || null == node.next ) return node;

        Node result = null;
        while (node != null){
            Node temp = node.next;
            node.next = result;
            result = node;
            node = temp;
        }
        node = result;
        return result;
    }
}
