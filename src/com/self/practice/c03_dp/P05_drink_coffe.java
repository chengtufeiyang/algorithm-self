package com.self.practice.c03_dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P05_drink_coffe {

    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(len, max);
            int n = (int) (Math.random() * 7) + 1;
            int a = (int) (Math.random() * 7) + 1;
            int b = (int) (Math.random() * 100) *10+ 1;
            int ans1 = dp(arr, n, a, b);
            int ans2 = normal(arr, n, a, b);
//            int ans3 = minTime2(arr, n, a, b);

            if (ans1 != ans2 ) {
                printArray(arr);
                System.out.println("n : " + n);
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                System.out.println(ans1 + " , " + ans2 );
                System.out.println("===============");
                break;
            }
        }
        System.out.println("测试结束");
    }

    /**
     * 喝咖啡dp方法
     * @param arr
     * @param personNum
     * @param userMachTime
     * @param selfTime
     * @return
     */
    private static int dp(int[] arr, int personNum, int userMachTime, int selfTime) {
        if (null == arr || arr.length == 0 || userMachTime <= 0) return 0;
        // 生成每个人喝咖啡结束的最快时间
        int[] result = drinkTime(arr, personNum);
        System.out.println("dp=============================="+Arrays.toString(result));
        int N = result.length;  // 每个人喝完咖啡时间数组
        //机器可以使用最大时间,所有人都是用机器洗咖啡杯
        int maxMachineTime = 0;  // 统计出最大可能消耗时间
        for (int i = 0; i < N; i++) {
            maxMachineTime = Math.max(maxMachineTime,result[i])  + selfTime;
        }
        int[][] dp = new int[N+1][maxMachineTime +1];

        for (int rest = N-1; rest >=0; rest--) {
            for (int machineStart = 0; machineStart < (maxMachineTime + 1); machineStart++) {
                //选择机器洗
                int cleanMachie1= Math.max(result[rest],machineStart)  + userMachTime;
                if (cleanMachie1 > maxMachineTime) break;

                int machine = Math.max(cleanMachie1,
                        dp[rest+1][cleanMachie1]);

                // 选择挥发
                int cleanMachie2 = result[rest] + selfTime;
                int self = Math.max(cleanMachie2,
                        dp[rest+1][machineStart]);
                dp[rest][machineStart] = Math.min(machine,self);
            }
        }
        return dp[0][0];
    }

    public static int pick(int[][]  arr,int x,int y){
        if (x <0 || y < 0 || x >= arr.length || y >= arr[0].length) return -1;

        return arr[x][y];
    }



//    所有咖啡机变干净的最小时间（数组arr[i]---表示第i号咖啡机泡一杯咖啡的时间，N---表示N个人等着咖啡机泡咖啡，
//    只有一台洗咖啡机，a---咖啡机洗咖啡杯的时间，b---被子自己干的时间）

    public static int  normal(int[] arr, int n, int machineTime, int seflTime) {
        if (null == arr || arr.length == 0 || n <= 0) return 0;

        // 生成每个人喝咖啡结束的最快时间
        int[] result = drinkTime(arr, n);
        System.out.println("normal=============================="+Arrays.toString(result));
        return recusion(result, 0, 0,machineTime, seflTime);
    }


    private static class MachineSelf{
        public int currTime; // 当前位置时间

        public int workTime; //工作时间

        public MachineSelf(int currTime, int workTime) {
            this.currTime = currTime;
            this.workTime = workTime;
        }

        public int getCurrTime() {
            return currTime;
        }

        public void setCurrTime(int currTime) {
            this.currTime = currTime;
        }

        public int getWorkTime() {
            return workTime;
        }

        public void setWorkTime(int workTime) {
            this.workTime = workTime;
        }
    }

    private static int[] drinkTime(int[] arr, int n) {
        //构建小根堆
        Queue<MachineSelf> result = new PriorityQueue<MachineSelf>(
                new Comparator<MachineSelf>() {
                    @Override
                    public int compare(MachineSelf o1, MachineSelf o2) {
                        return (o1.currTime+o1.workTime) - (o2.currTime + o2.workTime);
                    }
                }
        );
        int[] resultArr = new int[n];  // 创建新数组存储结果
        for (int i = 0; i < arr.length; i++) {
            result.add(new MachineSelf(0,arr[i]));
        }

        for (int i = 0; i < n; i++) {
            MachineSelf m = result.poll();
            m.setCurrTime(m.currTime + m.workTime);
            resultArr[i] = m.getCurrTime();
            result.add(m);
        }
        return resultArr;
    }

    /**
     *
     * @param result   存储当前客人喝完一杯咖啡最短时间
     * @param rest         当前选择位置
     * @param machineTime   机器洗咖啡时间
     * @param seflTime      自然挥发干净时间
     * @return
     */
    private static int recusion(int[] result, int rest,int  machineStart, int machineTime, int seflTime) {

        if (rest >=result.length ) return 0;
        //选择机器洗
        int sefltTime1= Math.max(result[rest],machineStart)  + machineTime;
        int machine = Math.max(sefltTime1,recusion(result,rest+1,sefltTime1,machineTime,seflTime));

         // 选择挥发
        int sefltTime2 = result[rest] + seflTime;
        int self = Math.max(sefltTime2,recusion(result,rest+1,machineStart,machineTime,seflTime));
        return Math.min(machine,self);
    }









    // for test
    public static void printArray(int[] arr) {
        System.out.print("arr : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + ", ");
        }
        System.out.println();
    }

    // for test
    public static int[] randomArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }
}
