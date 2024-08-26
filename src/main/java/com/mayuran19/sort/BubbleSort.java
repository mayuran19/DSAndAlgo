package com.mayuran19.sort;

import java.util.Arrays;

/**
 * Description: TODO Replace me
 *
 * @Author: ms
 * Date: 19/8/24
 * @license iLex
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = new int[]{5,4,3,2,1};
        sort(data);
        Arrays.stream(data).forEach(System.out::println);
    }
    public static void sort(int[] data){
        for(int i = 0; i < data.length; i++){
            for(int j = i + 1; j < data.length; j++){
                if(data[i] > data[j]){
                    //swap
                    var tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }
}
