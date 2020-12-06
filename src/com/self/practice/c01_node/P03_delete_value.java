package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;

public class P03_delete_value {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(4);

        node = new P03_delete_value().deleteValue(node,2);
        System.out.println(node);


    }

    /**
     * 新建结果node---result，循环链表，
     * 遇值与目标值不同节点，链入result
     *
     * @param node
     * @param val
     * @return
     */
    public Node deleteValue(Node node,int val){
        if (null==node) return node;
        Node result = new Node(0);
        Node temp = result;
        Node tp = null;

        while (node !=null){
            if (node.value != val){
                tp = node.next;
                node.next = null;
                temp.next = node;
                temp = temp.next;
                node = tp;
            }else {
                node = node.next;
            }
        }
        return result.next;
    }
}
