package com.self.company.accenture;

public class Problem_0001_delete_string_char_make_max {

    public static void main(String[] args) {
//        String N = "2020";
//        int x = 1;

//        String N = "1432319";
//        int x = 3;

        String N = "1432319";
        int x = 2;
        System.out.println(maxNum(N,x));
    }

//
//    给定一个长度为 m（m >= 1）的字符串，这个字符串表示一个非负整数 N（应该可以用 long 装下，我是最后超时了）。其中 N 没有前导 0。
//
//    再给定一个整数 x（x <= m），要你从整数 N 中删除 x 个数字，使得余下的数字最小。最后输出这个最小的数字。
//
//    例如：
//    输入：N=2020，x = 1
//    输出：20
//    解释：删除第一个 2，剩下 020=20
//
//    输入：N=1432319，x = 3
//    输出：1219
//
//    作者：jojolin
//    链接：https://leetcode-cn.com/circle/discuss/l8Hse4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    /**
     * 字符串str删除一定num个字符，是的余下数据最小---选择一定数量（str.lengh - num）的数据,返回最小数据
     * @param str
     * @param num
     * @return
     */
    public static int maxNum(String str , int num){
        if (null == str || str.length() == 0 ) return 0;// 当字符串无意义情况下，默认返回0
        int len = str.length();
        if (num >= len) return 0; // 需删除字符数量 > 字符串长度，说明字符串一定会被删完，认为字符串无字符情况返回 0

        // 潜台词，从左侧开始删除，如果   贪心
        int one = 0; // 当前
        int two = 1; // 下一个待比较字符
        int three = 2; // 再下一个待比较位置
        int currNum = num; // 当前待删除数量

        boolean[] flag = new boolean[len]; // 默认false ,如果已使用标记为true

        while (currNum > 0){ // 当待删除数量==0 ，停止循环

            if (one == len - 1){ //  不够删的数据已过滤，不会因为此步骤陷入死循环状态
                // delete one
                flag[one++] = true;
                currNum--;
            }else if(three < len){ // 三个数据均满足范围内条件
                if (str.charAt(one) > str.charAt(two)){
                    //delete one
                    flag[one] = true;
                    currNum--;
                    one = two;
                    two = three;
                    three += 1;

                }else if (str.charAt(one) < str.charAt(two)){

                    if (str.charAt(two) >= str.charAt(three)){
                        // delete two
                        flag[two] = true;
                        currNum--;
                        two = three;
                        three += 1;

                    }else {
                        // delete three
                        flag[three] = true;
                        currNum--;
                        three +=1;
                    }

                }else { //  onw == two 情况

                    if (str.charAt(two) >= str.charAt(three)){
                        // delete one
                        flag[one] = true;
                        currNum--;
                        one = two;
                        two = three;
                        three += 1;
                    }else {
                        // delete three
                        flag[three] = true;
                        currNum--;
                        three +=1;
                    }
                }
            }else { // two in , three out
                if (str.charAt(one) >= two){
                    // delete one
                    flag[one] = true;
                    currNum--;
                    one = two;
                    two = three;
                    three += 1;
                }else {
                    // delete two
                    flag[two] = true;
                    currNum--;
                    two = three;
                    three += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder(
                !flag[0] && str.charAt(0)!='0' ? String.valueOf(str.charAt(0) ) : ""
        );
        for (int i = 1; i < len; i++) {
            if (!flag[i]){ // 收集未删除字符
                sb.append(str.charAt(i));
            }
        }
        return Integer.valueOf(sb.toString());
    }


//
//    第1道题：
//    方案1：N长度为m，删除x个数字，那就剩m-x个数字，所以就是求原始序列N的长度为m-x的子序列，使得这个子序列最小。
//    以输入 N = 1432319 为例，m=7 x=3，m-x=4，所以我们的目标是要从N中挑出4个数来，这4个数的相对顺序是不能变的。下面是步骤：
//
//    N=1432319，目标长度4，所以第1个数只能从1432里面取，不然后面的数就不够用了。这里肯定选最小的1，结果变成1
//            N=432319，目标长度3，所以第2个数只能从4323里面取，不然后面的数不够用了，同理选2，结果变成12
//    N=319, 目标长度2，所以第3个数只能从31里面取，不然后面的数不够用了，同理选1，结果变成121
//            N=9，不说了。。。，最终结果变成1219
//    方案2：上面的方案中，需要每次去找某个区间的最小值，导致时间复杂度是O(m*x)，如果想优化可以针对这个问题引入单调(递增)栈，单调栈这里就不介绍了，网上随便搜一下就有。具体步骤：
//
//    启动的时候先压入4个数1432，压完单调栈变成12
//    栈底的1出栈，放到结果中，同时1432后面的3压栈，单调栈变成23
//    栈底的2出栈，放到结果中，同时14323后面的1压栈，单调栈变成1
//    栈底的1出栈，放到结果中，同时143231后面的9压栈，单调栈变成9
//    栈底的9出栈，放到结果中
//            返回最终结果1219
//
//    作者： Berry
//    链接：https://leetcode-cn.com/circle/discuss/l8Hse4/view/dwe11M/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
