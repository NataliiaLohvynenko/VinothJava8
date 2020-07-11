package com.udemy.terminateOperators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collector {

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

        /*List<String> newList = list.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Original " + list);
        System.out.println("New list" + newList);*/

        /*Set<String> newSet = list.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toSet());
        System.out.println("Original " + list);
        System.out.println("New list" + newSet);*/

       /* String joinString = list.stream()
                .filter(s-> s.length()>3)
                .collect(Collectors.joining(";"));

        System.out.println(joinString);*/

      Map<Integer, List<String>>  collect = list.stream()
               .collect(Collectors.groupingBy(s-> s.length()));

        System.out.println(collect);


    }



}
