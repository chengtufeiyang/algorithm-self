package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Hj049_Main {
    /**
     * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。
     * 要求按顺序向数组赋值 ABCDABCDABCD ， ABCD 的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
     * 接口说明：
     * void init();  //初始化函数
     * void Release(); //资源释放函数
     * unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
     * unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
     * unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
     * Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
     * char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证
     * <p>
     * 输入描述：
     * 本题含有多个样例输入。
     * 输入一个int整数
     * <p>
     * 输出描述：
     * 对于每组样例，输出多个ABCD
     * <p>
     * 示例1
     * 输入：
     * 10
     * 输出：
     * ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD
     */

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String temp;
        while ((temp = bufferedReader.readLine()) != null) {

            int num = Integer.valueOf(temp); // 需重复打印次数

            AtomicInteger atomic = new AtomicInteger(0);// 0 1 2 3  表示当前待打印状态


            Thread thread_a = new MyThread("A",num,atomic);
            Thread thread_b = new MyThread("B",num,atomic);
            Thread thread_c = new MyThread("C",num,atomic);
            Thread thread_d = new MyThread("D",num,atomic);


            thread_a.start();
            thread_b.start();
            thread_c.start();
            thread_d.start();

        }


    }


    private static class MyThread extends Thread {

        private String str;// 线程需打印字符
        private int num; // 控制循环次数
        private AtomicInteger atomic;


        public MyThread( String str,int num,AtomicInteger atomic) {
            this.str = str;
            this.num = num;
            this.atomic = atomic;
        }

        @Override
        public void run() {

            try {
                for (int i = 0; i < num; i++) {

                    if (atomic.get() == 0){ // 打印A

                    }

                    if (atomic.get() == 1){ // 打印B

                    }

                    if (atomic.get() == 2){ // 打印C

                    }

                    if (atomic.get() == 3){ // 打印D

                    }



                    System.out.print(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
