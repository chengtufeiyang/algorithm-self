package com.self.practice.c03_dp;

public class P02_card_player {

    public static void main(String[] args) {
        int[] cards = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(cardPlayerRecursion(cards));
        System.out.println(cardPlayerDp(cards));
    }

//    整形数组数字代表一堆纸牌，玩家a和玩家b每次可以选择从左或者从右拿牌，返回最终获胜者的分数

    public static int cardPlayerRecursion(int[] cards) {
        if (null == cards || cards.length == 0) return 0;
//        int f = first(cards,0,cards.length-1);
//        int s = sec(cards,0,cards.length-1);
//        System.out.println("f:"+f);
//        System.out.println("s:"+s);
        return Math.max(first(cards,0,cards.length-1),
                sec(cards,0,cards.length-1));
    }

    //先手
    public static int first(int[] card, int left, int right) {
        if(left==right){
            return card[left];
        }
        return Math.max(card[left]+sec(card,left+1,right),card[right]+sec(card,left,right-1));
    }

    //后手
    public static int sec(int[] card, int left, int right) {
        if (left==right){
            return 0;
        }
        return Math.min(first(card,left+1,right),first(card,left,right-1));
    }



    public static int cardPlayerDp(int[] cards){
        if (null == cards || cards.length == 0) return 0;
        int len = cards.length;
        int[][] first = new int[len+1][len+1];//存储先手结果
        int[][] sec = new int[len+1][len +1];//存储后手结果
        for (int i = 0; i < cards.length; i++) {
            first[i][i] = cards[i];
        }
        for (int i = 1; i < sec[0].length; i++) {
            int right = i;
            int left = 0;
            while (right < sec.length-1){
                sec[left][right] = Math.min(
                        returnInt(first,left+1,right),returnInt(first,left,right-1)
                        );
                first[left][right] = Math.max(cards[left]+
                        returnInt(sec,left+1,right)
                        ,cards[right]+returnInt(sec,left,right-1));
                right++;
                left++;
            }
        }
        return Math.max(first[0][cards.length-1],
                sec[0][cards.length-1]);
    }

    public static int returnInt(int[][] arr,int left,int right){
        if (left <0 || left >= arr.length || right <0 || right>= arr[0].length) return 0;
        return arr[left][right];
    }

}
