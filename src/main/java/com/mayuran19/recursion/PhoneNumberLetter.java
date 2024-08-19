package com.mayuran19.recursion;

import java.util.List;
import java.util.Map;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 18/8/24
 * @license iLex
 */
public class PhoneNumberLetter {
    public static void main(String[] args) {
        var map = Map.of(
                "2", List.of("a", "b", "c"),
                "3", List.of("a", "b", "c"),
                "4", List.of("a", "b", "c"),
                "5", List.of("a", "b", "c"),
                "6", List.of("a", "b", "c"),
                "7", List.of("a", "b", "c"),
                "8", List.of("a", "b", "c"),
                "9", List.of("a", "b", "c")
        );

        printLetters("", "ad");
    }
    public static void printLetters(String processed, String unprocessed){
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
                printLetters(left + tookChar + right, newUnprocessed);
            }
        }
    }
}
