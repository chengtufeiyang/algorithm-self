package com.self.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_000135_candy {

    public static void main(String[] args) {
        Problem_000135_candy test = new Problem_000135_candy();

        int[] ratings = {1,0,2};    // 5
//        int[] ratings = {1,2,2};  // 4
//        int[] ratings = {1,2,2,3,4,2};   // 10
//        int[] ratings = {1,6,6,5,4,3,2};   // 18
//int[] ratings = {1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1,1,6,6,5,4,3,2,5,6,7,8,9};  // 101
//int[] ratings = {1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1,1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1,1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1,1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1};
        // 超时了
        // [1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1,1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1,1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1,1,6,6,5,4,3,2,5,6,7,8,9,12,3,5,8,6,5,3,1]

//        int[] ratings = {29,51,87,87,72,12};

//        System.out.println(test.candy(ratings));
        System.out.println(test.candy2(ratings));
        System.out.println(test.candy3(ratings));
    }

//    Each child must have at least one candy.
//    Children with a higher rating get more candies than their neighbors.
//    Return the minimum number of candies you need to have to distribute the candies to the children.
//
// 
//
//    Example 1:
//
//    Input: ratings = [1,0,2]
//    Output: 5
//    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
//    Example 2:
//
//    Input: ratings = [1,2,2]
//    Output: 4
//    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//    The third child gets 1 candy because it satisfies the above two conditions.
//             
//
//    Constraints:
//
//    n == ratings.length
//1 <= n <= 2 * 104
//            0 <= ratings[i] <= 2 * 104
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/candy
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 1) return 1;// 如果只有一个人给一个糖果即可
        //  默认认为最小排名位置的糖果一定是最小的1
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < len; i++) {  // 普通循环获取最小值以及其坐标
            if (ratings[i] < minVal){
                minVal = ratings[i];
                minIndex = i;
            }
        }

        // 预处理数组，获取当前位置递减最大范围
        preSmall = preArrayRight(ratings);
        preBig = preArrayLeft(ratings);

        int init = 1;

        return candy_recursion_big(ratings,0,minIndex - 1,init) + init +
               candy_recursion_small(ratings,minIndex + 1,len - 1,init);
    }

    int[] preBig;
    private int[] preArrayLeft(int[] ratings) {

        int len = ratings.length;
        int[] result = new int[len];
        result[0] = 0;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]){
                result[i] = result[i - 1];
            }else {
                result[i] = i;
            }
        }
        return result;
    }

    int[] preSmall;
    //  预处理数组，获取当前位置递减最大范围
    private int[] preArrayRight(int[] ratings) {
        int len = ratings.length;
        int[] result = new int[len];
        result[len - 1] = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]){
                result[i] = result[i + 1];
            }else {
                result[i] = i;
            }
        }
        return result;
    }


            //  left++
    private int candy_recursion_small(int[] ratings, int left, int right, int preVal) {
        if (left > right) return 0; //越界，无意义，无需糖果，默认返回0
        if(left == right){
                return ratings[right] <= ratings[left - 1] ? 1 : preVal + 1;
        }

        // preR   currR  aftR                     candy
        //  currR > preR && currR > aftR         min(preVal+ 1 ,index - currIndex)  <  < (需要一个预处理数组，获取其右侧小于其值的最近位置坐标index  (index - currIndex))
        //  currR > preR && currR <= aftR        preVal + 1
        //  currR <= preR && currR > aftR        (index - currIndex) ~ preVal     需要预处理数组
        //  currR <= preR && currR <= aftR        1


        //分析 left < right 情况
        int preR = ratings[left - 1];
        int currR = ratings[left];
        int aftR = ratings[left + 1];
        if (currR > preR && currR > aftR){
            int temp = Math.max(preVal+ 1 ,preSmall[left] - left + 1);
            return candy_recursion_small(ratings,left + 1,right,temp) + temp;

        }else if (currR > preR && currR <= aftR){
            return candy_recursion_small(ratings, left + 1, right, preVal + 1) + preVal + 1;
        }else if ( currR <= preR && currR > aftR){
            int temp = preSmall[left] - left + 1;
            int tempVal = Integer.MAX_VALUE;
            for (int i = temp; i <= preR; i++) {
                tempVal = Math.min(tempVal,candy_recursion_small(ratings,left + 1 ,right,i) + i);
            }

            return tempVal;
        }else { // (currR <= preR && currR <= aftR)
            return candy_recursion_small(ratings,left + 1 ,right,1) + 1;
        }
    }

    // 从右向左讨论结果  right--
    private int candy_recursion_big(int[] ratings, int left, int right, int preVal) {
        if (left > right) return 0;
        if (left == right) return ratings[left] <= ratings[left + 1] ? 1 : preVal + 1;


        //分析 left < right 情况
        int preR = ratings[right + 1];
        int currR = ratings[right];
        int aftR = ratings[right - 1];
        if (currR > preR && currR > aftR){
            int temp = Math.max(preVal+ 1 ,right - preBig[right] + 1);
            return candy_recursion_big(ratings,left,right - 1,temp) + temp;

        }else if (currR > preR && currR <= aftR){
            return candy_recursion_big(ratings, left, right -1, preVal + 1) + preVal + 1;
        }else if ( currR <= preR && currR > aftR){
            int temp =left - preSmall[left] + 1;
            int tempVal = Integer.MAX_VALUE;
            for (int i = temp; i <= preR; i++) {
                tempVal = Math.min(tempVal,candy_recursion_small(ratings,left ,right - 1,i) + i);
            }
            return tempVal;
        }else { // (currR <= preR && currR <= aftR)
            return candy_recursion_big(ratings,left ,right - 1,1) + 1;
        }
    }



    public int candy2(int[] ratings) {
        int len = ratings.length;
        if (len == 1) return 1;// 如果只有一个人给一个糖果即可
        //  默认认为最小排名位置的糖果一定是最小的1
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < len; i++) {  // 普通循环获取最小值以及其坐标
            if (ratings[i] < minVal){
                minVal = ratings[i];
                minIndex = i;
            }
        }

        // 预处理数组，获取当前位置递减最大范围
        preSmall = preArrayRight(ratings);
        preBig = preArrayLeft(ratings);


        int init = 1;
        int preR  = -1;
        int currR = -1;
        int aftR  = -1;
        int preVal = 1;

        if (len - minIndex - 1 > 0){
            for (int i = minIndex + 1; i < len - 1; i++) {
                //分析 left < right 情况
                preR  = ratings[i - 1];
                currR = ratings[i];
                aftR  = ratings[i + 1];
                if (currR > preR && currR > aftR){
                    int temp = Math.max(preVal+ 1 ,preSmall[i] - i + 1);
                    init += temp;
                    preVal = temp;

                }else if (currR > preR && currR <= aftR){
                    init += preVal + 1;
                    preVal = preVal + 1;
                }else if ( currR <= preR && currR > aftR){
                    int temp = preSmall[i] - i + 1;
                    init += temp;
                    preVal = temp;
                }else { // (currR <= preR && currR <= aftR)
                    init += 1;
                    preVal = 1;
                }
            }

            if (ratings[len - 1] <= ratings[len - 2]){
                init += 1;
            }else {
                init += preVal +1;
            }
        }


        preVal = 1;
        if (minIndex - 1 >= 0){
            for (int i = minIndex - 1; i > 0 && i - 1 >= 0; i--) {
                preR  = ratings[i + 1];
                currR = ratings[i];
                aftR  = ratings[i - 1];

                if (currR > preR && currR > aftR){
                    int temp = Math.max(preVal+ 1 ,i - preBig[i] + 1);
                    init += temp;
                    preVal = temp;
                }else if (currR > preR && currR <= aftR){
                    init += preVal + 1;
                    preVal = preVal + 1;
                }else if ( currR <= preR && currR > aftR){
                    int temp =i - preBig[i] + 1;
                    init += temp;
                    preVal = temp;

                }else { // (currR <= preR && currR <= aftR)
                    init += 1;
                    preVal = 1;
                }
            }

            if (ratings[0] <= ratings[1]){
                init += 1;
            }else {
                init += preVal + 1;
            }
        }

        return init;
    }


    public int candy3(int[] ratings) {
        int len = ratings.length;
        if (len == 1) return 1;// 如果只有一个人给一个糖果即可


        // 预处理数组，获取当前位置递减最大范围
        preSmall = preArrayRight(ratings);

        int preR  = -1;
        int currR = -1;
        int aftR  = -1;
        int preVal = 1;

       int init = preSmall[0] + 1;

        for (int i = 1; i < len - 1; i++) {
            //分析 left < right 情况
            preR  = ratings[i - 1];
            currR = ratings[i];
            aftR  = ratings[i + 1];
            if (currR > preR && currR > aftR){
                int temp = Math.max(preVal+ 1 ,preSmall[i] - i + 1);
                init += temp;
                preVal = temp;

            }else if (currR > preR && currR <= aftR){
                init += preVal + 1;
                preVal = preVal + 1;
            }else if ( currR <= preR && currR > aftR){
                int temp = preSmall[i] - i + 1;
                init += temp;
                preVal = temp;
            }else { // (currR <= preR && currR <= aftR)
                init += 1;
                preVal = 1;
            }
        }

        if (ratings[len - 1] <= ratings[len - 2]){
            init += 1;
        }else {
            init += preVal +1;
        }

        return init;
    }




}
