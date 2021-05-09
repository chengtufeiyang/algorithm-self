package com.self.leetcode;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_001723_find_minimum_time_to_finish_all_jobs {

    public static void main(String[] args) {
        Problem_001723_find_minimum_time_to_finish_all_jobs test = new Problem_001723_find_minimum_time_to_finish_all_jobs();

//        int[] jobs = {3, 2, 3};        int k = 3;
//        int[] jobs = {1,2,4,7,8};int k = 2;
        int[] jobs = {1867731,4771762,2710043,7567506,5011359};        int k =2;
//        int[] jobs = {18,47,27,75,50};        int k =2;
//        int[] jobs = {2,5,6,8,9};        int k = 2;

//        int[] jobs ={2,9,17,6}; int k =2;
//        int[] jobs = {254,256,256,254,251,256,254,253,255,251,251,255};        int k = 10;
//        int[] jobs = {9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202};        int k = 9;
        System.out.println(test.minimumTimeRequired(jobs, k));
        System.out.println(test.minimumTimeRequired2(jobs, k));
//
//
//        Arrays.sort(jobs);
//        System.out.println(test.closeVal(jobs,17));


//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(1,1);
//        System.out.println(map);
//        map.remove(1);
//        System.out.println(map);
    }
//    You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.
//
//    There are k workers that you can assign jobs to.
//    Each job should be assigned to exactly one worker.
//    The working time of a worker is the sum of the time it takes to complete all jobs assigned to them.
//    Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.
//
//    Return the minimum possible maximum working time of any assignment.
//
//             
//
//    Example 1:
//
//    Input: jobs = [3,2,3], k = 3
//    Output: 3
//    Explanation: By assigning each person one job, the maximum time is 3.
//    Example 2:
//
//    Input: jobs = [1,2,4,7,8], k = 2
//    Output: 11
//    Explanation: Assign the jobs the following way:
//    Worker 1: 1, 2, 8 (working time = 1 + 2 + 8 = 11)
//    Worker 2: 4, 7 (working time = 4 + 7 = 11)
//    The maximum working time is 11.
//             
//
//    Constraints:
//
//            1 <= k <= jobs.length <= 12
//            1 <= jobs[i] <= 107
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    int result = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int len = jobs.length;

        if (len == 1) return jobs[0];
        if (k == 1) return Arrays.stream(jobs).sum();

        int[] sum = new int[k]; // 每个工人总的工作时长
        minimumTimeRequired_recursion(0,jobs,sum,0);
        return result;
    }

    private void minimumTimeRequired_recursion(int currIndex,int[] jobs, int[] sum, int currVal) {
        if (currVal >= result) return;
        if (currIndex == jobs.length){
            result = currVal; //满足条件更新最小值情况
            return;
        }

        int len = sum.length;

        for (int i = 0; i < len; i++) {
            sum[i] += jobs[currIndex];
            minimumTimeRequired_recursion(currIndex + 1, jobs,sum,Math.max(sum[i],currVal));
            sum[i] -= jobs[currIndex];
        }
    }



    public int minimumTimeRequired2(int[] jobs, int k) {
        int len = jobs.length;

        if (len == 1) return jobs[0];
        if (k == 1) return Arrays.stream(jobs).sum();

        int[] sum = new int[k]; // 每个工人总的工作时长
        minimumTimeRequired_recursion2(0,0,0,jobs,sum);
        return result;
    }

    private void minimumTimeRequired_recursion2(int currIndex, int currVal,int used,int[] jobs, int[] sum) {
        if (currVal >= result) return;
        if (currIndex == jobs.length){
            result = currVal; //满足条件更新最小值情况
            return;
        }

        int len = sum.length;

        if (used < len){ // 当前位置仍未空闲状态

            sum[used] += jobs[currIndex];
            minimumTimeRequired_recursion2(currIndex + 1,Math.max(currVal,sum[used]),used + 1,jobs,sum);
            sum[used] -= jobs[currIndex];
        }



        for (int i = 0; i < used; i++) {
            sum[i] += jobs[currIndex];
            minimumTimeRequired_recursion2(currIndex + 1,Math.max(sum[i],currVal),used, jobs,sum);
            sum[i] -= jobs[currIndex];
        }
    }


}
