package com.wtirethread;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDateTime;

class WriteThread extends Thread
{
    int period;

    public WriteThread(String threadName, int period)
    {
        Thread.currentThread().setName(threadName);
        this.period = period;
    }

    public void run()
    {
        while(App.count < 250)
        {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ThreadLog.txt", true), "utf-8"))) {
                Thread.sleep(period);
                writer.write(Thread.currentThread().getName() + " " + LocalDateTime.now() + " " + App.count++ + "\n");
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}