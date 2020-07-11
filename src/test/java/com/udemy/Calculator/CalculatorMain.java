package com.udemy.Calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println( Calculator1.calculate("5 + 8"));
        Calculator1.addOperation("^", (a,b) -> (int)Math.pow(a,b));
    }


}
