package com.self.leetcode;

import java.util.*;

public class Problem_000554_brick_wall {
    public static void main(String[] args) {
        Problem_000554_brick_wall test = new Problem_000554_brick_wall();

//        int[][]  wall = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
//        int[][]  wall = {{1},{1},{1}};

        int[][] wall = {{1}};

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < wall.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < wall[i].length; j++) {
                temp.add(wall[i][j]);
            }
            lists.add(temp);
        }
        System.out.println(test.leastBricks(lists));
    }

//    https://leetcode-cn.com/problems/brick-wall/

//    There is a rectangular brick wall in front of you with n rows of bricks.
//    The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.
//
//    Draw a vertical line from the top to the bottom and cross the least bricks.
//    If your line goes through the edge of a brick, then the brick is not considered as crossed.
//    You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
//
//    Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.
//
//             
//
//    Example 1:
//
//
//    Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//    Output: 2
//    Example 2:
//
//    Input: wall = [[1],[1],[1]]
//    Output: 3
//             
//
//    Constraints:
//
//    n == wall.length
//1 <= n <= 10 4
//            1 <= wall[i].length <= 10 4
//            1 <= sum(wall[i].length) <= 2 * 10 4
//    sum(wall[i]) is the same for each row i.
//1 <= wall[i][j] <= 2……31 - 1



    /**
     * 返回最小穿墙数量
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer,Integer> indexNum = new HashMap<>();
        int tempindex;
        for (int row = 0; row < wall.size(); row++) {
            tempindex = 0;
            for (int col = 0; col < wall.get(row).size() - 1; col++) {
                tempindex += wall.get(row).get(col);
                indexNum.put(tempindex,indexNum.getOrDefault(tempindex,0) + 1);
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : indexNum.entrySet()) {
            result = Math.max(result,entry.getValue());
        }
        return wall.size() -  result;
    }


}
