package com.self.leetcode;

public class Problem_000633_sum_of_square_numbers {
    public static void main(String[] args) {
//        System.out.println((int)Math.sqrt(3) == Math.sqrt(3));
//        System.out.println(Math.sqrt(4) == 2);

        Problem_000633_sum_of_square_numbers test = new Problem_000633_sum_of_square_numbers();
        for (int i = 1; i < 1000; i++) {
            if (!(test.judgeSquareSum3(i) == test.judgeSquareSum2(i))) {
                System.out.println(i);
                break;
            }
        }


//        int c = 4;
//        System.out.println(test.judgeSquareSum3(c));
//        System.out.println(test.new Solution().judgeSquareSum(c));
    }


//    0 <= c <= 231 - 1
//    https://leetcode-cn.com/problems/sum-of-square-numbers/

    public boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) return true;
        int half = c / 2 + 1;
        for (int i = 1; i < half; i++) {
            int temp = c - (int) Math.pow(i, 2);
            if ((int) Math.sqrt(temp) == Math.sqrt(temp)) {
                return true;
            }
        }
        return false;
    }


    public boolean judgeSquareSum2(int c) {
        if (c == 0 || c == 1) return true;
        int left = 0;
        int right = (int) Math.sqrt(c) + 1;//
        while (left <= right) {
            double temp = Math.pow(left, 2) + Math.pow(right, 2);
            if (temp == c) {
                return true;
            } else if (temp > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    // 费马平方和定理：
    //  一个非负整数 c 如果能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k +3 的质因子的幂均为偶数。
    public boolean judgeSquareSum3(int c) {

        for (int base = 2; base * base <= c; base++) {

            if (c % base != 0){
                continue;
            }
            int exp = 0;
            while (c % base == 0){
                c /= base;
                exp +=1;
            }

            if (base % 4 == 3 && exp % 2 != 0){
                return false;
            }
        }
        return c % 4 != 3;
    }

}
