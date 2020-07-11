package com.udemy.terminateOperators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Apple");
        list.add("Airplane");
        list.add("Ball");
        list.add("Boy");
        list.add("Cat");
        list.add("Dog");
        list.add("Delta");

        Stream<String> stream = list.stream()
            .filter(s-> s.length()>3);

        stream.forEach(s-> System.out.println(s));
       // stream.forEach(s-> System.out.println(s.toUpperCase()));

        String a = "Ball";
        String b = "Delta";
        String c ="Apple";
        System.out.println(Stream.of(a,b,c)
                .min(Comparator.naturalOrder())

        );
    }
}
