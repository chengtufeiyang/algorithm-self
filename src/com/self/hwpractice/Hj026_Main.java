package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Hj026_Main {

    /**
     *
     *编写一个程序，将输入字符串中的字符按如下规则排序。
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 如，输入： Type 输出： epTy
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 如，输入： BabA 输出： aABb
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     * 如，输入： By?e 输出： Be?y
     * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
     *
     * 输入描述：
     * 输入字符串
     * 输出描述：
     * 输出字符串
     * 示例1
     * 输入：
     * A Famous Saying: Much Ado About Nothing (2012/8).
     * 输出：
     * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            StringBuilder sb = new StringBuilder(); // 存储最终结果

            PriorityQueue<MyClass> queue = new PriorityQueue<>(new Comparator<MyClass>() {
                @Override
                public int compare(MyClass o1, MyClass o2) {
                    return (String.valueOf(o1.selfChar).toLowerCase().charAt(0) - String.valueOf(o2.selfChar).toLowerCase().charAt(0) == 0)
                            ? o1.index - o2.index : (String.valueOf(o1.selfChar).toLowerCase().charAt(0) - String.valueOf(o2.selfChar).toLowerCase().charAt(0)) ;
                }
            });

            List<MyClass> list = new ArrayList<>();

            for (int i = 0; i < temp.length(); i++) {

                if ((temp.charAt(i) >= 'a' && temp.charAt(i) <= 'z')
                || (temp.charAt(i) >= 'A' && temp.charAt(i) <= 'Z')){

                    queue.add(new MyClass(i,temp.charAt(i)));
                }else {
                    list.add(new MyClass(i,temp.charAt(i)));
                }
            }

            int indexList = 0;//记录当前使用指标
            int indexChar = 0;// 字符拼接位置

            while (!queue.isEmpty()){
                if (indexList < list.size() && list.get(indexList).index == indexChar){
                    sb.append(list.get(indexList++).selfChar);
                }else {
                    sb.append(queue.poll().selfChar);
                }
                indexChar++;
            }

            for (int i = indexList; i < list.size(); i++) {
                sb.append(list.get(i).selfChar);
            }
            System.out.println(sb);

        }

    }

    private static class  MyClass{

        private int index;
        private char selfChar;

        public MyClass(int index, char selfChar) {
            this.index = index;
            this.selfChar = selfChar;
        }
    }


}
