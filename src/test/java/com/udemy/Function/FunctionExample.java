package com.udemy.Function;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
     /*   Function<String, Integer>  strLen = (s)->s.length();
        Function<Integer, Integer> square = (i) ->i*i;

        System.out.println(strLen.andThen(square).apply("hello"));*/

     Function<Integer, Integer> plus = (i) -> i+2;
     Function<Integer, Integer> square =(i) -> i*i;

        System.out.println(plus.compose(square).apply(8));//square first and than plus = 64 + 2

    }




}
