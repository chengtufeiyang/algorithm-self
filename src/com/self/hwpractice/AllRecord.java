package com.self.hwpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AllRecord {

    public static void main(String[] args) throws IOException {
//1、
//        // 直接读取每一行的数据，类型：字符串

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String temp;
//        while ((temp = bufferedReader.readLine()) != null) {
//
//        }

//     2、
        // 读取输入的每一个字符
//        InputStream in = System.in;
//        (char) in.read();


//        3、直接读取一行
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.nextLine();


//        double d = 1.2;
//        double d1 = 1.0;
//        System.out.println(d1 == 1);
//        System.out.println(Math.ceil(d));
//        System.out.println(Math.ceil(d1));
//        double l = Math.pow(2,50) -1;
//        System.out.println(l);

//        4584854084 3
//        2

//        System.out.println(Math.pow(26,3) * Math.pow(10,5) > 4584854084l);

//        System.out.println(Math.pow(26,6) * Math.pow(10,7) > 4853493734759347l);
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String temp;
//
//        while ((temp = bufferedReader.readLine()) != null){
//            String[] strs = temp.split(" ");
//            double x = Double.parseDouble(strs[0]); // 需使用工号人数
//            double y = Double.parseDouble(strs[1]);  // 字母使用长度
//
//            //  字母情况26   数字 10
//            double y_num = Math.pow(26,y);
//
//            if (y_num * 10 >= x ){ // 因为数字数量不可为0，所以当
//                System.out.println(1);
//            }else{ // 当使用一个数字不够的情况
//                //共10条数据 利用二分法 寻找合适的数字种类数量
//                int left = 2;
//                int right = 10;
//                int result = 2;
//                while (left < right){
//                    int mid = left + (right - left)/ 2;
//                    double currNum = Math.pow(10,mid) * y_num;
//                    if (currNum == x){
//                        result = mid;
//                        break;
//                    }else if (currNum < x){
//                        left = mid + 1;
//                    }else {
//                        result = mid;
//                        right = mid;
//                    }
//                }
//                System.out.println(result);
//            }
//        }



//        //  2
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String temp;
//
//        while ((temp = bufferedReader.readLine()) != null){
//
//            int curr = Integer.valueOf(temp); // 只有其自己或本身可整除为素数
//
//            boolean flag = false; // 标记是否已输出
//            if (isUse(curr) || curr == 2 || curr == 1){   // 如果当前数为素数，结果为1  curr
//                if (curr == 1){
//                    System.out.println(-1 + " " + -1);
//                }else {
//                    System.out.println(1 + " " + curr);
//                }
//                flag = true;
//            }else { // 如果当前数不是素数
//                for (int i = 3; i < curr; i += 2) {
//                    if (curr % i == 0 && isUse(i) && isUse(curr / i)) {
//                        System.out.println(i + " " + (curr/ i));
//                        flag = true;
//                        break;
//                    }
//                }
//            }
//
//            if (!flag) System.out.println(-1 + " " + -1);
//        }







//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String temp;
//
//        while ((temp = bufferedReader.readLine()) != null){
//
//            int num = Integer.valueOf(temp);// 瑕疵
//            String str = bufferedReader.readLine(); // 待查询字符串
//
//            System.out.println(getLength(str,num));
//
//        }

        System.out.println(getLength("aacbaaa",2));



    }

    /**
     * 获取满足瑕疵度的最长子串
     * @param str
     * @param num
     * @return
     */
    private static int getLength(String str, int num) {
//        if (num > str.length() -2 ) return 0;


        // list集合统计整个字符串中援引位置，
        // 可使用双重循环确认哪两个元音位置代表子串满足要求
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (isFalse(curr)){ //如果是元音字符，则进行统计
                list.add(i);
            }
        }

        int len = list.size();  //元音字符数量
        if (len < 2) return 0;

        int max = 0;

        int first = -1;
        int sec = -1;
        int mid = 0;
        for (int i = 0; i < len; i++) {
            first = list.get(i); // 获取第一个元音位置坐标
            for (int j = i + 1; j < len; j++) {
                sec = list.get(j); // 第二个位置信息
                mid = j - i - 1; // 两个元音之间元音的数量
                //  如果瑕疵度满足条件
                if ((sec - first - 1 ) - mid == num){
                    max = Math.max(max,sec - first + 1);
                }
            }
        }

        if (num == 0 && max == 0) return 1;

        return max;
    }



    public static boolean isFalse(char curr){

        switch (curr){
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            case 'A':
                return true;
            case 'E':
                return true;
            case 'I':
                return true;
            case 'O':
                return true;
            case 'U':
                return true;
            default: return false;
        }

    }






    /**
     * 判断是否为素数
     * @param num
     * @return
     */
    public static boolean isUse(int num){

        if (num % 2 == 0) return isUse(num / 2);

        for (int i = 3; i < num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
