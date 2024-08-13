package com.mayuran19.sort;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 9/8/24
 * @license iLex
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] data = new int[]{99,22,44,5345,234324,231234,346456,564456};
        insertionSort(data);
       for(int i = 0; i < data.length; i++){
           System.out.println(data[i] + " ");
       }
    }
    public static void insertionSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            int curr = i + 1;
            while (curr > i && curr < data.length){
                if(data[curr] < data[i]){
                    int tmp = data[i];
                    data[i] = data[curr];
                    data[curr] = tmp;
                }
                curr++;
            }
        }
    }
}
