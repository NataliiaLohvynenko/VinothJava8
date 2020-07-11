package com.udemy.stream;

import java.util.ArrayList;
import java.util.List;

public class EvenSquare {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        /*for (Integer i: list) {
            int a = list.get(i);
            if(a%2==0){
                System.out.println(a*a);
            }
        }*/

        System.out.println("starting");

        list.stream()
                .skip(2)
                .filter(i->i%2==0)
                .filter(i-> i>5)
                .peek(i-> System.out.println("filter-received ::" + i))
                .sorted()
                .limit(3)
                .map(i-> i*i)
                .map(i -> i+2)
                .peek( i->System.out.println("map - received :: " +i))
                .forEach(i-> System.out.println(i));

        System.out.println("ending");
    }
}
