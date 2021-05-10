package com.self.company.accenture;

import java.awt.event.ItemEvent;
import java.util.*;

public class Problem_0002_distribution_people {

    public static void main(String[] args) {
        int[] people = {1,2,3,3,2};
        int n = 4;
        System.out.println(Arrays.toString(distribution(people,n)));
    }

//    有 m 个小组，每个组分别有一定的人数。现在要把这 m 个小组划分为 N 个大组，但是小组不能切分，也就是说要作为一个单位分配给大组。要保证每个大组的人数尽量均匀。
//
//    最后将每个大组按人数从大到小输出。
//
//    例如：
//    输入：
//            1,2,3,3,2
//            4
//    输出：
//            3,3,3,2
//
//    作者：jojolin
//    链接：https://leetcode-cn.com/circle/discuss/l8Hse4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 必须连续情况，  使用二分法
// 可以不连续，递归 or dp
    public static int[] distribution(int[] people,int n){
        if (null == people || people.length == 0) return new int[]{};
        int len = people.length;
        if (n > len) return new int[]{};
        int sum = Arrays.stream(people).sum();
        int avg = sum / n + (sum % n == 0 ? 0 : 1);


        int left = avg;
        int right = sum;

        int resultVal = Integer.MAX_VALUE;

        while (left < right){

            int mid = left + (right - left) / 2;

            int currVal = mid;
            int currNum = n;

            for (int i = 0; i < len; i++) {
                if (currVal >= people[i]){
                    currVal -= people[i];
                }else {
                    currVal = mid;
                    currNum--;
                }
            }

            if (currNum >= 1) {
                resultVal = Math.min(resultVal, mid);
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        List<Integer> result =new ArrayList<>();
        int temp = resultVal;
        for (int i = 0; i < len; i++) {

            if (temp >= people[i] ){
                temp -= people[i];
            }else {
                result.add(resultVal - temp);
                temp = resultVal - people[i];
            }
        }

        result.add(resultVal - temp);

        return result.stream().mapToInt(Integer::intValue).toArray(); // java 流处理将list集合转为数组
    }

}
