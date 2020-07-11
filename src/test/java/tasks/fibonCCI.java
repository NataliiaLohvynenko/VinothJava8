package tasks;

import java.util.Scanner;

public class fibonCCI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fibonacci;

        System.out.println("Enter Fibonacci sequence: ");

        fibonacci=sc.nextInt();

        System.out.println(fibonacci(fibonacci));

    }      //6
//1 1 2 3 5 /8/ 12 20
    private static int fibonacci(int fibonacci) {
     int number1 = 1;
     int number2 = 1;
     int result=0;


        for(int i=3; i<=fibonacci; i++) {

            result = number1+number2;
            number2 = number1;
            number1= result;


            System.out.println("i: "+i + " result:" + result + " number1:" + number1+ " number2: "+number2);

        }
        return result;
    }
}

//1 1 2 3 5 8 12
