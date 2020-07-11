package com.udemy.terminateOperators;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {

    public static void main(String[] args) {
        String a = "Ball";
        String b = "Delta";
        String c = "Apple";

       /* System.out.println(
                Stream.of(a,b,c)
                .min(Comparator.naturalOrder())
        );
*/
        Optional<String> smallest = getSmallest(a,b,c);

        if(smallest.isPresent())
            System.out.println(smallest.get().toUpperCase());
        else {
            System.out.println("no value");
        }

    }
    private static Optional<String> getSmallest(String var1, String var2, String var3){
        //return Optional.ofNullable(null);

        return  Stream.of(var1, var2,var3)
                .min(Comparator.naturalOrder());
    }


}
