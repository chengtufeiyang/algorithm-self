package com.self.leetcode;

import com.wz.array.GenerateArray;

import java.util.*;

public class Problem_000403_frog_jump {


    public static void main(String[] args) {
        Problem_000403_frog_jump tes = new Problem_000403_frog_jump();
//        int[] stones = {0,1,2,3,4,8,9,11};
//        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
//        int[] stones = {0,1,3,6};
//        int[] stones = {0,1,2,3,4,8,9,11};
        int[] stones = {0,2,4};
        System.out.println(tes.canCross(stones));
        System.out.println(tes.canCross2(stones));
        System.out.println(tes.canCross_dp(stones));
        System.out.println(tes.canCross_dp2(stones));

//        Map<Integer, Boolean>[] maps = new HashMap[10];
//        Map<Integer, Boolean> map = new HashMap<>();
////        map.put(1, true);
//        maps[0] = map;
//        System.out.println(Arrays.toString(maps));
//        System.out.println(null == maps[0]);
//        System.out.println(null == maps[1]);
//        Map<Integer, Boolean> mapss = new HashMap<>();
//        System.out.println(mapss.keySet().size() == 0);

//        System.out.println(tes.satisfy(stones,1,2));
    }

//    https://leetcode-cn.com/problems/frog-jump/

//    示例 1：
//    输入：stones = [0,1,3,5,6,8,12,17]
//    输出：true
//    解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子,
//    接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子,
//    最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
//    示例 2：
//    输入：stones = [0,1,2,3,4,8,9,11]
//    输出：false
//    解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
//    提示：
//            2 <= stones.length <= 2000
//            0 <= stones[i] <= 231 - 1
//    stones[0] == 0
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/frog-jump
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public boolean canCross(int[] stones) {

        // 默认当前第一步可选择挑选步骤范围（-1，0 ，1） ，因此只能是1
        return canCross_recursion(stones, 0, 0, stones.length - 1);
    }

    private boolean canCross_recursion(int[] stones, int currIndex, int preStep, int maxIndex) {
        if (currIndex == stones.length) return false;
        if (
                (stones[currIndex] + (preStep - 1) == stones[maxIndex]) ||
                        (stones[currIndex] + (preStep) == stones[maxIndex]) ||
                        (stones[currIndex] + (preStep + 1) == stones[maxIndex])
        ) return true;


//        boolean one = canCross_recursion(stones,currIndex)
        boolean one = false; // 变化减一数据
        boolean two = false;// 不变
        boolean three = false; // 变化加1数据

        int oneVal = satisfy(stones, currIndex, preStep - 1);
        if (oneVal != -1) {
            one = canCross_recursion(stones, oneVal, preStep - 1, maxIndex);
        }
        int twoVal = satisfy(stones, currIndex, preStep);
        if (twoVal != -1) {
            two = canCross_recursion(stones, twoVal, preStep, maxIndex);
        }
        int threeVal = satisfy(stones, currIndex, preStep + 1);
        if (threeVal != -1) {
            three = canCross_recursion(stones, threeVal, preStep + 1, maxIndex);
        }
        return one || two || three ? true : false;
    }

    /**
     * @param stones
     * @param currIndex 当前位置坐标
     * @param num
     * @return
     */
    private int satisfy(int[] stones, int currIndex, int num) {
        if (num <= 0) return -1;
        int com = stones[currIndex] + num;
        for (int i = currIndex + 1; i < stones.length; i++) {
            if (stones[i] == com) return i;
            if (stones[i] > com) return -1;
        }
        return -1;
    }


    public boolean canCross2(int[] stones) {
        Map<String, Boolean> map = new HashMap<>();
        // 默认当前第一步可选择挑选步骤范围（-1，0 ，1） ，因此只能是1
        return canCross_recursion2(stones, 0, 0, stones.length - 1, map);
    }

    private boolean canCross_recursion2(int[] stones, int currIndex, int preStep, int maxIndex, Map<String, Boolean> map) {
        if (currIndex == stones.length) return false;
        if (
                (stones[currIndex] + (preStep - 1) == stones[maxIndex]) ||
                        (stones[currIndex] + (preStep) == stones[maxIndex]) ||
                        (stones[currIndex] + (preStep + 1) == stones[maxIndex])
        ) return true;
        String str = currIndex + "-" + preStep;
        if (null != map.get(str)) {
            return map.get(str);
        }

//        boolean one = canCross_recursion(stones,currIndex)
        boolean one = false; // 变化减一数据
        boolean two = false;// 不变
        boolean three = false; // 变化加1数据

        int oneVal = satisfy(stones, currIndex, preStep - 1);
        if (oneVal != -1) {
            one = canCross_recursion2(stones, oneVal, preStep - 1, maxIndex, map);
        }
        int twoVal = satisfy(stones, currIndex, preStep);
        if (twoVal != -1) {
            two = canCross_recursion2(stones, twoVal, preStep, maxIndex, map);
        }
        int threeVal = satisfy(stones, currIndex, preStep + 1);
        if (threeVal != -1) {
            three = canCross_recursion2(stones, threeVal, preStep + 1, maxIndex, map);
        }
        map.put(str, one || two || three ? true : false);

        return map.get(str);
    }

    public boolean canCross_dp(int[] stones) {

        int len = stones.length; // 石头数组长度
        Map<Integer,Integer> valKey = new HashMap<>();
        for (int i = 0; i < len; i++) { // 初始化数组值与下标之间的关系
            valKey.put(stones[i],i);
        }

        Map<Integer, Boolean>[] dp = new HashMap[len]; // 设计特殊map集合数组结构，map中存储，key---上一步走的单位，value---true
        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap<>();
        }
        dp[0].put(0, true); // 默认处在第一个石块上，，可以认为上一步走了0个单位，即到当前坐标（0）位置
        // 上一步走了1个单位，到当前坐标（1）位置

        dp[1].put(1,stones[1] == 1 ? true : false);// 因为第一步的特性，所有第二步的选择范围（-1，0 ，1） ，根据实际情况只能是走了1
        if (!dp[1].get(1)) return false;
         canCross_dp_recursion(dp,stones,1,1,valKey); // 列出所有可能位置，最后判断是否达到最终位置

        return dp[len - 1].keySet().size() == 0 ? false : dp[len - 1].values().contains(true);
    }

    //  默认preStep一定是> 0的数字
    private void canCross_dp_recursion(Map<Integer, Boolean>[] dp,int[] stones, int currIndex, int preStep,Map<Integer,Integer> valKey) {
        if (currIndex == dp.length - 1 ) return;
        //  三个选择 -1  0   +1
        if (preStep - 1 > 0){
            int oneVal = stones[currIndex] + preStep - 1; // 可前进步数，需用此只查看预处理map集合中是否存在此key值
            if (null != valKey.get(oneVal) && null == dp[valKey.get(oneVal)].get(preStep - 1) ){  // preStep为上一步走的步数
                dp[valKey.get(oneVal)].put(preStep - 1,true);
                canCross_dp_recursion(dp,stones,valKey.get(oneVal),preStep - 1,valKey);
            }
        }

        int twoVal = stones[currIndex] + preStep; // 可前进步数
        if (null != valKey.get(twoVal) && null == dp[valKey.get(twoVal)].get(preStep) ){
            dp[valKey.get(twoVal)].put(preStep,true);
            canCross_dp_recursion(dp,stones,valKey.get(twoVal),preStep ,valKey);
        }

        int threeVal = stones[currIndex] + preStep + 1; // 可前进步数
        if (null != valKey.get(threeVal) && null == dp[valKey.get(threeVal)].get(preStep + 1)){
            dp[valKey.get(threeVal)].put(preStep + 1 ,true);
            canCross_dp_recursion(dp,stones,valKey.get(threeVal),preStep + 1,valKey);
        }
    }






    public boolean canCross_dp2(int[] stones) {


        int len = stones.length; // 石头数组长度
        Map<Integer,Integer> valKey = new HashMap<>();
        for (int i = 0; i < len; i++) { // 初始化数组值与下标之间的关系
            valKey.put(stones[i],i);
        }

        Set<Integer>[] dp = new HashSet[len]; // 设计特殊map集合数组结构，map中存储，key---上一步走的单位，value---true
        for (int i = 0; i < len; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0); // 默认处在第一个石块上，，可以认为上一步走了0个单位，即到当前坐标（0）位置
        // 上一步走了1个单位，到当前坐标（1）位置
        if (stones[1] == 1) {// 因为第一步的特性，所有第二步的选择范围（-1，0 ，1） ，根据实际情况只能是走了1
            dp[1].add(1);
        }else {
            return false;
        }
        canCross_dp_recursion2(dp,stones,1,1,valKey); // 列出所有可能位置，最后判断是否达到最终位置

        return dp[len - 1].size() == 0 ? false : true;
    }

    //  默认preStep一定是> 0的数字
    private void canCross_dp_recursion2(Set<Integer>[] dp,int[] stones, int currIndex, int preStep,Map<Integer,Integer> valKey) {
        if (currIndex == dp.length - 1 ) return;
        //  三个选择 -1  0   +1
        if (preStep - 1 > 0){
            int oneVal = stones[currIndex] + preStep - 1; // 可前进步数，需用此只查看预处理map集合中是否存在此key值
            if (null != valKey.get(oneVal) && !dp[valKey.get(oneVal)].contains(preStep - 1) ){  // preStep为上一步走的步数
                dp[valKey.get(oneVal)].add(preStep - 1);
                canCross_dp_recursion2(dp,stones,valKey.get(oneVal),preStep - 1,valKey);
            }
        }

        int twoVal = stones[currIndex] + preStep; // 可前进步数
        if (null != valKey.get(twoVal) && !dp[valKey.get(twoVal)].contains(preStep) ){
            dp[valKey.get(twoVal)].add(preStep);
            canCross_dp_recursion2(dp,stones,valKey.get(twoVal),preStep ,valKey);
        }

        int threeVal = stones[currIndex] + preStep + 1; // 可前进步数
        if (null != valKey.get(threeVal) && !dp[valKey.get(threeVal)].contains(preStep + 1)){
            dp[valKey.get(threeVal)].add(preStep + 1 );
            canCross_dp_recursion2(dp,stones,valKey.get(threeVal),preStep + 1,valKey);
        }
    }

}
