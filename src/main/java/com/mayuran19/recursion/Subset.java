package com.mayuran19.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 17/8/24
 * @license iLex
 */
public class Subset {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        allSubset("", "abcdefghijklmnop", list);
        System.out.println(list);
    }
    public static void allSubset(String subSet, String original, List<String> result){
        if(original.isEmpty()){
            result.add(subSet);
            return;
        }
        allSubset(subSet + original.substring(0, 1), original.substring(1), result);
        allSubset(subSet, original.substring(1), result);
    }
}
