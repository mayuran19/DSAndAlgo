package com.mayuran19.recursion;

import java.io.File;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 9/8/24
 * @license iLex
 */
public class DiskUsage {
    public static void main(String[] args) {
        var length = diskUsage(new File("/Users/mayuransatchithanantham/Downloads"));
        System.out.println(length);
    }
    public static long diskUsage(File path){
        long total = 0;
        if(path.isDirectory()){
            var children = path.listFiles();
            for (var child : children){
                total = total + diskUsage(child);
            }
        }else{
            total = total + path.length();
        }
        System.out.println(STR."Total: \{path.toPath().toAbsolutePath()}:\{total}");

        return total;
    }
}
