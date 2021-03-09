package com.self.practice.comm_tools;

public class ArraysSelf {


    /**
     * 获取一维int数组指定位置数据
     * @param arr
     * @param index
     * @return
     */
    public static int query(int[]  arr,int index){
        if (null == arr || arr.length==0 || index < 0 || index >= arr.length)
            return 0;

        return arr[index];
    }

    /**
     * 获取二维int数组指定位置数据
     * @param arr
     * @param row
     * @param col
     * @return
     */
    public static int query(int[][]  arr,int row,int col){
        if (null == arr || arr.length==0 || row < 0 || row >= arr.length
         || col <0 || col >= arr[0].length )
            return 0;
        return arr[row][col];
    }


    /**
     * 获取三维int数组指定位置数据
     * @param arr
     * @param row
     * @param col
     * @return
     */
    public static int query(int[][][]  arr,int row,int col,int z){
        if (null == arr || arr.length==0 || row < 0 || row >= arr.length
                || col <0 || col >= arr[0].length || z <0 || z >= arr[0][0].length )
            return 0;
        return arr[row][col][z];
    }


}
