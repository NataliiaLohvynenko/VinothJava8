package com.udemy.Calculator;

import lambdaExpression.MathOperation;

import java.util.HashMap;
import java.util.Map;

public class Calculator1 {
    private static Map<String, MathOperation> map = new HashMap<>();
   static {
        map.put("+", (a, b) -> a+b);
        map.put("/", (a, b) -> a/b);
        map.put("-", (a, b) -> a-b);
        map.put("*", (a, b) -> a*b);
    }

    public static void addOperation(String key, MathOperation mathOperation){
        map.put(key, mathOperation );
    }
    public static int calculate(String expression){
       String[] exp = expression.split(" ");
        int onScreenNumber = Integer.parseInt(exp[0]);
        for (int i = 1; i < exp.length; i=i+2) {
           // String op = exp[i];

            MathOperation op = map.get(exp[i]);
            int enteredNumber = Integer.parseInt(exp[1+1]);
            onScreenNumber = calculate(onScreenNumber,op,enteredNumber);
        }

return onScreenNumber;

    }

    public static void main(String[] args) {


        System.out.println(calculate("5+7+9/6*9"));

    }

    private static int calculate(int onScreenNumber, MathOperation mathOperation, int enteredNumber){

        return mathOperation.operate(onScreenNumber, enteredNumber);
    }
}
