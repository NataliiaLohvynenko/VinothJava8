package com.udemy.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        Predicate<Integer> isGT2 = (n) -> n>2;
        Predicate<Integer> isLT10 = (n) -> n<10;

        System.out.println(isGT2.and(isLT10).test(5));
        System.out.println(isGT2.negate().test(1));
    }
}
