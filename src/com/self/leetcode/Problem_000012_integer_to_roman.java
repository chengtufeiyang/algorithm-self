package com.self.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem_000012_integer_to_roman {

    public static void main(String[] args) {
        Problem_000012_integer_to_roman test = new Problem_000012_integer_to_roman();
//        int num = 3;
//        int num = 4;
//        int num = 9;
//        int num = 58;
//        int num = 1994;
//        int num = 3999;
        int num = 10;
        System.out.println(test.intToRoman(num));
    }


//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    I can be placed before V (5) and X (10) to make 4 and 9. 
//    X can be placed before L (50) and C (100) to make 40 and 90. 
//    C can be placed before D (500) and M (1000) to make 400 and 900.

//    1 <= num <= 3999

//    Example 1:
//
//    Input: num = 3
//    Output: "III"
//    Example 2:
//
//    Input: num = 4
//    Output: "IV"
//    Example 3:
//
//    Input: num = 9
//    Output: "IX"
//    Example 4:
//
//    Input: num = 58
//    Output: "LVIII"
//    Explanation: L = 50, V = 5, III = 3.
//    Example 5:
//
//    Input: num = 1994
//    Output: "MCMXCIV"
//    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//

//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/integer-to-roman
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    Map<Integer,Integer> map = new HashMap<>();
    public String intToRoman(int num) {
        int nums = getNum(num);// 获取位数
        StringBuilder result = new StringBuilder();
        for (int i = nums; i > 0; i--) {
            result.append(getString(map.get(i),i));
        }
        return result.toString();
    }


    private int getNum(int num) {
        int count = 0;
        while (num > 0){
            count++;
            map.put(count,num % 10);
            num /= 10;

        }
        return count;
    }

    /**
     * 第index位置的数字是num
     * @param num
     * @param index
     * @return
     */
    public String getString(int num ,int index){
        switch (index){
            case 1:
                if (num == 4 || num == 9) {
                    return num == 4 ? "IV" : "IX";
                }else {
                    if (num > 4) {
                        return "V" + String.join("", Collections.nCopies(num - 5, "I"));
                    } else {
                        return String.join("", Collections.nCopies(num, "I"));
                    }
                }
            case 2:
                if (num == 4 || num == 9) {
                    return num == 4 ? "XL" : "XC";
                }else {
                    if (num > 4) {
                        return "L" + String.join("", Collections.nCopies(num - 5, "X"));
                    } else {
                        return String.join("", Collections.nCopies(num, "X"));
                    }
                }
            case 3:
                if (num == 4 || num == 9) {
                    return num == 4 ? "CD" : "CM";
                }else {
                    if (num > 4) {
                        return "D" + String.join("", Collections.nCopies(num - 5, "C"));
                    } else {
                        return String.join("", Collections.nCopies(num, "C"));
                    }
                }
            default:  return String.join("", Collections.nCopies(num, "M"));

        }
    }
}
