package com.self.leetcode;

public class Problem_000007_submissions {
    public static void main(String[] args) {
        Problem_000007_submissions test = new Problem_000007_submissions();
        System.out.println(Integer.MAX_VALUE);
        int x = 1534236469;
        System.out.println(test.reverse(x));
        System.out.println(test.reverse2(x));
    }


//    https://leetcode-cn.com/problems/reverse-integer/submissions/
    public int reverse(int x) {
        long result = 0;
        while (x != 0 ){
            result = result * 10 + x % 10;

            x /= 10;
        }
        return (int)result == result ? (int)result : 0;
    }


    public int reverse2(int x) {
        long res = 0;
        while(x!=0){
            res = res*10 +x%10;
            x /=10;
        }
        return (int)res==res ? (int)res:0;
    }

}
