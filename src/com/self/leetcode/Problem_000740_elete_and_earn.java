package com.self.leetcode;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class Problem_000740_elete_and_earn {

    public static void main(String[] args) {
        Problem_000740_elete_and_earn test = new Problem_000740_elete_and_earn();

//        int[] nums = {3,4,2};
//        int[] nums = {2, 2, 3, 3, 3, 4};
//        int[] nums = {3,2};
//        int[] nums = {1,8,5,9,6,9,4,1,7,3,3,6,3,3,8,2,6,3,2,2,1,2,9,8,7,1,1,10,6,7,3,9,6,10,5,4,10,1,6,7,4,7,4,1,9,5,1,5,7,5};
//        int[] nums = {12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93};

//        int[] nums = {866,462,561,927,647,170,979,65,586,971,884,228,534,242,233,361,458,386,497,962,416,398,782,18,889,350,294,378,69,42,893,814,967,1,335,21,131,439,916,209,256,842,192,379,256,661,415,579,431,562,857,13,716,649,451,96,89,344,428,502,389,689,742,990,906,625,232,422,932,524,363,710,15,780,220,167,354,86,316,66,407,669,238,510,540,667,44,217,996,109,289,803,419,618,540,266,469,384,748,179,808,363,478,108,757,669,449,697,420,139,145,670,86,875,907,97,50,77,490,74,635,165,43,415,88,326,727,289,202,784,54,446,3,993,387,317,198,289,98,874,8,362,546,181,509,622,401,785,697,697,428,571,192,516,223,620,430,991,746,920,893,321,993,883,629,375,485,559,157,313,832,584,935,902,870,5,949,771,81,733,221,660,323,410,491,582,42,541,788,282,277,1000,292,654,100,474,247,308,170,619,28,509,872,870,122,71,438,348,405,119,965,798,530,982,338,964,633,52,767,215,116,246,392,744,627,16,876,340,992,15,807,974,1,749,789,123,380,58,973,749,4,999,746,564,874,567,913,903,751,599,204,178,541,285,521,81,59,17,778,374,9,437,633,638,91,32,704,73,60,529,648,844,879,472,918,841,452,277,963,4,92,855,399,190,593,424,252,576,281,18,705,663,408,937,51,320,415,458,943,107,16,441,851,1000,469,825,513,562,255,842,316,317,598,456,236,967,166,41,843,157,767,196,965,916,40,396,658,398,830,891,802,491,823,508,404,834,626,856,634,199,904,293,753,986,284,469,746,742,642,541,196,605,133,545,311,341,486,166,792,338,615,535,177,726,21,293,435,870,336,527,877,510,646,211,17,315,535,789,814,743,774,809,59,20,736,725,778,488,33,742,169,161,964,844,265,788,7,758,431,386,753,899,129,414,986,91,775,26,686,488,167,383,669,371,559,99,821,395,90,196,29,102,622,541,857,360,593,439,683,966,181,90,433,256,835,158,194,921,240,598,978,730,796,936,2,236,290,367,627,869,901,496,251,670,622,703,233,320,455,477,998,686,218,141,717,279,34,708,756,650,858,409,3,547,309,855,620,426,654,358,683,281,419,881,307,935,987,502,781,167,677,629,553,302,609,668,882,587,553,628,554,872,30,197,372,744,438,624,969,194,789,664,869,196,835,88,838,723,767,412,811,877,183,117,225,69,504,442,917,774,810,630,58,862,908,609,362,401,828,33,579,20,245,645,272,674,872,240,655,450,312,66,241,373,782,269,121,80,381,879,77,904,704,617,306,330,913,821,79,920,866,394,307,407,232,468,233,684,351,391,409,180,480,773,421,438,708,986,419,212,375,831,490,189,627,21,21,133,547,664,15,767,664,834,920,824,963,295,98,91,43,977,395,159,748,166,333,442,160,933,625,142,2,757,800,673,433,892,722,548,892,194,134,581,427,880,228,258,150,888,754,306,554,862,300,53,661,918,856,620,420,294,708,579,340,929,575,865,808,400,381,757,665,730,975,383,89,452,790,994,795,322,37,300,147,286,925,178,625,881,726,130,953,160,385,262,901,95,100,689,339,837,222,9,1000,94,6,30,585,448,886,723,46,342,506,563,498,105,214,715,804,790,883,697,413,496,329,830,385,24,549,277,603,489,95,267,891,138,603,476,529,122,673,787,900,84,993,470,100,686,204,916,142,626,865,254,67,30,182,285,312,236,163,586,992,390,593,289,85,83,677,100,783,953,469,234,349,971,182,280,493,30,886,326,34,881,135,431,849,818,167,335,95,751,430,143,270,731,246,4,392,167,714,191,749,623,76,260,552,768,61,649,483,467,910,725,286,342,756,123,727,956,355,289,420,249,491,523,801,622,62,937,658,357,100,441,36,115,147,513,234,471,896,763,429,206,140,859,507,297,411,885,797,192,724,403,4,775,220,421,719,404,475,27,68,989,459,899,344,651,876,50,431,109,51,607,949,508,187,143,993,805,985,266,51,816,975,85,882,685,861,992,879,495,661,654,314,669,447,23,393,309,735,516,561,954,992,290,332,949,92,868,704,449,717,404,906,623,307,354,555,158,544,505,393,559,241,362,958,441,654,591,690,399,854,85,464,427,419,137,200,439,643,102,306,809,340,144,504,404,889,732,324,258,749,350,77,434,370,770,680,543,505,28,860,808,11,156,688,51,370,4,857,149,223,538,332,79,882,713,432,979,541,977,429,258,671,508,138,98,584,259,800,629,821,198,94,276,301,165,410,851,284,826,144,509,90,11,968,442};

//        int[] nums = {4,1,7,3,3,3,3};

        int[] nums = {1,2,3,15,16,17,18};

//        System.out.println(test.deleteAndEarn(nums));
        System.out.println(test.deleteAndEarn2(nums));
//        System.out.println(test.deleteAndEarn3(nums)); // error
        System.out.println(test.deleteAndEarn4(nums));

//        List<Integer> temp = new ArrayList<>();
//        temp.add(0);
//        temp.add(1);
//        temp.add(3);
//        System.out.println(temp);
//        temp.remove(0);
//        System.out.println(temp);
//        temp.remove((Integer) 3);
//        System.out.println(temp);



//        List<Integer> list1 = new ArrayList<Integer>();
//        list1.add(1);
//        list1.add(6);
//        list1.add(4);
//        list1.add(2);
//        Integer[] t = new Integer[4];
//        list1.toArray(t);
//        System.out.println(Arrays.toString(t));



//        Set<Integer> set = new HashSet<>();
//        set.add(3);
//        set.add(1);
//        set.add(5);
//        set.add(4);
//        System.out.println(set);
//
//        Integer[] use = new Integer[set.size()];
//        set.toArray(use);
//        System.out.println(Arrays.toString(use));

    }


    // 1、循环选择某个可获取得分值a,同时删除a+1 和 a-1得分情况数据
    // 2、若仍有数据，进入循环1，无数据可选择结束循环
//1 <= nums.length <= 2 * 104
//            1 <= nums[i] <= 104

    //    https://leetcode-cn.com/problems/delete-and-earn/
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        Map<Integer, Integer> keyNum = new HashMap<>();//存储数值---数量
        List<Integer> keys = new ArrayList<>(); // 数值
        for (int i = 0; i < len; i++) {
            keyNum.put(nums[i], keyNum.getOrDefault(nums[i], 0) + 1);
            if (!keys.contains(nums[i])) {
                keys.add(nums[i]);
            }
        }
        return deleteAndEarn_recursion(keyNum,keys,0);
    }

//    int result = Integer.MIN_VALUE;
    private int deleteAndEarn_recursion(Map<Integer, Integer> keyNum, List<Integer> keys, int currVal) {
        if (keys.size() == 0 ) return currVal;

        int len = keys.size();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = keys.get(i); //获取此刻选择数值
            if (null != keyNum.get(temp) && keyNum.get(temp) > 0){//说明此数值仍未选择过，选择过数据直接赋值0

                int temp1 = temp - 1;
                int temp2 = temp + 1;
                int temp1Val = keyNum.getOrDefault(temp1,0);
                int temp2Val = keyNum.getOrDefault(temp2,0);
                int tempVal = keyNum.get(temp);
                keyNum.put(temp1,0);
                keyNum.put(temp2,0);
                keyNum.put(temp,0);

                result = Math.max(result,deleteAndEarn_recursion(keyNum,getNewKeys(keyNum,keys,temp),currVal + temp * tempVal));

                keyNum.put(temp1,temp1Val);
                keyNum.put(temp2,temp2Val);
                keyNum.put(temp,tempVal);
            }
        }
        return Math.max(currVal,result);
    }

    private List<Integer> getNewKeys(Map<Integer, Integer> keyNum, List<Integer> keys, int temp) {
        List<Integer> result = new ArrayList<>();

        int one = null == keyNum.get(temp) || keyNum.get(temp) == 0 ? temp : -1;
        int two = temp - 1 ;
        int three = temp + 1 ;

        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) != one && keys.get(i) != two && keys.get(i) != three){
                result.add(keys.get(i));
            }
        }
        return result;
    }


    /**
     * 递归
     * @param nums
     * @return
     */
    public int deleteAndEarn2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        Arrays.sort(nums); // 排序

        Map<Integer, Integer> keyNum = new HashMap<>();//存储数值---数量
        Map<Integer, Integer> keyIndex = new HashMap<>();//存储数值---初始下标
        for (int i = 0; i < len; i++) {
            keyNum.put(nums[i], keyNum.getOrDefault(nums[i], 0) + 1);
            if (!keyIndex.containsKey(nums[i])) keyIndex.put(nums[i],i);
        }


        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {

            for (int j = i; j <= len; j++) {
                dp[i][j] = -1;
            }
        }
        return deleteAndEarn2_recursion(keyNum,keyIndex,nums,0,len - 1,dp);

    }


    private int deleteAndEarn2_recursion(Map<Integer, Integer> keyNum, Map<Integer, Integer> keyIndex, int[] nums, int left,
                                         int right,int[][] dp) {
        if (left > right || right <0 || left >= nums.length) return 0;

        if (dp[left][right] != -1)   return    dp[left][right];

        int result = 0;
        int leftVal = 0;
        int rightVal = 0;
        for (int i = left; i <= right; ) {

            int currVal = nums[i];// 当前获取得分值
            int tempNum = keyNum.get(currVal); //当前得分值数量

            int leftIndex = keyIndex.get(currVal); // 当前数值最左侧坐标
            int rightIndex = leftIndex + (tempNum - 1); // 当前数值最右侧坐标

            int leftAfter =
                    leftIndex - 1 < left ? left - 1 :
                            (nums[leftIndex - 1] == currVal - 1 ? leftIndex - 1 - keyNum.get(nums[leftIndex - 1]) : leftIndex - 1); // 根据当前选择数值，推算其可达左侧最远坐标
            int rightAfter =
                    rightIndex + 1 > right ? right + 1 :
                            (nums[rightIndex + 1] == currVal + 1 ? rightIndex + 1 + keyNum.get(nums[rightIndex + 1]): rightIndex + 1 ); // 根据当前选择数值，推算其可达右侧最远坐标

            leftVal = deleteAndEarn2_recursion(keyNum,keyIndex,nums, left,leftAfter,dp); // 左侧部分可获取得分

            rightVal = deleteAndEarn2_recursion(keyNum,keyIndex,nums, rightAfter,right,dp); // 右侧部分可获取得分

            result = Math.max(result, leftVal + rightVal + currVal * tempNum);

            i += tempNum;

        }
        dp[left][right] = result;
        return dp[left][right];
    }


    /**
     * dp
     * @param nums
     * @return
     */
    public int deleteAndEarn4(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        Map<Integer, Integer> keyNum = new HashMap<>();//存储数值---数量
        Set<Integer> keys = new HashSet<>(); // 数值
        for (int i = 0; i < len; i++) {
            keyNum.put(nums[i], keyNum.getOrDefault(nums[i], 0) + 1);
            keys.add(nums[i]);
        }

        Integer[] use = new Integer[keys.size()];
        keys.toArray(use);// 数值不重复，且从小到大
        Arrays.sort(use); // 排序

//        System.out.println("use数组打印："+ Arrays.toString(use));
//        System.out.println("数量统计map打印："+ keyNum);

        int newLen = use.length;
        int[] dp = new int[newLen];
        // 下半区域不用填
        // 一个位置填写
       dp[0] = use[0] * keyNum.get(use[0]);
       dp[1] = Math.abs(use[0] - use[1]) == 1 ?
               Math.max(use[0] * keyNum.get(use[0]),use[1] * keyNum.get(use[1])) :
               use[0] * keyNum.get(use[0]) + use[1] * keyNum.get(use[1]);;

        for (int i = 2; i < newLen; i++) {
            if (dp[i - 1] == dp[i - 2]){
                dp[i] = dp[i - 1] + use[i] * keyNum.get(use[i]);
            }else {
                if (Math.abs(use[i] - use[i - 1]) == 1){
                    dp[i] = Math.max(dp[i - 1],dp[i - 2] + use[i] * keyNum.get(use[i]));
                }else {
                    dp[i] = dp[i - 1] + use[i] * keyNum.get(use[i]);
                }
            }
        }

//        System.out.println("数组打印："+Arrays.toString(dp));

        return dp[newLen - 1];
    }

    // 官方解法---核心---当数据按照+1递增，若间隔>1,则不需讨论，直接取值，
    // 若间隔==1 ，则需讨论取值方式，取中间一个，还是两侧两个的情况

}
