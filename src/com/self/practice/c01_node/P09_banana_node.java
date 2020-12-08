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
            return NoLoopNodeBananaByContainer.noLoopBananaNodeByContainereIsTrue(headOne, null, headTwo, null);
        }
        // both loop
        if (P08_loop_node_entry_point.loopNode(headOne) && P08_loop_node_entry_point.loopNode(headTwo)) {

            return LoopNodeBananaByContainer.loopBananaNodeByContainereIsTrue(headOne,headTwo);
        }
        return false;
    }


    /**
     * 返回两个链表相交节点---容器法
     *
     * @param headOne
     * @param headTwo
     * @return
     */
    public static Node bananaNode(Node headOne, Node headTwo) {

        //  both  no loop
        if (!P08_loop_node_entry_point.loopNode(headOne) && !P08_loop_node_entry_point.loopNode(headTwo)) {
            return NoLoopNodeBananaByContainer.noLoopBananaNodeByContainere(headOne, null, headTwo, null);
        }
        // both loop
        if (P08_loop_node_entry_point.loopNode(headOne) && P08_loop_node_entry_point.loopNode(headTwo)) {
            return LoopNodeBananaByContainer.loopBananaNodeByContainere(headOne, headTwo);
        }
        return null;
    }


    /**
     * 无环链表相交情况判断及返回相交节点---容器法
     */
    private static class NoLoopNodeBananaByContainer {


        /**
         * 判断两个无环链表是否相交---容器法
         *
         * @param headOne
         * @param headTwo
         * @return
         */
        public static boolean noLoopBananaNodeByContainereIsTrue(Node headOne, Node endNodeOne, Node headTwo, Node endNodeTwo) {
            if (headOne == null && headTwo == null) return false;
            if (headOne == null && headTwo != null) return false;
            if (headOne != null && headTwo == null) return false;

            Set<Node> setOne = new HashSet<>();//节存储容器
            Node tempOne = headOne;
            while (tempOne != endNodeOne) {
                setOne.add(tempOne);
                tempOne = tempOne.next;
            }

            Node tempTwo = headTwo;
            while (tempTwo != endNodeTwo) {
                if (setOne.contains(tempTwo)) {
                    return true;
                }
                tempTwo = tempTwo.next;
            }
            return false;
        }

        /**
         * 返回两个无环链表相交节点---容器法
         * 存在返回节点，不存在则返回null
         *
         * @param headOne
         * @param headTwo
         * @return
         */
        public static Node noLoopBananaNodeByContainere(Node headOne, Node endNodeOne, Node headTwo, Node endNodeTwo) {

            if (headOne == null && headTwo == null) return null;
            if (headOne == null && headTwo != null) return null;
            if (headOne != null && headTwo == null) return null;

            Set<Node> setOne = new HashSet<>();
            Node tempOne = headOne;
            while (tempOne != endNodeOne) {
                setOne.add(tempOne);
                tempOne = tempOne.next;
            }

            Node tempTwo = headTwo;
            while (tempTwo != endNodeTwo) {
                if (setOne.contains(tempTwo)) {
                    return tempTwo;
                }
                tempTwo = tempTwo.next;
            }
            return null;
        }
    }

    /**
     * 无环链表相交情况判断及返回相交节点---非容器法
     */
    private static class NoLoopNodeBananaBySelf {
        /**
         * 判断两个无环链表是否相交
         *根据最后一个节点是否相等判断两个无环链表
         * @param headOne
         * @param headTwo
         * @return
         */
        public static boolean noLoopBananaNodeIsTrue(Node headOne, Node endNodeOne, Node headTwo, Node endNodeTwo) {

            Node endOne = null;
            Node endTwo = null;
            Node temp_one = headOne;
            while (temp_one != endNodeOne) {
                endOne = temp_one;
                temp_one = temp_one.next;
            }

            Node temp_two = headTwo;
            while (temp_two != endNodeTwo) {
                endTwo = temp_two;
                temp_two = temp_two.next;
            }
            return endOne == endTwo ? true : false;
        }

        /**
         * 返回两个无环链表相交节点---非容器法
         * 存在返回节点，不存在则返回null
         *
         * @param headOne
         * @param headTwo
         * @return
         */
        public static Node noLoopBananaNode(Node headOne, Node endNodeOne, Node headTwo, Node endNodeTwo) {

            Node temp_one = headOne;
            int count = 0;
            while (temp_one != endNodeOne) {//循环第一个
                count++;
                temp_one = temp_one.next;
            }

            Node temp_two = headTwo;
            while (temp_two != endNodeTwo) {
                count--;
                temp_two = temp_two.next;
            }

            //首先判断是否存在交点
            if (temp_one != temp_two) {
                return null;
            }

            //若count > 0 则链表 headOne较长   若count < 0 则链表headTwo 较长
            Node longNode = count > 0 ? headOne : headTwo;
            Node shortNode = longNode == headOne ? headTwo : headOne;

            count = Math.abs(count);
            while (count != 0) {
                count--;
                longNode = longNode.next;
            }

            // 到这一步了一定有一个相交点
            while (longNode !=shortNode ) {
                longNode = longNode.next;
                shortNode = shortNode.next;
            }
            return longNode;
        }
    }


    /**
     * 有环链表相交情况判断及返回相交节点---容器法
     */
    private static class LoopNodeBananaByContainer {


        /**
         * 判断两个有环链表是否相交---容器法
         *
         * @param headOne
         * @param headTwo
         * @return
         */
        public static boolean loopBananaNodeByContainereIsTrue(Node headOne, Node headTwo) {
            if (headOne == null && headTwo == null) return false;
            if (headOne == null && headTwo != null) return false;
            if (headOne != null && headTwo == null) return false;

            Set<Node> setOne = new HashSet<>();//节存储容器
            Node tempOne = headOne;
            while (tempOne != null) {
                if(!setOne.contains(tempOne)){
                    setOne.add(tempOne);
                }else {
                    break;
                }
                tempOne = tempOne.next;
            }

            Node tempTwo = headTwo;
            Set<Node> setTwo = new HashSet<>();//节存储容器
            while (tempTwo != null) {
                if (setOne.contains(tempTwo)) {
                    return true;
                }
                if (!setTwo.contains(tempTwo)){
                    setTwo.add(tempTwo);
                }else {
                    break;
                }
                tempTwo = tempTwo.next;
            }
            return false;
        }

        /**
         * 返回两个无环链表相交节点---容器法
         * 存在返回节点，不存在则返回null
         *
         * @param headOne
         * @param headTwo
         * @return
         */
        public static Node loopBananaNodeByContainere(Node headOne, Node headTwo) {

            if (headOne == null && headTwo == null) return null;
            if (headOne == null && headTwo != null) return null;
            if (headOne != null && headTwo == null) return null;

            Set<Node> setOne = new HashSet<>();
            Node tempOne = headOne;
            while (tempOne != null) {
                if(!setOne.contains(tempOne)){
                    setOne.add(tempOne);
                }else {
                    break;
                }
                tempOne = tempOne.next;
            }

            Node tempTwo = headTwo;
            Set<Node> setTwo = new HashSet<>();//节存储容器
            while (tempTwo != null) {
                if (setOne.contains(tempTwo)) {
                    return tempTwo;
                }
                if (!setTwo.contains(tempTwo)){
                    setTwo.add(tempTwo);
                }else {
                    break;
                }
                tempTwo = tempTwo.next;
            }
            return null;
        }
    }

    /**
     * 有环链表相交情况判断及返回相交节点---非容器法
     */
    private static class LoopNodeBananaBySelf {
        /**
         * 判断两个有环链表是否相交---非容器法
         *
         * @param headOne
         * @param headTwo
         * @return
         */
        public static boolean loopBananaNodeIsTrue(Node headOne, Node endNodeOne, Node headTwo, Node endNodeTwo) {

            if (endNodeOne == endNodeTwo) {//入环节点相同情况
                return  NoLoopNodeBananaBySelf.noLoopBananaNodeIsTrue(headOne, endNodeOne, headTwo, endNodeTwo);
            } else {//入环节点不同情况
                Node fast = endNodeOne.next;
                while (fast != endNodeOne){
                    if (fast == endNodeTwo){
                        return true;
                    }
                    fast = fast.next;
                }
                return false;
            }
        }

        /**
         * 返回两个有环链表相交节点---非容器法
         * 存在返回节点，不存在则返回null
         *
         * @param headOne
         * @param headTwo
         * @return
         */
        public static Node loopBananaNode(Node headOne, Node endNodeOne, Node headTwo, Node endNodeTwo) {

            if (endNodeOne == endNodeTwo) {//入环节点相同情况
                return NoLoopNodeBananaBySelf.noLoopBananaNode(headOne, endNodeOne, headTwo, endNodeTwo);
            } else {//入环节点不同情况
                Node fast = endNodeOne.next;
                while (fast != endNodeOne){
                    if (fast == endNodeTwo){
                        return fast;
                    }
                    fast = fast.next;
                }
                return null;
            }
        }
    }

}
