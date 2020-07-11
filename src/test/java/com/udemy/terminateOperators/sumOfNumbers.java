package com.udemy.terminateOperators;

import java.util.*;
import java.util.stream.IntStream;

public class sumOfNumbers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9);

      /*  int sum=0;
        for (int i: list) {
            sum = sum +i;
        }

        System.out.println(sum);*/


        /*Optional<Integer> reduce = list.stream()
               // .reduce((a, b) -> a + b);
        .reduce((a,b)->{
            System.out.println(a+ "::"+ b);
            return a+b;
        });

         System.out.println(reduce.get());

*/

        /*int sum = list.stream()

                .mapToLong(a -> a)
                .mapToInt(a->(int)a)


                .sum();

        System.out.println(sum);*/

        IntStream.range(1,10)
                .forEach(i-> System.out.println("hi" +i));

    }
}
