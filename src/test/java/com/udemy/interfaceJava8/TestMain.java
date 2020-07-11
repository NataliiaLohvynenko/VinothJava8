package com.udemy.interfaceJava8;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        CustomList list= new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(i-> System.out.println(i*i));
    }

}
