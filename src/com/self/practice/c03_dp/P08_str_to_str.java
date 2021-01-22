package com.self.practice.c03_dp;

import java.util.Arrays;


public class P08_str_to_str {

    public static void main(String[] args) {

        String s = "aabc";
        String[] arr = {"ab","bc","babc"};
        System.out.println(normal(s,arr));
    }


    public static int dp(String s, String[] arr){
        if (null == s || s.length() == 0 || null == arr || arr.length == 0) return 0;

        int row = s.length() + 1; // 需剔除字符总数量---看坐标
        int col = arr.length ;    // 可使用材料数组坐标位置
        int[][]  dp =new  int[row][col];



        return dp[row][0];
    }




    //    8、（19、暴力递归到动态规划（二））字符串拼接问题（任意字符串str,可以由数组arr中最少数量字符串构成，不考虑排序问题，数组中每项元素数量无限）
//            (例如：字符串str---aabc,数组arr[ab,bc,babc]  ,数组全部数据可满足拼接要求，但是数量有3，大于另一个情况，2个babc元素也可满足)
    public static int normal(String s, String[] arr) {
        if (null == s || s.length() == 0 || null == arr || arr.length == 0) return 0;

        //将目标字符串转换为以字符为下标的数组
        int[] s_to_int = convertStr(s);

        return recursion(s_to_int,arr,s.length(),0,0);
    }

    /**
     *
     * @param statis       总的需剔除字符数量统计数组
     * @param materials    可用材料数组
     * @param num          需剔除字符剩余数据量
     * @param currIndex    当前材料数组坐标
     * @param strNum       当前使用字符数量
     * @return
     */
    private static int recursion(int[] statis, String[] materials, int num, int currIndex,int strNum) {
        if (num ==0 ) return strNum; // 匹配完成
        if (currIndex>= materials.length) return Integer.MAX_VALUE; // 材料使用完毕仍未匹配完成

        int[] arr1 = Arrays.copyOf(statis,statis.length);
        int[] arr2 = Arrays.copyOf(statis,statis.length);
        int use = Integer.MAX_VALUE;//使用当前位置字符串统计 有多字符串
        ChangeNum changeNum = change(arr1,num,materials[currIndex]);//变化数据量
        if (changeNum.flag){
            use = recursion(changeNum.arr,materials,changeNum.num,currIndex,strNum + 1) ;
        }
        int noUse = recursion(arr2,materials,num,currIndex+1,strNum); //不使用当前字符串统计 有多少字符串

        return Math.min(use,noUse);
    }


    private static ChangeNum change(int[] statis, int num, String material) {
        if (null==material || material.length()==0) return new ChangeNum(num,statis,false);
        int count = 0;
        for (int i = 0; i < material.length(); i++) {
            if (statis[material.charAt(i)] >0){
                statis[material.charAt(i)] --;
                count++;
            }
        }
        return new ChangeNum(num-count,statis,count>0 ? true:false);
    }


    public static class ChangeNum{
        public int num ;//变化后的数量
        public int[] arr;//变化后的字符统计数据
        public boolean flag; //是否变化

        public ChangeNum(int num, int[] arr, boolean flag) {
            this.num = num;
            this.arr = arr;
            this.flag = flag;
        }
    }

    /**
     * 统计目标字符串中各个字符的数量
     * @param s
     * @return
     */
    private static int[] convertStr(String s) {

        int n = s.length();
        int[] arr = new int[256];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)] +=1;
        }
        return arr;
    }


}
