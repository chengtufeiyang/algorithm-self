package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hj072_Main {

    /**
     * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
     * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
     * <p>
     * 详细描述：
     * <p>
     * 接口说明
     * <p>
     * 原型：
     * <p>
     * int GetResult(vector &list)
     * <p>
     * 输入参数：
     * <p>
     * 无
     * <p>
     * 输出参数（指针指向的内存区域保证有效）：
     * <p>
     * list  鸡翁、鸡母、鸡雏组合的列表
     * <p>
     * 返回值：
     * <p>
     * -1 失败
     * <p>
     * 0 成功
     * 输入描述：
     * 输入任何一个整数，即可运行程序。
     * <p>
     * 输出描述：
     * 示例1
     * 输入：
     * 1
     * 输出：
     * 0 25 75
     * 4 18 78
     * 8 11 81
     * 12 4 84
     */
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            getResult(temp);
        }

    }

    //  100 钱  100只鸡
    private static void getResult(String temp) {
        int total = 100;
        // 公鸡  母鸡   雏鸡
        // 5     3     1/3
        //雏鸡的数量必须为3的倍数
        for (int i = 0; i <= total; i += 3) {

            // i 雏鸡数量
            int restMoney = total - i / 3; //  剩余公鸡母鸡可用钱数
            int restNum = total - i;  //     剩余公鸡母鸡可用数量

            for (int j = 0; j <= restNum && j * 5 <= restMoney; j++) { // 公鸡可用数量

                int num = total - i - j;// 母鸡可用数量
                int money = total - i / 3 - j * 5; // 母鸡可用钱

                if (num * 3 == money) {
                    System.out.println(j + " " + num + " " + i);
                }

            }
        }
    }
}
