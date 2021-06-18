package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Hj034_Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            PriorityQueue<Character> queue = new PriorityQueue<>();
            for (int i = 0; i < temp.length(); i++) {
                queue.add(temp.charAt(i));
            }

            while (!queue.isEmpty()){
                System.out.print(queue.poll());
            }
            System.out.println();
        }
    }
}
