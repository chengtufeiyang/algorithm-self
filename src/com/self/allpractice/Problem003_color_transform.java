package com.self.allpractice;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import edu.princeton.cs.algs4.In;

public class Problem003_color_transform {
    public static void main(String[] args) {
        String str = "RRGRRGGRRGGG";
        System.out.println(minOperate(str));
        System.out.println(minOperateNoArray(str));
    }


    static char red = 'R';
    static char green = 'G';

    /**
     * 涂抹位置，调整字符串，使得左侧均为R（红色）,右侧均为 G（绿色）
     * @param str
     * @return
     */
    public static int minOperate(String str){
        if (null == str || str.length() < 1) return 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        //存储 从0 到当前位置，G的数量
        int[] leftDp = new int[len];
        leftDp[0] = chars[0] == green ? 1 : 0;
        for (int i = 1; i < len; i++) {  // 初始化数组
            leftDp[i] = leftDp[i - 1] + (chars[i] == green ? 1 : 0);
        }
        //存储 从当前位置到最后一位，R的数量
        int[] rightDp = new int[len];
        rightDp[len - 1] = chars[len - 1] == red ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) { // 初始化数组
            rightDp[i] = rightDp[i + 1] + ( chars[i] == red ? 1 : 0);
        }

        int min = Math.min(rightDp[0],leftDp[len - 1]);
        for (int i = 0; i < len - 1; i++) { // 左侧包含当前位置  ，不包含 左侧不包含的情况，因此特殊处理
            min = Math.min(min,leftDp[i] + rightDp[i + 1]);
        }
        return min;
    }


    public static int minOperateNoArray(String str){
        if (null == str || str.length() < 1) return 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        //存储 从0 到当前位置，G的数量
        int leftDp = 0;
        //存储 从当前位置到最后一位，R的数量
        int rightDp = chars[len - 1] == red ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) { // 初始化数组
            rightDp +=  chars[i] == red ? 1 : 0;
        }

        int min = rightDp;// 左侧未选择，全部右侧部分情况
        for (int i = 0; i < len - 1; i++) { // 左侧包含当前位置  ，不包含 左侧不包含的情况，因此特殊处理
            int temp = chars[i] == green ? 1 : 0;  // 绿色为1 ，红色为0
            leftDp += temp; //左侧找绿色
            rightDp -= temp==0 ? 1 : 0;
            min = Math.min(min,leftDp + rightDp);
        }

        //  左侧全选，右侧未选择
        return min;
    }

}
