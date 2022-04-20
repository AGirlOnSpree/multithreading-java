package com.learn.multitreading.synchronizedcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {

    public static void shouldNotDo() {
        List<String> todo = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            todo.add("Buy book");
            todo.add("Learn multi threading");
        });

        Thread t2 = new Thread(() -> {
            todo.add("Drink chai");
            todo.add("Do leetcode");
            todo.add("Go for evening walk");
        });

        t1.start();
        t2.start();

        System.out.println(todo.stream().collect(Collectors.joining(",\n\t", "{\n\t", "\n}")));
    }

    public static void shouldDo() {
        Collection<String> todo = Collections.synchronizedCollection(new ArrayList<>());

        Thread t1 = new Thread(() -> {
            todo.add("Buy book");
            todo.add("Learn multi threading");
        });

        Thread t2 = new Thread(() -> {
            todo.add("Drink chai");
            todo.add("Do leetcode");
            todo.add("Go for evening walk");
        });

        t1.start();
        t2.start();

        System.out.println(todo.stream().collect(Collectors.joining(",\n\t", "{\n\t", "\n}")));
    }

    public static void main(String[] args) {

//        shouldNotDo();
        shouldDo();
    }
}
