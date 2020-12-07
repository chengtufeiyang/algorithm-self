package com.self.practice.comm_tools;

import java.util.*;

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

    //记录尾部节点
    public static Node end;

    //记录所有节点
    public static List<Node> allNode = new ArrayList<>();

    /**
     * 根据链表容量和其中最大值，创建只有next的单链表
     * 并保存end节点
     * @param capacity
     * @param maximum
     * @return
     */
    public static Node createOnlyNextNode(int capacity,int maximum){

        Node preHead = new Node(-1);
        Node temp = preHead;
        for (int i = 0; i < capacity; i++) {
            temp.next = new Node(random.nextInt(maximum+1));
            allNode.add(temp.next);
            temp = temp.next;
        }
        end = temp;//存储尾节点
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
     * 创建包含随机指针的单向链表（设置一半几点包含随机指针）
     * @param capacity
     * @param maximum
     * @return
     */
    public static Node createNextAndRandomNode(int capacity,int maximum){
        Node head = createOnlyNextNode(capacity,maximum);
        List<Node> list_node = new ArrayList<>();
        Node temp = head;
        while (temp != null){
            list_node.add(temp);
            temp = temp.next;
        }
        int randomNum = list_node.size()/2;
        int size = list_node.size();
        for (int i = 0; i < randomNum; i++) {
            int temp_one = random.nextInt(size);
            int temp_two = random.nextInt(size);
            list_node.get(temp_one).randomNode = list_node.get(temp_two);
        }
        return head;
    }

    /**
     * 生成环行节点
     * @param capacity
     * @param maximum
     * @return
     */
    public static Node createLoopNode(int capacity,int maximum){

        Node head = createOnlyNextNode(capacity,maximum);
        //生成随机数，连接该随机数对应节点与尾节点
        int index = random.nextInt(allNode.size());
        end.next = allNode.get(index);
        return head;
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

    /**
     * 打印包含随机指针的单向链表
     * @param head
     */
    public static void printNodeInRandom(Node head){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb_random = new StringBuilder();

        while (head != null){
            sb.append(head.value).append("->");
            if (head.randomNode != null){
                sb_random.append(head.value).append("->>").append(head.randomNode.value).append(" ");
            }
            head = head.next;
        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-2));
        System.out.println(sb_random.toString());
    }

    /**
     * 打印循环链表
     * @param head
     */
    public static void printLoopNode(Node head){
        if (head==null) return;
        Set<Node> set = new HashSet<>();
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null){
            if (!set.contains(temp)){
                set.add(temp);
                sb.append(temp.value).append("->");
                temp = temp.next;
            }else {
                System.out.println("入口节点："+temp.value);
                break;
            }
        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-2));
    }

}
