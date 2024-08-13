package com.mayuran19.search;

/**
 * Description: TODO Replace me
 *
 * @Author: Mayuran
 * Date: 9/8/24
 * @license iLex
 */
public class BinarySearch {
    public static void main(String[] args) {
        var data = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(data, 11, 0, data.length - 1));
    }
    public static int binarySearch(int[] data, int target, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(data[mid] == target){
            return mid;
        }else{
            if(data[mid] > target){
                return binarySearch(data, target, left, mid);
            }else{
                return binarySearch(data, target, mid + 1, right);
            }
        }
    }
}
