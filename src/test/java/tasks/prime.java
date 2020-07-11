package tasks;

import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        System.out.println("Enter number:");

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int counter = 0;


        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }if(counter>2){
            System.out.println("not Prime");
        }else{
            System.out.println("Prime");
        }
    }
}