package com.self.leetcode;

public class Problem_001025_divisor_game {
    public static void main(String[] args) {
        Problem_001025_divisor_game test = new Problem_001025_divisor_game();
////        int n = 2;
//        int n = 3;
//        System.out.println(test.divisorGame(n));



        for (int i = 1; i <= 100; i++) {
            System.out.println(i+"      "+test.divisorGame(i));
        }
    }

//    Example 1:
//
//    Input: n = 2
//    Output: true
//    Explanation: Alice chooses 1, and Bob has no more moves.
//    Example 2:
//
//    Input: n = 3
//    Output: false
//    Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
//             
//
//    Constraints:
//
//            1 <= n <= 1000
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/divisor-game
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean divisorGame(int n) {
            if(n == 1) return false;
            //  判断n一定又约数，最小为1
            for (int i = 1; i < n; i++) {
                if (n % i == 0 && !divisorGame(n - i)){ // 当前i 是n的约数
                    return true;
                }
            }
        return false;
    }


    public boolean divisorGame2(int n) {
        return n % 2 == 0 ;
    }
}
