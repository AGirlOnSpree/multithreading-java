package com.learn.multitreading.concurrentcollections;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Driver {

    public static void shouldNotDo() throws InterruptedException {
        Set<String> set = new HashSet<>();

        Thread t1 = new Thread(() -> {
            set.add("ding");
            set.add("dong");
        });

        Thread t2 = new Thread(() -> {
            set.add("ping");
            set.add("pong");
        });

        t1.start();
        t2.start();

        //join makes the main thread wait till the t1 thread completes execution
        t1.join();
        //join makes the main thread wait till the t2 thread completes execution
        t2.join();

        System.out.println(set);
    }

    public static void shouldDo() throws InterruptedException {
        Set<String> set = new ConcurrentSkipListSet<>();

        Thread t1 = new Thread(() -> {
            set.add("ding");
            set.add("dong");
        });

        Thread t2 = new Thread(() -> {
            set.add("ping");
            set.add("pong");
        });

        t1.start();
        t2.start();

        //join makes the main thread wait till the t1 thread completes execution
        t1.join();
        //join makes the main thread wait till the t2 thread completes execution
        t2.join();

        System.out.println(set);
    }

    public static void main(String[] args) throws InterruptedException {
        //shouldNotDo();
        shouldDo();
    }
}
