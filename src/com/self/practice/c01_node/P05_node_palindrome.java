package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class P05_node_palindrome {
    public static void main(String[] args) {

        //随机链表生成
        Node head = Node.createPalindromeNode(1,30);
        Node.printNode(head);
        System.out.println(palindromeNodeByContainer(head));
        System.out.println(palindromeNodeBySelf(head));


        Node head_sj = Node.createOnlyNextNode(50,30);
        Node.printNode(head_sj);
        System.out.println(palindromeNodeByContainer(head_sj));
        System.out.println(palindromeNodeBySelf(head_sj));

    }

//    5、判断是否为回文：（两种方法：1、容器法（栈），2、调整生成尾节点）

    /**
     * 容器法：将链表放入栈中，顺序取出（相当于逆序取出），与
     * 原链表值进行对比
     * @param head
     * @return
     */
    public static boolean palindromeNodeByContainer(Node head){
        if (head==null) return false;
        Deque<Node> stack = new ArrayDeque<>();
        Node temp = head;
        while (temp != null){
            stack.add(temp);
            temp = temp.next;
        }
        while (head !=null){
            if(stack.pollLast().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    /**
     *中点位置进行重新设置节点方法，然后进行对比，且对比后需恢复
     * 原链表中的连接关系
     * @param head
     * @return
     */
    public static boolean palindromeNodeBySelf(Node head){
        if (head == null) return false;
        if (head !=null && head.next==null) return true;
        Node mid_node = P04_return_midValue.returnMidNode(head);
        //调整后半段节点间的连接方向
        Node temp_half = mid_node.next;
        mid_node.next = null;
        while (temp_half != null){
            Node temp = temp_half.next;
            temp_half.next = mid_node;
            mid_node = temp_half;
            if (temp ==null) break;
            temp_half = temp;
        }

        //对比
        boolean flag = true;
        Node temp_head = head;
        Node temp_t_half = temp_half;
        while (temp_head != null){
            if (temp_head.value != temp_t_half.value){
                flag = false;
                break;
            }
            temp_head = temp_head.next;
            temp_t_half = temp_t_half.next;
        }

        //恢复原链表
        Node end = null;
        while (temp_half != null){
            Node temp = temp_half.next;
            temp_half.next = end;
            end = temp_half;
            temp_half = temp;
        }
        return flag;
    }




}
