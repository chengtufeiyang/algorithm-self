package com.self.allpractice;

import java.util.ArrayList;
import java.util.List;

public class Problem009_arr_search_target {

    public static void main(String[] args) {
        int sum = 10;
        int[] arr1 = { -8, -4, -3, 0, 1, 2, 4, 5, 8, 9 };
        System.out.println(twoForTarget(arr1,sum));
        System.out.println(threeForTarget(arr1,sum));
    }

    /**
     * 一维数组arr中寻找目标数值target
     * 	二元数组满足target所有结果（no repeat）
     * 	三元数组满足target所有结果（no repeat）
     * @param arr
     * @param target
     * @return
     */
    public static List<int[]> twoForTarget(int[] arr,int target){
        if (null == arr || arr.length < 2) return null;

        int len = arr.length;
        int left = 0;
        int right = len - 1;
        List<int[]> result = new ArrayList<>();
        while (left < len && right >= 0 && left < right){
            int temp = arr[left] + arr[right];
            if (temp == target){
                if (left + 1 < len && right - 1 >= 0 && arr[left] != arr[left + 1] && arr[right] != arr[right - 1]){
                    result.add(new int[]{arr[left],arr[right]});
                    System.out.println("key1:"+arr[left] + " key2:"+ arr[right]);
                }
                left++;
                right--;
            }else if(temp < target){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }



    public static List<int[]> threeForTarget(int[] arr,int target){
        if (null == arr || arr.length < 2) return null;

        int len = arr.length;

        List<int[]> result = new ArrayList<>();

        //首先固定第一个数字
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < len && right >= 0 && left < right){
                int temp =arr[i] + arr[left] + arr[right];
                if (temp == target){
                    if (left + 1 < len && right - 1 >= 0 && arr[left] != arr[left + 1] && arr[right] != arr[right - 1]){
                        result.add(new int[]{arr[i],arr[left],arr[right]});
                        System.out.println("key0:"+arr[i]+" key1:"+arr[left] + " key2:"+ arr[right]);
                    }
                    left++;
                    right--;
                }else if(temp < target){
                    left++;
                }else {
                    right--;
                }
            }

        }







        return result;
    }


}
