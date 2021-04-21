package com.self.allpractice;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;
import com.wz.array.ArraysSelf;
import com.wz.array.GenerateArray;
import com.wz.array.SwapArray;
import sun.security.krb5.internal.PAData;

import java.util.Arrays;
import java.util.Comparator;

public class Problem011_arr_number_pair_k {


    public static void main(String[] args) {
        Problem011_arr_number_pair_k test = new Problem011_arr_number_pair_k();


//        int [] nums = {-25, -24, -23, -22, -22, -21, -19, -17, -16, -15, -15, -15, -14, -14, -14, -14, -14, -14, -13, -12, -10, -10, -9, -8, -7, -7, -7, -7, -6, -5, -5, -5, -5, -5, -4, -4, -3, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 10, 11, 11, 12, 13, 13, 14, 14, 15, 16, 16, 17, 17, 19, 19, 21, 23, 27, 28};
//        int k = 6285;
//        System.out.println(Arrays.toString(orderKPair2(nums,k)));
//        System.out.println(Arrays.toString(orderKPair4(nums,k)));
//        System.out.println(indexValFromQuickSort(nums,28));
//        System.out.println(indexValFromBFPRT(nums,28));

        int max = 100;
        int len = 30;
        int testTimes = 100000;
        System.out.println("test bagin, time times : " + testTimes);
        for (int i = 0; i < testTimes; i++) {
            int[] arr = GenerateArray.generateRandomArray(max, len);
            int[] arr1 = ArraysSelf.copyArray(arr);
            int[] arr2 = ArraysSelf.copyArray(arr);
            int[] arr3 = ArraysSelf.copyArray(arr);
            int[] arr4 = ArraysSelf.copyArray(arr);
            int N = arr.length * arr.length;
            int k = (int) (Math.random() * N) + 1;
            int[] ans0 = orderKPair(arr1, k);
//            int[] ans1 = orderKPair1(arr1, k);
//            int[] ans2 = orderKPair2(arr2, k);
//            int[] ans3 = kthMinPair3(arr3, k);
            int[] ans4 = orderKPair4(arr4, k);
            try {
                if (null == ans0 && null == ans4){
                    continue;
                }else {
                    if (ans0[0] != ans4[0] || ans0[1] != ans4[1]) {
                        System.out.println("Oops!");
                        System.out.println(String.format("N:%d,k:%d,len:%d",N,k,arr.length));
                        System.out.println(Arrays.toString(ans0));
                        System.out.println(Arrays.toString(ans4));
                        Arrays.sort(arr);
                        System.out.println(Arrays.toString(arr));
                        break;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Oops!");
                System.out.println(String.format("k:%d,len:%d",k,arr.length));
                System.out.println(Arrays.toString(ans0));
                System.out.println(Arrays.toString(ans4));
                Arrays.sort(arr);
                System.out.println(Arrays.toString(arr));
                break;
            }
        }
        System.out.println("test finish");
    }


    //  bfprt   随机快排

    /**
     * 数组arr,数值k,返回数组所有数值对第k小数（例如：数组arr:[1,2],数值对：{(1,1),(1,2),(2,1),(2,2)}）
     *
     * @param arr 原始数组
     * @param k   第k小的数值对
     * @return
     */
    public static int[] orderKPair(int[] arr, int k) {
        if (null == arr || arr.length == 0) return null;
        int len = arr.length;
        if (k <= 0 || k > Math.pow(len, 2)) return null;

        int tempNum = k / len;
        int preNum = tempNum + (k % len == 0 ? -1 : 0); //  到达k之前需要经历 的数字数量
        int val = indexValFromQuickSort(arr, preNum);  // 使用随机快排求出给定范围内第k个数

        //  每个
        int small = 0; // 统计小于
        int same = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] < val) {
                small++;
            } else if (arr[i] == val) {
                same++;
            } else {
                break;
            }
        }

        int smallNum = small * len;
        int indexTwo = (k - smallNum) / same + ((k - smallNum) % same == 0 ? -1 : 0); // 第二个位置数字在排序数组中坐标位置
        return new int[]{val, indexValFromQuickSort(arr, indexTwo)};
    }


    // TODO: 4/15/2021  随机快排返回数组中第k小的数，（第k大的数同理）  or bfprt
    // 随机快排返回数组中第k小的数，（第k大的数同理）

    /**
     * 默认一定存在
     *
     * @param arr
     * @param k
     * @return
     */
    public static int indexValFromQuickSort(int[] arr, int k) {
        return quickSor(arr, 0, arr.length - 1, k);
    }

    /**
     * 通过随机快排的方式确认第k个数字的值是什么
     *
     * @param arr
     * @param left
     * @param right
     * @param k
     * @return
     */
    private static int quickSor(int[] arr, int left, int right, int k) {

        if (left == right) return arr[left];
        int curr = arr[left + (int) (Math.random() * (right - left))]; // 随机选取比较值
        int currLeft = left;
        int currRight = right;
        int move = left;
        while (move <= currRight) {
            if (arr[move] == curr) {
                move++;
            } else if (arr[move] > curr) {
                SwapArray.swap(arr, move, currRight--);
            } else {
                SwapArray.swap(arr, move++, currLeft++);
            }
        }
        if (k >= currLeft && k <= currRight) return arr[currLeft];
        if (k < currLeft) return quickSor(arr, left, currLeft - 1, k);
        return quickSor(arr, currRight + 1, right, k);
    }


    public static int[] orderKPair4(int[] arr, int k) {
        if (null == arr || arr.length == 0) return null;
        int len = arr.length;
        if (k <= 0 || k > Math.pow(len, 2)) return null;

        int tempNum = k / len;
        int preNum = tempNum + (k % len == 0 ? -1 : 0); //  到达k之前需要经历 的数字数量
        int val = indexValFromBFPRT(arr, preNum);  // 获取等于改位置数值范围数组

        //  每个
        int small = 0; // 统计小于
        int same = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] < val) {
                small++;
            } else if (arr[i] == val) {
                same++;
            }
        }

        int smallNum = small * len;
        int indexTwo = (k - smallNum) / same + ((k - smallNum) % same == 0 ? -1 : 0); // 第二个位置数字在排序数组中坐标位置
        return new int[]{val, indexValFromBFPRT(arr, indexTwo)};
    }



    /**
     * 根据bfprt算法获取数组中第k个数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int indexValFromBFPRT(int[] arr, int k) {
        return bfprt(arr, 0, arr.length - 1, k);
    }

    private static int bfprt(int[] arr, int left, int right, int k) {

        if (left == right) return arr[left];
        // 每5个数排序，且取出其中中位数组成新的数组，
        // 并取出新的数组的中位数 // 得到此数值即为标准值，用于比较
        int mediums = firstMediums(arr, left,right);
        int[] pivotRange = partition(arr,left,right,mediums);

        if (k >= pivotRange[0] && k <= pivotRange[1]) return arr[k];
        if (k < pivotRange[0]) return bfprt(arr, left, pivotRange[0] - 1, k);
        return bfprt(arr, pivotRange[1] + 1, right, k);

    }

    private static int[] partition(int[] arr, int left, int right, int curr) {

        int currLeft = left;
        int currRight = right;
        int move = left;

        while (move <= currRight) {
            if (arr[move] == curr) {
                move++;
            } else if (arr[move] > curr) {
                SwapArray.swap(arr, move, currRight--);
            } else {
                SwapArray.swap(arr, move++, currLeft++);
            }
        }
        return new int[]{currLeft,currRight};
    }

    /**
     * 获取以以5分组中位数数组
     *
     * @param arr
     * @return
     */
    private static int firstMediums(int[] arr, int left,int right) {
        int nums = right - left +1;
        int offset = nums % 5 == 0 ? 0 : 1;
        int[] result = new int[nums / 5 + offset];
        for (int i = 0; i < result.length; i++) {
            int currleft = left + i;
            int currRight = Math.min(currleft + 4,right);
            result[i] = getMedium(arr, currleft, currRight);
        }
        return bfprt(result,0,result.length - 1,result.length / 2);
    }

    /**
     * 获取范围内中位数并返回
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int getMedium(int[] arr, int left, int right) {
        Arrays.sort(arr, left, right + 1);
        return arr[left + (right - left) / 2];
    }


    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class MyCom implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) { // 当 x （小 --- 大） ，当x相等时，y(小 --- 大)
            return o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x;
        }
    }

    /**
     * 暴力解
     *
     * @param arr
     * @return
     */
    public static int[] orderKPair1(int[] arr, int k) {
        if (null == arr || arr.length == 0) return null;
        int len = arr.length;
        if (k > len * len) return null;
        Pair[] pairs = new Pair[len * len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                pairs[index++] = new Pair(arr[i], arr[j]);
            }
        }
        Arrays.sort(pairs, new MyCom());
        return new int[]{pairs[k - 1].x, pairs[k - 1].y};
    }


    /**
     * 根据顺序排序求解
     *
     * @param arr
     * @return
     */
    public static int[] orderKPair2(int[] arr, int k) {
        if (null == arr || arr.length == 0) return null;
        int len = arr.length;
        Arrays.sort(arr);  // 数组排序 O(N * logN)
        int tempNum = k / len;
        int preNum = tempNum + (k % len == 0 ? -1 : 0); //  到达k之前需要经历 的数字数量
        //  每个
        int small = 0; // 统计小于
        int same = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] < arr[preNum]) {
                small++;
            } else if (arr[i] == arr[preNum]) {
                same++;
            } else {
                break;
            }
        }
        int smallNum = small * len;
        int indexTwo = (k - smallNum) / same + ((k - smallNum) % same == 0 ? -1 : 0); // 第二个位置数字在排序数组中坐标位置
        return new int[]{arr[preNum], arr[indexTwo]};
    }


}
