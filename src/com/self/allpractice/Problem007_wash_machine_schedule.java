package com.self.allpractice;

public class Problem007_wash_machine_schedule {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        int[] machines = {1, 0, 5};
        System.out.println(minSchedule(machines));
        System.out.println(minSchedule2(machines));
    }


    /**
     * 求每个位置的瓶颈，因此需要求取所有位置的最大瓶颈，以此找到最终结果
     * <p>
     * <p>
     * 数组中数组，代表当前洗衣机中衣服数量
     * 求取最小调度数量使得可以数量相同
     * 例如[1,0,5]表示有3个机器，每个机器上分别有1、0、5个物品，经过这些轮后:
     * 第一轮:1    0 <- 5 => 1 1 4 第二轮:1 <- 1 <- 4 => 2 1 3 第三轮:2    1 <- 3 => 2 2 2
     * 移动了3轮，每个机器上的物品相等，所以返回3
     * 例如[2,2,3]表示有3个机器，每个机器上分别有2、2、3个物品， 这些物品不管怎么移动，都不能使三个机器上物品数量相等，返回-1
     *
     * @param machines
     * @return
     */
    public static int minSchedule(int[] machines) {
        if (null == machines || machines.length == 0) return -1;
        if (machines.length == 1) return 0;
        int len = machines.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += machines[i];
        }
        if (sum % len != 0) return -1;  //无法平均分配

        int per = sum / len;  // 最终每个位置应该放置数量

        // 分为三个部分：前缀和、当前值、后缀和
        int[] pre = new int[len];
        pre[0] = machines[0];
        for (int i = 1; i < len; i++) { // 初始化前缀数组结果数据
            pre[i] = machines[i] + pre[i - 1];
        }
        int[] after = new int[len];
        after[len - 1] = machines[len - 1];
        for (int i = len - 2; i >= 0; i--) { // 初始化后缀数组结果数据
            after[i] = machines[i] + after[i + 1];
        }

        int min = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE; // 左侧累加和值
        int right = Integer.MIN_VALUE; // 右侧累加和值

        for (int i = 0; i < len; i++) { // 对当前位置左右两侧数据进行判断，并统计需要进行移动数据量
            left = i - 1 < 0 ? 0 : pre[i - 1] - i * per;
            right = i + 1 == len ? 0 : after[i + 1] - (len - i - 1) * per;

            if (left < 0 && right < 0) {
                min = Math.max(Math.abs(left + right), min);
            } else {
                min = Math.max(min, Math.max(Math.abs(left), Math.abs(right)));
            }
        }
        return min;
    }


    public static int minSchedule2(int[] machines) {
        if (null == machines || machines.length == 0) return -1;
        if (machines.length == 1) return 0;
        int len = machines.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += machines[i];
        }
        if (sum % len != 0) return -1;  //无法平均分配

        int per = sum / len;  // 最终每个位置应该放置数量

        // 分为三个部分：前缀和、当前值、后缀和
        int pre = 0;

        int min = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE; // 左侧累加和值
        int right = Integer.MIN_VALUE; // 右侧累加和值

        for (int i = 0; i < len; i++) { // 对当前位置左右两侧数据进行判断，并统计需要进行移动数据量
            left = pre - i * per;
            sum -= machines[i];
            right = sum - (len - i - 1) * per;

            if (left < 0 && right < 0) {
                min = Math.max(Math.abs(left + right), min);
            } else {
                min = Math.max(min, Math.max(Math.abs(left), Math.abs(right)));
            }
            pre += machines[i];
        }
        return min;
    }

}
