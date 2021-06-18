package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hj008_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        while ((temp = bufferedReader.readLine()) != null){

            int num = Integer.parseInt(temp);
            Map<Integer,Integer> map = new HashMap<>();
            while (num > 0){
                temp = bufferedReader.readLine();
                map.put(Integer.valueOf(temp.split(" ")[0]),
                        map.getOrDefault(Integer.valueOf(temp.split(" ")[0]),0) +
                                Integer.valueOf(temp.split(" ")[1]));

                num--;
            }
            PriorityQueue<MyClass> queue = new PriorityQueue<>(new Mycom());
            for (Map.Entry<Integer,Integer> entry :
                 map.entrySet()) {
                queue.add(new MyClass(entry.getKey(), entry.getValue()));
            }

            while (!queue.isEmpty()){
                System.out.println(queue.peek().key + " "+ queue.peek().val);
                queue.poll();
            }

        }


    }

    private static class MyClass {

        private int key;

        private int val;

        public MyClass(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    private static class Mycom implements Comparator<MyClass>{


        @Override
        public int compare(MyClass o1, MyClass o2) {
            return o1.key - o2.key;
        }
    }
}
