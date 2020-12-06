package com.self.practice.comm_tools;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Node {

    public int value;

    public Node next;
    /**
     * 随机指针
     */
    public Node randomNode;

    public Node(int value) {
        this.value = value;
    }

    //随机值
    public static Random random = new Random();

    /**
     * 根据链表容量和其中最大值，创建只有next的单链表
     * @param capacity
     * @param maximum
     * @return
     */
    public static Node createOnlyNextNode(int capacity,int maximum){

        Node preHead = new Node(-1);
        Node temp = preHead;
        for (int i = 0; i < capacity; i++) {
            temp.next = new Node(random.nextInt(maximum+1));
            temp = temp.next;
        }
        return preHead.next;
    }

    /**
     * 生成回文结果链表
     * @param capacity
     * @param maximum
     * @return
     */
    public static Node createPalindromeNode(int capacity,int maximum){
        Node preHead = new Node(-1);
        Node temp = preHead;

        int temp_capacity = capacity/2;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temp_capacity; i++) {
            int temp_ram = random.nextInt(maximum+1);
            stack.addLast(temp_ram);
            temp.next = new Node(temp_ram);
            temp = temp.next;
        }
        if (capacity%2 != 0){
            temp.next = new Node(random.nextInt(maximum+1));
            temp = temp.next;
        }
        while (!stack.isEmpty()){
            temp.next = new Node(stack.pollLast());
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
