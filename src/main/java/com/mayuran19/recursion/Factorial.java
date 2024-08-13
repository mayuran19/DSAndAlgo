package com.mayuran19.recursion;

/**
 * Description: TODO Replace me
 *
 * @Author: Mayuran
 * Date: 9/8/24
 * @license iLex
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int factorial(int n){
        if(n == 0) return 1;
        else{
            return n * factorial(n-1);
        }
    }
}
