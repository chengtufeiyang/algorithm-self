package com.self.allpractice;



import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem012_max_money_job {

    public static void main(String[] args) {
        Problem012_max_money_job job = new Problem012_max_money_job();
        Job[] jobarr = {new Job(1,2),new Job(2,3),
            new Job(3,9),new Job(8,5),
            new Job(3,5),new Job(4,7)};
        int[] arr = {1,2,3,5,7};
        int[] result = maxMoney(jobarr,arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }



    static class Job {

        public int hard; // 该工作的难度
        public int money;// 该工作的报酬

        public Job( int hard,int money) {
            this.hard = hard;
            this.money = money;
        }
    }

    private static class MyCom implements Comparator<Job>{
        @Override
        public int compare(Job o1, Job o2) { // 首先按照难度从小到大排序，其次相同难度情况下按照报酬从大到小排序
            return o1.hard != o2.hard ? o1.hard - o2.hard : o2.money - o1.money;
        }
    }

    /**
     * 每种工作有难度和报酬，规定如下
     * class Job {
     * public int money;// 该工作的报酬
     * public int hard; // 该工作的难度
     * }
     * 给定一个Job类型的数组jobarr，表示所有岗位，每个岗位都可以提供任意份工作
     * 选工作的标准是在难度不超过自身能力值的情况下，选择报酬最高的岗位
     * 给定一个int类型的数组arr，表示所有人的能力
     * 返回int类型的数组，表示每个人按照标准选工作后所能获得的最高报酬
     *
     * @param jobarr
     * @param arr
     * @return
     */
    public static int[] maxMoney(Job[] jobarr, int[] arr) {
        if (null == jobarr || null == arr || jobarr.length == 0 || arr.length == 0) return null;
        int len = jobarr.length;

        Arrays.sort(jobarr,new MyCom());  // 数组排序

        Map<Integer,Integer> map = new HashMap<>();
        int index = jobarr[0].hard;  // 当前难度
        int indexVal = jobarr[0].money; // 当前难度代表金额
        map.put(index,indexVal); // 初始位置
        for (int i = 1; i < len; i++) {

            int temp_hard = jobarr[i].hard;
            if (temp_hard == index) continue;//难度相同情况下，直接略过
            int temp_money = jobarr[i].money;
            index = temp_hard;
            indexVal = Math.max(indexVal,temp_money);
            map.put(index,indexVal);
        }
        // TODO: 4/15/2021 待使用bfprt或者快排找最靠近某个数字方式进行算法优化 
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp_hard = arr[i];
            for (int j = temp_hard; j >= 0; j--) {
                if (null != map.get(j)){
                    result[i] = map.get(j);
                    break;
                }
            }
        }
        return result;
    }
}
