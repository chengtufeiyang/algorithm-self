package com.self.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_000013_roman_to_integer {
    public static void main(String[] args) {
        Problem_000013_roman_to_integer test = new Problem_000013_roman_to_integer();
//        String s = "LVIII";
//        String s = "LIV";
//        String s = "MCMXCIV";
//        String s = "IX";
        String s = "III";
        System.out.println(test.romanToInt(s));
//        System.out.println(s.substring(2,1));
    }


//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//    I can be placed before V (5) and X (10) to make 4 and 9. 
//    X can be placed before L (50) and C (100) to make 40 and 90. 
//    C can be placed before D (500) and M (1000) to make 400 and 900.
//Constraints:
//
//1 <= s.length <= 15
//s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
//It is guaranteed that s is a valid roman numeral in the range [1, 3999].
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/roman-to-integer
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public int romanToInt(String s) {
        int len = s.length();
        int index = 0;
        int result = 0;
        String tempStr = null;
        while (index < len - 1){
            tempStr = s.substring(index,index + 2);
            if (null != map.get(tempStr)){
                result += map.get(tempStr);
                index += 2;
            }else {
                result += map.get(String.valueOf(s.charAt(index++)));
            }
        }
        if (index < len){
            result += map.get(String.valueOf(s.charAt(len - 1)));
        }


        return result;
    }
}
