package com.self.allpractice;

public class Problem004_unequal_formula {


    public static void main(String[] args) {
        int size = 10;
        System.out.println(isValid(unequalFormulaArray(size)));
    }


    /**
     * 根据数值创建符合不等式公式数组：下标顺序：i < j < k ，生成符合 arr[i] + arr[k]  != 2 * arr[j]
     *
     * @param size
     * @return
     */
    public static int[] unequalFormulaArray(int size) {
        if (size < 2) return new int[]{1};
        int halfSize = (size + 1) / 2;

        int[] halfArr = unequalFormulaArray(halfSize);

        int[] arr = new int[size];
        int index = 0;
        for (; index < halfSize; index++) {
            arr[index] = halfArr[index] * 2 - 1;
        }

        for (int i = 0; index < size; index++, i++) {
            arr[index] = halfArr[i] * 2;
        }
        return arr;
    }


    public static boolean isValid(int[] arr) {
        //  i  j  k
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (arr[i] + arr[k] == 2 * arr[j]) return false;
                }
            }
        }
        return true;
    }


}
