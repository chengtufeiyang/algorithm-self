package com.self.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Problem_000020_valid_parentheses {

    public static void main(String[] args) {
        Problem_000020_valid_parentheses test = new Problem_000020_valid_parentheses();
//        String s = "()";
        String s = "()[]{}";
        System.out.println(test.isValid(s));
    }


//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
// 
//
//    Example 1:
//
//    Input: s = "()"
//    Output: true
//    Example 2:
//
//    Input: s = "()[]{}"
//    Output: true
//    Example 3:
//
//    Input: s = "(]"
//    Output: false
//    Example 4:
//
//    Input: s = "([)]"
//    Output: false
//    Example 5:
//
//    Input: s = "{[]}"
//    Output: true
//             
//
//    Constraints:
//
//            1 <= s.length <= 104
//    s consists of parentheses only '()[]{}'.
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/valid-parentheses
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public boolean isValid(String s) {
        int len = s.length();
        if (len < 2) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (!stack.isEmpty()){
                char temp = stack.peekLast();
                if ((temp == '(' && s.charAt(i) == ')') ||
                        (temp == '[' && s.charAt(i) == ']') ||
                        (temp == '{' && s.charAt(i) == '}' )    ) {
                    stack.pollLast();
                }else {
                    stack.addLast(s.charAt(i));
                }
            }else {
                stack.addLast(s.charAt(i));
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
