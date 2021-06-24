package com.self.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_000149_max_points_on_a_line {

    public static void main(String[] args) {

//        int[][] points = {{1,1},{2,2},{3,3}};
//        int[][] points =  {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int[][] points =   {{2,3},{3,3},{-5,3}};
        System.out.println(maxPoints(points));
        System.out.println(maxPoints2(points));
    }
//    Given an array of points where points[i] = [xi, yi]
//    represents a point on the X-Y plane,
//    return the maximum number of points that lie on the same straight line.
//
//    Example 1:
//    Input: points = [[1,1],[2,2],[3,3]]
//    Output: 3
//    Example 2:
//
//
//    Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//    Output: 4
//             
//
//    Constraints:
//
//            1 <= points.length <= 300
//    points[i].length == 2
//            -104 <= xi, yi <= 104
//    All the points are unique.
//
//            来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/max-points-on-a-line
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //斜率相同 在一条直线上
    // 双重循环计算斜率
    public static int maxPoints(int[][] points) {

        int len = points.length;
        if (len <= 2) return len;

        int max = 1; //记录最大值
        Map<Double,Integer> map = null;
        double temp = -Integer.MIN_VALUE; //临时计算斜率
        for (int i = 0; i < len; i++) {
            map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (j != i){
                    temp = (points[j][0] - points[i][0] == 0) ? Integer.MAX_VALUE : ((double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]));
//                    System.out.println(String.format("%d,%d,%d,%d,%f",points[j][1],points[j][0],points[i][1],points[i][0],temp));
                    map.put(temp,map.getOrDefault(temp,1) + 1);
                    max = Math.max(max,map.get(temp));
                }
            }
//            System.out.println("-----------------------------------------------------------------");
        }
        return max ;
    }


    public static int maxPoints2(int[][] points) {

        int len = points.length;
        if (len <= 2) return len;

        int max = 1; //记录最大值
        Map<Double,Integer> map = null;
        double temp = -Integer.MIN_VALUE; //临时计算斜率
        for (int i = 0; i < len; i++) {
            map = new HashMap<>();
            for (int j = i + 1; j < len; j++) {
                temp = (points[j][0] - points[i][0] == 0) ? Integer.MAX_VALUE :
                        (points[j][1] - points[i][1] == 0 ? 0 : (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]));
                    System.out.println(String.format("%d,%d,%d,%d,%f",points[j][1],points[j][0],points[i][1],points[i][0],temp));
                map.put(temp,map.getOrDefault(temp,1) + 1);
                max = Math.max(max,map.get(temp));
            }
            System.out.println("-----------------------------------------------------------------");
        }
        return max ;
    }
}
