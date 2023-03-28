package com.wtirethread;

import java.util.ArrayList;

public final class App {
    static volatile int count = 0;

    public static void main(String[] args) {
        ArrayList<WriteThread> wt = new ArrayList<WriteThread>();
        wt.add(new WriteThread("Th-1", 250));
        wt.add(new WriteThread("Th-2", 500));
        wt.add(new WriteThread("Th-3", 1000));

        wt.forEach(thread -> thread.start());

        while(wt.stream().anyMatch(thread -> thread.isAlive())) { };
    }
}