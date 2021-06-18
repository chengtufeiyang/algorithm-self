package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Hj092_Main {

    public static void main(String[] args) throws IOException {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {


            PriorityQueue<MyClass> queue = new PriorityQueue<>(new MyCom());


            for (int i = 0; i < temp.length(); ) {
                char curr = temp.charAt(i);

                if (curr >= '0' && curr <= '9'){
                    int len = 0;
                    while (curr >= '0' && curr <= '9'){
                        len++;
                        i++;
                        curr = i == temp.length() ? 'a' : temp.charAt(i);
                    }

                    if (queue.peek() != null && queue.peek().len == len){
                        queue.peek().list.add(i - len);
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i - len);
                        queue.add(new MyClass(list,len));
                    }
                }else {
                    i++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < queue.peek().list.size(); i++) {
                sb.append(temp.substring(queue.peek().list.get(i),queue.peek().list.get(i) + queue.peek().len));
            }

            System.out.println(sb + ","+ queue.peek().len);
        }
    }



    private static class MyCom implements Comparator<MyClass> {

        @Override
        public int compare(MyClass o1, MyClass o2) {
            return o2.len - o1.len;
        }
    }


    private static class MyClass{

        private List<Integer> list;

        private int len;

        public MyClass(List<Integer> list, int len) {
            this.list = list;
            this.len = len;
        }
    }


}
