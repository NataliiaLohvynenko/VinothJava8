package com.udemy.terminateOperators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Count {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ball");
        list.add("cat");
        list.add("dog");


        //Optional & FindFirst
     /*   Optional<String> first = list.stream()
                .filter(s -> s.length() > 3)
                .findFirst();

        if(first.isPresent()) {
            System.out.println(first.get());
        }*/
        System.out.println(
                list.stream()
                        // .filter(s->s.length()>3)
                       // .anyMatch(s -> s.contains("e"))
                .noneMatch(s->s.contains("e"))
                //.min(Comparator.naturalOrder()) //first element
                //  .max(Comparator.reverseOrder())
                //  .get()
                // .findFirst()
                // .count()
        );

    }
}
