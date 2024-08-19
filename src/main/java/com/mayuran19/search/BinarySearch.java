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
        var data = new int[]{1,2,3,4,5,6};
        // System.out.println(binarySearch(data, 5, 0, data.length - 1));
        // System.out.println(binarySearchFirstIndex(data, 5, 0, data.length - 1));
        // System.out.println(binarySearchLoop(data, 6));
        System.out.println(isMountainArray(data));
    }
    public static int binarySearch(int[] data, int target, int left, int right){
        if(left >= right){
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

    public static int binarySearchFirstIndex(int[] data, int target, int left, int right){
        int mid = (left + right) / 2;

        if(left >= right){
            return -1;
        }

        if(data[mid] == target){
            return binarySearchFirstIndex(data, target, left, mid);
        }else{
            if(data[mid] > target){
                return binarySearchFirstIndex(data, target, left, mid);
            }else{
                return binarySearchFirstIndex(data, target, mid + 1, right);
            }
        }
    }

    public static int binarySearchLoop(int[] data, int target){
        int left = 0;
        int right = data.length - 1;
        int mid = (left + right) / 2;
        int minIndex = -1;
        while (left < right){
            if(data[mid] == target){
                minIndex = mid;
                minIndex = Math.min(minIndex, mid);
                right = mid;
                mid = (left + right) / 2;
            }else{
                if(data[mid] > target){
                    right = mid;
                }else{
                    left = mid + 1;
                }
                mid = (left + right) / 2;
            }
        }

        return minIndex;
    }

    public static int isMountainArray(int[] data){
        int start = 0;
        int end = data.length - 1;
        int mid = (start + end) / 2;
        while (start < end){
            if(data[mid] > data[mid + 1]){
                // in decreasing part of array
                end = mid;
            }else{
                // in increasing part of array
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        return -1;
    }
}
