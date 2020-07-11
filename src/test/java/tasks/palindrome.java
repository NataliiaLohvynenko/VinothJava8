package tasks;

import java.util.Scanner;

public class palindrome {

    public static void main(String[] args) {
        System.out.println("Enter String:");
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String reverce = "";

        for(int i = str.length()-1; i >=0; i--){
            reverce=reverce+str.charAt(i);

        }
        System.out.println(str.equals(reverce));
    }
}
