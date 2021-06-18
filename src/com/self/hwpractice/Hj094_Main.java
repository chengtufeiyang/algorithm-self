package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Hj094_Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            int personNum = Integer.valueOf(temp); // 候选人数量

            // 候选人数组集合
            String[] strs = (bufferedReader.readLine()).split(" ");
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                map.put(strs[i],0);
            }

            int voteNum = Integer.valueOf(bufferedReader.readLine());//投票数量

            String[] strsVote = (bufferedReader.readLine()).split(" ");
            for (int i = 0; i < strsVote.length; i++) {
                if (map.get(strsVote[i]) == null){
                    map.put("Invalid",map.getOrDefault("Invalid",0) + 1);
                }else {
                    map.put(strsVote[i], map.get(strsVote[i]) + 1);
                }
            }

            for (int i = 0; i < strs.length; i++) {
                System.out.println(strs[i] + " : " + map.get(strs[i]));
            }
            System.out.println("Invalid" + " : " + map.getOrDefault("Invalid",0));
        }

    }
}
