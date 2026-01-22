package pacecalculator;

import java.util.Scanner;

public class PaceCalculator {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.nextLine();

        System.out.println(isPalindrome(str));
    }

    public static String reverseString(String str){
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--){
            reverse += str.charAt(i);
        }
        return reverse;
    }

    public static boolean isPalindrome(String str){
        return str.equals(reverseString(str));
    }
}
