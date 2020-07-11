package com.udemy.callable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CollableExample {
    public static void main(String[] args) throws Exception {
        Supplier<Double> random = ()-> Math.random();

        Callable<Double> random2 = ()-> Math.random();

        System.out.println(random.get());
        try {
            System.out.println(random2.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        test(random2);
    }

    public static void  test(Callable callable) throws Exception {
        System.out.println(callable.call());
    }
}
