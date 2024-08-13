package com.mayuran19.recursion;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 9/8/24
 * @license iLex
 */
public class BinarySum {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(binarySum(data, 0, data.length - 1));
    }
    public static int binarySum(int[] data, int left, int right){
        int mid = (left + right) / 2;
        if(left > right){
            return 0;
        } else if (left == right) {
            return data[left];
        }else{
            return binarySum(data, left, mid) + binarySum(data, mid + 1, right);
        }
    }
}
