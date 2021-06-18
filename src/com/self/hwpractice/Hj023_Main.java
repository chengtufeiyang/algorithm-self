package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hj023_Main {


    /**
     * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     * 注意每个输入文件有多组输入，即多个字符串用回车隔开
     * 输入描述：
     * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
     * <p>
     * 输出描述：
     * 删除字符串中出现次数最少的字符后的字符串。
     * <p>
     * 示例1
     * 输入：
     * abcdd
     * aabcddd
     * 复制
     * 输出：
     * dd
     * aaddd
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            Map<Character,Integer> map = new HashMap<>();
            PriorityQueue<MyClass> queue = new PriorityQueue<>(new Comparator<MyClass>() {
                @Override
                public int compare(MyClass o1, MyClass o2) {
                    return o1.num - o2.num;
                }
            });

            for (int i = 0; i < temp.length(); i++) {
                map.put(temp.charAt(i),map.getOrDefault(temp.charAt(i),0) + 1);
            }

            for (Map.Entry<Character,Integer> data:map.entrySet()) {

                queue.add(new MyClass(data.getKey(),data.getValue()));
            }

            map = new HashMap<>();  // 记录需删除字符
            int preNum = queue.peek().num; // 前一个最小数量，如果仍相同继续标记删除字符


            while (!queue.isEmpty()){

                if (queue.peek().num == preNum){
                    map.put(queue.poll().curr,1);
                }else {
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < temp.length(); i++) {
                if (null == map.get(temp.charAt(i))){
                    sb.append(temp.charAt(i));
                }
            }
            System.out.println(sb);
        }

    }

    private static class MyClass {

        private char curr;

        private int num;

        public MyClass(char curr, int num) {
            this.curr = curr;
            this.num = num;
        }
    }


}
