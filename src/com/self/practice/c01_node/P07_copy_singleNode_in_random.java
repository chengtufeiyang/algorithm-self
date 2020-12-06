package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;

import java.util.HashMap;
import java.util.Map;

public class P07_copy_singleNode_in_random {


    public static void main(String[] args) {
//        Node head = Node.createOnlyNextNode(9,20);
//        Node.printNode(head);
//        Node.printNode(copyNodeInrandomByContainer(head));

        Node head = Node.createNextAndRandomNode(5,20);
        Node.printNodeInRandom(head);
        System.out.println("--------------------------------------------");
        Node.printNodeInRandom(copyNodeInrandomByContainer(head));
        System.out.println("--------------------------------------------");
        Node.printNodeInRandom(copyNodeInrandomBySelf(head));
    }


//    7、复制一个包含random指针的单链表（1、使用容器；2、不使用容器）

    /**
     * 使用容器完成含有随机指针的单向链表的复制操作
     * @param head
     * @return
     */
    public static Node copyNodeInrandomByContainer(Node head){
        if (head ==null) return head;
        Node temp_head = head;
        Map<Node,Node> map = new HashMap<>();
        Node copy_node = new Node(0);
        while (temp_head != null){//生产可用容器
            copy_node.next = new Node(temp_head.value);
            copy_node = copy_node.next;
            map.put(temp_head,copy_node);
            temp_head = temp_head.next;
        }

        //利用容器连接next和random关系
        temp_head = head;
        while (temp_head != null){
            map.get(temp_head).randomNode = map.get(temp_head.randomNode);
            temp_head = temp_head.next;
        }
        return map.get(head);
    }

    /**
     * 重新构建原链表，每个节点后加入新的节点（value值与前一个原链表中像等级）
     * @param head
     * @return
     */
    public static Node copyNodeInrandomBySelf(Node head){
        if (head == null) return head;
        //原链表中每个节点后根据value值复制一个新的节点，并插入其中
        Node temp = head;
        while (temp != null){
            Node temp_t = temp.next;
            Node new_node = new Node(temp.value);
            temp.next = new_node;
            new_node.next = temp_t;
            temp = temp_t;
        }

        //根据原链表中节点间的random关系，构建新节点之间的关系
        temp = head;
        while (temp != null){
            if (temp.randomNode != null){
                temp.next.randomNode = temp.randomNode.next;
            }
            temp = temp.next.next;
        }

        //拆分当前链表  旧表和新表

        temp = head;
        Node result = new Node(0);
        Node temp_result = result;
        while (temp != null){
            Node temp_t = temp.next.next;
            temp.next.next = null;
            temp_result.next = temp.next;
            temp_result = temp_result.next;
            temp.next = temp_t;
            temp = temp.next;
        }

        return result.next;
    }

}
