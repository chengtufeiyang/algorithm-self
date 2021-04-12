package com.self.allpractice;

public class Problem007_wash_machine_schedule {

    public static void main(String[] args) {

    }


    /**
     * 数组中数组，代表当前洗衣机中衣服数量
     * 求取最小调度数量使得可以数量相同
     *  例如[1,0,5]表示有3个机器，每个机器上分别有1、0、5个物品，经过这些轮后:
     *   第一轮:1    0 <- 5 => 1 1 4 第二轮:1 <- 1 <- 4 => 2 1 3 第三轮:2    1 <- 3 => 2 2 2
     *   移动了3轮，每个机器上的物品相等，所以返回3
     *   例如[2,2,3]表示有3个机器，每个机器上分别有2、2、3个物品， 这些物品不管怎么移动，都不能使三个机器上物品数量相等，返回-1
     * @param arr
     * @return
     */
    public static int minSchedule(int[] arr){
        if (null == arr || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        if (sum % len != 0) return -1;  //无法平均分配

        int per = sum / len;  // 最终每个位置应该放置数量

        // 分为三个部分：前缀和、当前值、后缀和
        int[] pre = new int[len];
        pre[0] = arr[0];
        for (int i = 1; i < len; i++) { // 初始化前缀数组结果数据
            pre[i] += pre[i - 1];
        }
        int[] after = new int[len];
        after[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) { // 初始化后缀数组结果数据
            after[i] += after[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE; // 左侧累加和值
        int right = Integer.MAX_VALUE; // 右侧累加和值
        // 当前位置为0的情况结果
        right = after[1];
        min = right;
        // 当前位置为最大位置的结果
        left = pre[len - 2];
        min = Math.min(min, left);

        for (int i = 1; i < len - 1; i++) { // 对当前位置左右两侧数据进行判断，并统计需要进行移动数据量
            left = pre[i - 1];
            right = after[i + 1];

            if (left < 0 && right < 0){
                min = Math.min(Math.abs(left + right),min);
            }else {
                int tempMax = Math.max(Math.abs(left),Math.abs(right));  // 获取左右两侧绝对值最大值
                min = Math.min(min,tempMax );

            }
        }
        return min;
    }



}
