package com.mayuran19.recursion;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 18/8/24
 * @license iLex
 */
public class Permutation {
    public static void main(String[] args) {
        permutation("", "abc");
    }
    public static void permutation(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }else{
            var tookChar = unprocessed.substring(0, 1);
            var newUnprocessed = "";
            if(!unprocessed.isEmpty()){
                newUnprocessed = unprocessed.substring(1, unprocessed.length());
            }
            for(int i = 0; i <= processed.length(); i++){
                var left = processed.substring(0, i);
                var right = processed.substring(i, processed.length());
                permutation(left + tookChar + right, newUnprocessed);
            }
        }
    }
}
