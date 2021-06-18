package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hj102_Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp ;

        while ((temp = bufferedReader.readLine()) != null){

            Map<Character,Integer> map = new HashMap<>();

            for (int i = 0; i < temp.length(); i++) {
                map.put(temp.charAt(i),map.getOrDefault(temp.charAt(i),0) + 1);
            }

            PriorityQueue<MyClass> queue = new PriorityQueue<>(new Mycom());

            for (Map.Entry<Character,Integer> keyVal :map.entrySet()
                 ) {
                queue.add(new MyClass(keyVal.getKey(),keyVal.getValue()));
            }

            while (!queue.isEmpty()){

                System.out.print(queue.poll().zf);

            }
            System.out.println();

        }
    }



    private static class Mycom implements Comparator<MyClass>{

        @Override
        public int compare(MyClass o1, MyClass o2) {

            return (o2.num == o1.num) ? (o1.zf - o2.zf) : (o2.num - o1.num);
        }
    }

    private static class MyClass{

        private char zf;

        private int num;


        public MyClass(char zf, int num) {
            this.zf = zf;
            this.num = num;
        }
    }
}
