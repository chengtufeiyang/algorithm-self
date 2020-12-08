package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;

import java.util.HashSet;
import java.util.Set;

public class P08_loop_node_entry_point {
    public static void main(String[] args) {

        Node head = Node.createLoopNode(5,20);
        Node.printLoopNode(head);
        System.out.println(loopNode(head));
        Node head_sj = Node.createOnlyNextNode(5,20);
        Node.printNode(head_sj);
        System.out.println(loopNode(head_sj));


    }

    /**
     * 判断链表是否存在环形结构---非容器法
     * @param head
     * @return
     */
    public static boolean loopNode(Node head){
        if (head==null || head.next ==null || head.next.next==null)return false;

        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next != null){
            if (slow==fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 存在环形情况：返回入口节点----非容器法
     * 无环形情况：返回null
     * @param head
     * @return
     */
    public static Node loopNodeEntryPointNode(Node head){
        if (head == null || head.next == null || head.next.next == null) return null;

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }




    /**
     * 判断链表是否存在环形结构---容器法
     * @param head
     * @return
     */
    public static boolean loopNodeByContainer(Node head){
        if (head==null || head.next ==null || head.next.next==null)return false;

        Set<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null){
            if (!set.contains(temp)){
                set.add(temp);
            }else {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 存在环形情况：返回入口节点----容器法
     * 无环形情况：返回null
     * @param head
     * @return
     */
    public static Node loopNodeEntryPointNodeByContainer(Node head){
        if (head==null || head.next ==null || head.next.next==null)return null;

        Set<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null){
            if (!set.contains(temp)){
                set.add(temp);
            }else {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


}
