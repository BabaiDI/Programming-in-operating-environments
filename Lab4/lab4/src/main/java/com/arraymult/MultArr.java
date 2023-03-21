package main.java.com.arraymult;

import java.util.Random;
import java.util.stream.IntStream;

public class MultArr {
    int[] input1;
    int[] input2;

    public MultArr(int lengh)
    {
        input1 = new int[lengh];
        input2 = new int[lengh];

        for(int i = 0; i < lengh; i++)
        {
            input1[i] = new Random().nextInt(0, 100);
            input2[i] = new Random().nextInt(0, 100);
        }
    }

    public int[] multfor(int sleep) throws Exception
    {
        if(input1.length != input2.length)
            throw new Exception("different lengh in arrays");

        int[] mult = new int[input1.length];

        for(int i = 0; i < input1.length; i++)
        {
            mult[i] = input1[i] * input2[i];
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return mult;
    }

    public int[] multasync(int sleep) throws Exception
    {
        if(input1.length != input2.length)
            throw new Exception("different lengh in arrays");

        int[] mult = new int[input1.length];

        IntStream.range(0, mult.length).parallel().forEach(i->{
            mult[i] = input1[i] * input2[i];
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    
        return mult;
    }
}
