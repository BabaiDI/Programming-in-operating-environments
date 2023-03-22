package com.arraymult;

import java.util.Arrays;
import main.java.com.arraymult.MultArr;

public class App 
{
    public static void main( String[] args )
    {
        MultArr multArr = new MultArr(1000);
        long start;

        try
        {
            for(int sleep = 0; sleep <= 1; sleep++)
            {
                start = System.currentTimeMillis();
                int[] multfor0 = multArr.multfor(sleep);
                long multforTime0 = System.currentTimeMillis() - start;

                start = System.currentTimeMillis();    
                int[] multasync0 = multArr.multasync(sleep);
                long multasyncTime0 = System.currentTimeMillis() - start;


                if(Arrays.equals(multasync0, multfor0))
                {
                    System.out.println("multfor: " + multforTime0 + "ns, sleep: " + sleep);
                    System.out.println("multasync: " + multasyncTime0 + "ns, sleep: " + sleep);
                }
                else
                {
                    System.out.println("Arrays dont equals");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
