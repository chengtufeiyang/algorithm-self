package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;

public class P06_split_node {

    public static void main(String[] args) {


        Node head = Node.createOnlyNextNode(7,30);
        Node.printNode(head);
        int value = Node.random.nextInt(31);
        System.out.println(value);
        Node.printNode( splitNodeByValue(head,value));

    }
//    6、给定标准值，分隔单链表（小于部分+等于部分+大于部分）

    /**
     * 根据value值将链表按照（<value  +  =value   + >value 三个部分）重新排列组合
     * @param head
     * @param value
     * @return
     */
    public static Node splitNodeByValue(Node head,int value){
        if (head==null  || head.next == null) return head;
        //小于部分
        Node less_head = null;
        Node less_tail = null;
        // 等于部分
        Node equal_head = null;
        Node equal_tail = null;
        //  大于部分
        Node greater_head = null;
        Node greater_tail = null;

        Node temp = head;
        while (temp != null){//生成三份独立 链表段
            Node temp_t = temp.next;
            temp.next = null;
            if (temp.value < value){
                if (less_head==less_tail && less_head==null){
                    less_head = temp;
                    less_tail = temp;
                }else {
                    less_tail.next = temp;
                    less_tail = less_tail.next;
                }
            }else if (temp.value == value){
                if (equal_head==equal_tail && equal_head==null){
                    equal_head = temp;
                    equal_tail = temp;
                }else {
                    equal_tail.next = temp;
                    equal_tail = equal_tail.next;
                }
            }else {
                if (greater_head==greater_tail && greater_head==null){
                    greater_head = temp;
                    greater_tail = temp;
                }else {
                    greater_tail.next = temp;
                    greater_tail = greater_tail.next;
                }
            }
            temp = temp_t;
        }

        //将三份独立的链表段进行联合
        if (less_tail != null){ //如果小于部分尾部不为空
            less_tail.next = equal_head==null ? greater_head:equal_head;
        }

        if (equal_tail!=null){
            equal_tail.next = greater_head;
        }
        return less_head==null ? (equal_head ==null ? greater_head:equal_head) : less_head  ;
    }
}
