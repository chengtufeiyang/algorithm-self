package com.self.practice.comm_tools;

import java.util.Random;

public class Node {

    public int value;

    public Node next;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 根据链表容量和其中最大值，创建只有next的单链表
     * @param capacity
     * @param maximum
     * @return
     */
    public static Node createOnlyNextNode(int capacity,int maximum){
        //随机值
        Random random = new Random();
        Node preHead = new Node(-1);
        Node temp = preHead;
        for (int i = 0; i < capacity; i++) {
            temp.next = new Node(random.nextInt(maximum+1));
            temp = temp.next;
        }
        return preHead.next;
    }


    /**
     * 打印链表数据
     * @param head
     */
    public static void printNode(Node head){
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.value).append("->");
            head = head.next;
        }
//        System.out.println(sb.capacity());//当前默认容量
        System.out.println(sb.toString().substring(0,sb.toString().length()-2));
    }

}
