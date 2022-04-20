package com.learn.multitreading.stateless;

public class Driver {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : " + MathUtils.factorial(6));
        }, "Thread1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : " + MathUtils.factorial(5));
        }, "Thread2");

        t1.start();
        t2.start();
    }
}
