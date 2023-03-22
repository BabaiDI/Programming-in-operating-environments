package com.asyncfab;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App 
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args )
    {
        final long num;
        try
        {
            num = Integer.parseInt(reader.readLine());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }

        CompletableFuture<Long> fab = CompletableFuture.supplyAsync(
            new Supplier<Long>()
            {
                public Long get() {
                    return fibonacci(num);
                }
            }
        );

        System.out.print("Waiting");
        while(true){
            try
            {
                System.out.print(".");
                if(fab.isDone()){
                    System.out.println();
                    System.out.print(fab.get());
                    return;
                }
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    static Long fibonacci(Long N)
    {
        if(N == 1 || N == 0)
            return N;
        else 
            return fibonacci(N - 1) + fibonacci(N - 2);
    }
}
