package com.mayuran19;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import static java.lang.StringTemplate.STR;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        /*var exe = Executors.newSingleThreadExecutor();
        var future = exe.submit(() -> {
            while (true){
                Thread.sleep(1000);
                System.out.println("running in thread");
            }
        });
        future.get();*/



        var task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing 1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Mayuran";
        });

        var task2 = task1.thenApplyAsync(s -> {
            System.out.println("Executing 2 " + Thread.currentThread().getName());
            System.out.println(s);
            return null;
        });

        System.out.println(task2.get());
    }
}
