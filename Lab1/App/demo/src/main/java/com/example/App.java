package com.example;

import java.io.File;

public class App 
{
    public static void main( String[] args )
    {
        File CurrentPath = new File(System.getProperty("user.dir"));
        
        PrintTree(CurrentPath);
    }

    static int FileDepth = 0;

    public static void PrintTree(File file){

        System.out.println("|  ".repeat(FileDepth++) + file.getName());

        if(file.isDirectory()){
            try{
                for (File files : file.listFiles()) {
                    PrintTree(files);
                }
            }catch(Exception e){ }
        }

        FileDepth--;
    }
}