package com.mayuran19.search;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 9/8/24
 * @license iLex
 */
public class BinarySearchIterative {
    public static void main(String[] args) {
        var data = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(data, 2));
    }
    public static int binarySearch(int[] data, int target){
        int left = 0;
        int right = data.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(data[mid] == target){
                return mid;
            }else{
                if(data[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
