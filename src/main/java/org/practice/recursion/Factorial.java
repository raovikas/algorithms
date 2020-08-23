package org.practice.recursion;

import java.util.Scanner;

public class Factorial
{

   public static void main(String[] args)
   {
      System.out.println("Enter positive integer : ");
      Scanner scanner = new Scanner(System.in);
      int result = new Factorial().factorial(scanner.nextInt());
      System.out.println(result);

   }

   private int factorial(int n)
   {
      System.out.println("I am calculating F("+n+")");
      if (n == 0)
         return 1;

      int value = n * factorial(n - 1);
      System.out.println("I am done with F("+n+") = "+value);
      return value;
   }
}
