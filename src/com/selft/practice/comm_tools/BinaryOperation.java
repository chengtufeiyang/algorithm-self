package com.selft.practice.comm_tools;

public class BinaryOperation {

    public static void main(String[] args) {

//        int x = 0 ;
//        int y = 6;
//        System.out.println(new BinaryOperation().OppositeSigns(x,y));

//        int x = 0;
//        System.out.println(new BinaryOperation().PowerOfTwo(x));

//        int v = 3;
//        System.out.println(new BinaryOperation().CountBitNum(v));
//        System.out.println(Integer.bitCount(v));


        int v = 2;
        System.out.println(new BinaryOperation().parity(v));

    }


    /**
     * Detect if two integers have opposite signs
     */
    public boolean oppositeSigns(int x,int y){
        return (x ^ y) <0;
    }


    /**
     * Determining if an integer is a power of 2
     *
     */
    public boolean powerOfTwo(int x){
        if (x<=0) return false;
        return (x & (x -1))==0;   //v && !(v & (v - 1))
    }


    /**
     * Counting bits set (naive way)
     * @param v
     * @return
     */
    public int countBitNum(int v){
        int c ;
        for (c = 0; v>0; v >>= 1)
        {
            c += v & 1;
        }
        return c;
    }


    /**
     * Computing parity the naive way
     * @param v
     * @return
     */
    public boolean parity(int v){
        boolean parity = false;  // parity will be the parity of v

        while (v>0)
        {
            parity = !parity;
            v = v & (v - 1);
        }
        return parity;
    }

}
