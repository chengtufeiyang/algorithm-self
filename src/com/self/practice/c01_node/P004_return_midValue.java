package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;

public class P004_return_midValue {
//        1、奇数个数据返回唯一中点，
//            2、偶数返回下一个中点；
//            3、奇数个数量，返回中点前一个中点；
//            4、偶数个数量，返回上中点。
    public Node returnMidNode(Node head){
        if (head== null || head.next == null) return head;
        Node fast = head.next;
        Node slow = head;

        while (fast !=null && slow !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
