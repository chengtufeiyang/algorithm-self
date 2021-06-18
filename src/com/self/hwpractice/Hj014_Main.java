package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Hj014_Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        while ((temp = bufferedReader.readLine()) != null){

            int num = Integer.parseInt(temp);
            PriorityQueue<String> queue = new PriorityQueue<>(new Mycom());
            while (num > 0){
                temp = bufferedReader.readLine();
                queue.add(temp);
                num--;
            }

            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()){
//                System.out.println(queue.poll());
                sb.append(queue.poll()).append('\n');
            }
            System.out.println(sb);
        }

    }

    private static class Mycom implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return com(o1,o2);
        }

        private int com(String o1, String o2) {

            int min = Math.min(o1.length(),o2.length());


            for (int i = 0; i < min; i++) {
                if (o1.charAt(i) != o2.charAt(i)){
                    return o1.charAt(i) - o2.charAt(i);
                }
            }

            return o1.length() - o2.length();
        }
    }

}
