package com.self.allpractice;

import sun.security.krb5.internal.PAData;

import java.util.Arrays;
import java.util.Comparator;

public class Problem011_arr_number_pair_k {


    public static void main(String[] args) {
        Problem011_arr_number_pair_k test = new Problem011_arr_number_pair_k();
        int[] arr = {6,1,4,5,2,3};
        System.out.println(sortSmallK(arr));
    }


    //  bfprt   随机快排

    /**
     * 数组arr,数值k,返回数组所有数值对第k小数（例如：数组arr:[1,2],数值对：{(1,1),(1,2),(2,1),(2,2)}）
     * @param arr
     * @return
     */
    public static int[] orderKPair(int[] arr) {



        return null;
    }


    // TODO: 4/15/2021  随机快排返回数组中第k小的数，（第k大的数同理）  or bfprt
    // 随机快排返回数组中第k小的数，（第k大的数同理）
    public static int sortSmallK(int[] arr){



        return 0;
    }



    private static class Pair{
        private int x ;
        private int y ;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class MyCom implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) { // 当 x （小 --- 大） ，当x相等时，y(小 --- 大)
            return o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x;
        }
    }

    /**
     * 暴力解
     * @param arr
     * @return
     */
    public static int[] orderKPair1(int[] arr,int k ) {
        if (null == arr || arr.length == 0) return null;
        int len = arr.length;
        if (k > len * len) return null;
        Pair[] pairs = new Pair[len * len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                pairs[index++] = new Pair(arr[i],arr[j]);
            }
        }
        Arrays.sort(pairs,new MyCom());
        return new int[]{pairs[k - 1].x,pairs[k - 1].y};
    }


    /**
     * 根据顺序排序求解
     * @param arr
     * @return
     */
    public static int[] orderKPair2(int[] arr,int k ) {
        if (null == arr || arr.length == 0) return null;
        int len = arr.length;
        Arrays.sort(arr);  // 数组排序
        int tempNum = k / len;
        int preNum =tempNum + (k  % len == 0 ? 0 :  1); //  到达k之前需要经历 的数字数量
        //  每个
        int small = 0; // 统计小于
        int same = 0;
        for (int i = 0; i < preNum; i++) {
            if (arr[i] < arr[preNum]){
                small++;
            }else if (arr[i] == arr[preNum]){
                same++;
            }else {
                break;
            }
        }

        return new int[]{arr[preNum - 1],arr[(k - small * len ) / small]};
    }


}
