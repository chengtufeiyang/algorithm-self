package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;
import com.self.practice.comm_tools.enums.NodeMidTypeEnum;

public class P04_return_midValue {

    public static void main(String[] args) {
        Node head = Node.createOnlyNextNode(10,100);
        Node.printNode(head);
        System.out.println("ordinary---"+
              returnMidNode(head).value
        );
        System.out.println(retrunMutiMidNode(head,NodeMidTypeEnum.EVEN_PRE.getValue()).value);
        System.out.println(retrunMutiMidNode(head,NodeMidTypeEnum.EVEN_AFT.getValue()).value);
        System.out.println(retrunMutiMidNode(head,NodeMidTypeEnum.ODD_MID.getValue()).value);
        System.out.println(retrunMutiMidNode(head,NodeMidTypeEnum.ODD_MID_PRE.getValue()).value);
        System.out.println(retrunMutiMidNode(head,NodeMidTypeEnum.ODD_MID_AFT.getValue()).value);
    }

//       当判断条件中fast==null，则数据量为奇数
//       当判断条件fast.next==null ,则数据量为偶数
//        1、奇数个数据返回唯一中点，
//            2、偶数返回下一个中点；
//            3、奇数个数量，返回中点前一个中点；
//            4、偶数个数量，返回上中点。

    /**
     * 奇数情况返回中点
     * 偶数情况返回中间线前一个（如例子：1-2-3-4 ，返回：2）
     * @param head
     * @return
     */
    public static Node returnMidNode(Node head){
        if (head== null || head.next == null) return head;
        Node fast = head.next;
        Node slow = head;

        while (fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
//        System.out.println(fast==null);
        return slow;
    }

    /**
     *根据不同类别返回不同要求的中心节点
     * @param head
     * @param nodeType
     * @return
     */
    public static Node retrunMutiMidNode(Node head,int nodeType){
        if (head == null) return head;

        Node odd_mid_pre = null;

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            odd_mid_pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(nodeType==NodeMidTypeEnum.ODD_MID_PRE.getValue()){
            return odd_mid_pre;
        }
        if(nodeType==NodeMidTypeEnum.EVEN_AFT.getValue() || nodeType==NodeMidTypeEnum.ODD_MID_AFT.getValue()){
            return slow.next;
        }
        return slow;//返回奇数中点  or  偶数中线前一个节点
    }

}
