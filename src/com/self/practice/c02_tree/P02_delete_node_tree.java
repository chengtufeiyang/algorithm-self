package com.self.practice.c02_tree;

import com.self.practice.comm_tools.Node;
import com.self.practice.comm_tools.Tree;

import java.util.HashMap;

public class P02_delete_node_tree {


    public static void main(String[] args) {
        Node head = Node.createOnlyNextNode(10,5);

//        Node head = new Node(3);
//        head.next = new Node(3);
//        head.next.next = new Node(3);
//        head.next.next.next = new Node(3);
        Node.printNode(head);
        Node.printNode(deleteByValueNolyOne(head,3));
        Node.printNode(deleteByValueAll(head,3));
    }

    /**
     * 删除链表中指定节点,只删除遇到的第一个
     * @param head
     * @param delete
     * @return
     */
    public static Node deleteByValueNolyOne(Node head, int delete){
      if (null == head  ) return head;
        System.out.println("删除节点，一次删除----"+delete);
      Node temp = head;
      Node pre = new Node(Integer.MIN_VALUE);
      while (null != temp && temp.value != delete){
          pre = temp;
          temp = temp.next;
      }

      if (pre.value==Integer.MIN_VALUE)return head.next;//考虑头节点情况
        if (null != temp){
            pre.next = temp.next;

        }
        return head;
    }

    /**
     * 删除链表中指定节点,删除所有值符合条件的节点
     * @param head
     * @param delete
     * @return
     */
    public static Node deleteByValueAll(Node head, int delete){
        if (null == head  ) return head;
        System.out.println("删除符合条件的节点----"+delete);

        Node pre = new Node(1);
        pre.next = head;
        Node temp_pre = pre;
        Node temp = head;
        while (null != temp ){
            if (temp.value == delete){
                temp_pre.next = temp.next;
                temp = temp.next;
            }else {
                temp_pre = temp;
                temp = temp.next;
            }
        }
        return pre.next;
    }
}
