package com.udemy.fileProcessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessing {
    public static void main(String[] args) throws IOException {

       Path path = Paths.get("src\\test\\resources\\test.txt");

           List<String> stringList =  Files.readAllLines(path);



   /*     System.out.println(stringList.stream()
                .filter(s->s.startsWith("B"))
                   .count());

        List<String> collect = stringList.stream()
                .filter(s -> s.startsWith("C"))
                .filter(s -> s.contains("s"))
                .collect(Collectors.toList());

        System.out.println(collect.size());


        String m = stringList.stream()
                .filter(s -> s.startsWith("M"))
                .collect(Collectors.joining());
        System.out.println(m.length());*/

        List<String> collect1 = stringList.stream()
                .filter(s -> s.contains("-"))
                .map(s -> s.replace("-", " "))
                .collect(Collectors.toList());

        System.out.println(collect1);


        System.out.println(stringList.stream()
                .max(Comparator.comparing(s-> s.length()))
                .get());




    }
}
