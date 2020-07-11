package com.udemy.runnableExample;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class RunnableExample {

    public static void main(String[] args) {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        Runnable r = () -> System.out.println("hi");

       // r.run();

        new Thread(r).start();

        System.out.println("Hi");
    }


}
