package com.self.practice.c01_node;

import com.self.practice.comm_tools.Node;

import java.util.HashSet;
import java.util.Set;

public class P09_banana_node {

    public static void main(String[] args) {

    }


    /**
     * 判断两个链表是否相交
     *
     * @param headOne
     * @param headTwo
     * @return
     */
    public static boolean bananaNodeIsTrue(Node headOne, Node headTwo) {

        //  both  no loop
        if (!P08_loop_node_entry_point.loopNode(headOne) && !P08_loop_node_entry_point.loopNode(headTwo)) {
            return noLoopBananaNodeIsTrue(headOne,null,headTwo,null);
        }

        // both loop
        if (P08_loop_node_entry_point.loopNode(headOne) && P08_loop_node_entry_point.loopNode(headTwo)) {
            return loopBananaNodeIsTrue(headOne,P08_loop_node_entry_point.loopNodeEntryPointNode(headOne),
                    headTwo,P08_loop_node_entry_point.loopNodeEntryPointNode(headTwo));
        }
        return false;
    }


    /**
     * 返回两个链表相交节点
     *
     * @param headOne
     * @param headTwo
     * @return
     */
    public static Node bananaNode(Node headOne, Node headTwo) {

        //  both  no loop
        if (!P08_loop_node_entry_point.loopNode(headOne) && !P08_loop_node_entry_point.loopNode(headTwo)) {
            return noLoopBananaNode(headOne,null,headTwo,null);
        }

        // both loop
        if (P08_loop_node_entry_point.loopNode(headOne) && P08_loop_node_entry_point.loopNode(headTwo)) {
            return loopBananaNode(headOne,P08_loop_node_entry_point.loopNodeEntryPointNode(headOne),
                    headTwo,P08_loop_node_entry_point.loopNodeEntryPointNode(headTwo));
        }
        return null;
    }

    /**
     * 判断两个无环链表是否相交---非容器法
     *
     * @param headOne
     * @param headTwo
     * @return
     */
    public static boolean noLoopBananaNodeIsTrue(Node headOne,Node endNodeOne, Node headTwo,Node endNodeTwo) {

        Node endOne = null;
        Node endTwo = null;
        Node temp_one = headOne;
        int count = 0;
        while (temp_one != endNodeOne) {//循环第一个
            count++;
            endOne = temp_one;
            temp_one = temp_one.next;
        }

        Node temp_two = headTwo;
        while (temp_two != endNodeTwo) {
            count--;
            endTwo = temp_two;
            temp_two = temp_two.next;
        }
        //若count > 0 则链表 headOne较长   若count < 0 则链表headTwo 较长
        return endOne == endTwo ? true : false;
    }

    /**
     * 判断两个有环链表是否相交---非容器法
     *
     * @param headOne
     * @param headTwo
     * @return
     */
    public static boolean loopBananaNodeIsTrue(Node headOne,Node endNodeOne, Node headTwo,Node endNodeTwo) {


       if (endNodeOne ==endNodeTwo){//入环节点相同情况
            return noLoopBananaNodeIsTrue(headOne,endNodeOne,headTwo,endNodeTwo);
       }else {//入环节点不同情况
            Node fast = endNodeOne.next;
            Node slow = endNodeTwo.next;
            while (fast != endNodeOne && slow != endNodeTwo){
                if (fast == slow){
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
       }
    }

    /**
     * 判断两个无环链表是否相交---容器法
     *
     * @param headOne
     * @param headTwo
     * @return
     */
    public static boolean noLoopBananaNodeByContainereIsTrue(Node headOne,Node endNodeOne, Node headTwo,Node endNodeTwo) {
        if (headOne==null && headTwo == null) return false;
        if (headOne == null && headTwo != null) return false;
        if (headOne != null && headTwo == null) return false;

        Set<Node> setOne = new HashSet<>();
        Node tempOne = headOne;
        while (tempOne != endNodeOne){
            setOne.add(tempOne);
            tempOne = tempOne.next;
        }

        Node tempTwo = headTwo;
        while (tempTwo != endNodeTwo){

            if (setOne.contains(tempTwo)){
                return true;
            }
            tempTwo = tempTwo.next;
        }
        return false;
    }



    /**
     * 返回两个无环链表相交节点---非容器法
     *存在返回节点，不存在则返回null
     * @param headOne
     * @param headTwo
     * @return
     */
    public static Node noLoopBananaNode(Node headOne,Node endNodeOne, Node headTwo,Node endNodeTwo) {

        Node endOne = null;
        Node endTwo = null;
        Node temp_one = headOne;
        int count = 0;
        while (temp_one != endNodeOne) {//循环第一个
            count++;
            endOne = temp_one;
            temp_one = temp_one.next;
        }

        Node temp_two = headTwo;
        while (temp_two != endNodeTwo) {
            count--;
            endTwo = temp_two;
            temp_two = temp_two.next;
        }

        //首先判断是否存在交点
        if(endOne != endTwo){
            return null;
        }

        //若count > 0 则链表 headOne较长   若count < 0 则链表headTwo 较长
        Node longNode = count > 0 ? headOne:headTwo;
        Node shortNode = longNode==headOne ? headTwo :headOne;

        count = Math.abs(count);
        while (count != 0){
            longNode = longNode.next;
        }

        while (longNode !=endNodeTwo && shortNode != endNodeTwo){
            if (longNode==shortNode){
                return longNode;
            }
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return null;
    }


    /**
     * 返回两个有环链表相交节点---非容器法
     *存在返回节点，不存在则返回null
     * @param headOne
     * @param headTwo
     * @return
     */
    public static Node loopBananaNode(Node headOne,Node endNodeOne, Node headTwo,Node endNodeTwo) {

        if (endNodeOne ==endNodeTwo){//入环节点相同情况
            return noLoopBananaNode(headOne,endNodeOne,headTwo,endNodeTwo);
        }else {//入环节点不同情况
            Node fast = endNodeOne.next;
            Node slow = endNodeTwo.next;
            while (fast != endNodeOne && slow != endNodeTwo){
                if (fast == slow){
                    return fast;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return null;
        }
    }


    /**
     * 返回两个无环链表相交节点---容器法
     *存在返回节点，不存在则返回null
     * @param headOne
     * @param headTwo
     * @return
     */
    public static Node noLoopBananaNodeByContainere(Node headOne, Node headTwo) {

        if (headOne==null && headTwo == null) return null;
        if (headOne == null && headTwo != null) return null;
        if (headOne != null && headTwo == null) return null;

        Set<Node> setOne = new HashSet<>();
        Node tempOne = headOne;
        while (tempOne != null){
            setOne.add(tempOne);
            tempOne = tempOne.next;
        }

        Node tempTwo = headTwo;
        while (tempTwo != null){
            if (setOne.contains(tempTwo)){
                return tempTwo;
            }
            tempTwo = tempTwo.next;
        }
        return null;
    }







}
