package com.mayuran19.search;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 15/8/24
 * @license iLex
 */
public class BinarySearchRotated {
    public static void main(String[] args) {
        int[] data = new int[]{7,8,9,10,1,2,3,4,5,6};
        int index = search(data, 11, 0, data.length - 1);
        System.out.println(index);
    }
    public static int search(int[] data, int target, int start, int end){
        int mid = (start + end) / 2;

        if(start > end){
            return -1;
        }

        if(target == data[mid]){
            return mid;
        }

        if(data[start] < data[mid]){
            // left array is sorted and increasing
            if(target > data[mid]){
                // discard the left array
                return search(data, target, mid + 1, end);
            }else{
                return search(data, target, start, mid);
            }
        }else{
            // right array is sorted
            if(target > data[end]){
                // target is in left array
                return search(data, target, start, mid - 1);
            }else{
                return search(data, target, mid + 1, end);
            }

        }
    }
}
