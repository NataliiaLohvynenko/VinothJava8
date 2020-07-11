package com.udemy.consumer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
      /*  Consumer<String> c1 =(s) -> System.out.println(s);

        c1.accept("udemy");*/

        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("lohveyn");
     /*   Consumer<String> c1 =(s) -> System.out.println(s);

       list.forEach(s -> System.out.println(s.toUpperCase()));*/
//Consumer

        Consumer<String> dbConsumet = (s) -> System.out.println("dbConsumer" + s);
        Consumer<String> logConsumet = (s) -> System.out.println("logConsumer" + s);

       // dbConsumet.accept("test");

      //  Consumer<String> dbLogConsumer = dbConsumet.andThen(logConsumet);

       // list.forEach(dbLogConsumer);
     /*  Map<String, Consumer<String>> map = new HashMap<>();

        map.put("db", dbConsumet);
        map.put("log",logConsumet);
        map.put("dbLog", dbConsumet.andThen(logConsumet));*/

       /* list.forEach(map.get("dbLog"));*/

//biConsumer

        BiConsumer<String, Integer> biConsumer = (s, i) -> {
            System.out.println("My name " + s);
            System.out.println("My age " +i);
        };

        //biConsumer.accept("Nata", 10);

        Map<String, Consumer<String>> map = new HashMap<>();

        map.put("db", dbConsumet);
        map.put("log",logConsumet);
        map.put("dbLog", dbConsumet.andThen(logConsumet));



        map.forEach((k, v) -> {
            System.out.println( "Key is " + k);
        });


    }
}
