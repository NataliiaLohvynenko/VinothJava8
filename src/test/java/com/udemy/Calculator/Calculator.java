package com.udemy.Calculator;

import lambdaExpression.MathOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Calculator {

    BiFunction<Integer, Integer, Integer>  add = (a, b) -> a+b;
    BiFunction<Integer, Integer, Integer> divide = (a, b) -> a/b;
    BiFunction<Integer, Integer, Integer> substract = (a, b) -> a-b;
    BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a*b;

    Map<String, BiFunction> map = new HashMap<>();

    {
        map.put("+", add);
        map.put("/", divide);
        map.put("-", substract);
        map.put("*", multiply);
    }
    public int calculate(String string){

    String [] exp =string.split(" ");

        Integer i1 = Integer.parseInt(exp[0]);


int result = 0;





        return result;
    }


}
