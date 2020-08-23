package org.practice.recursion;
/*
 * Fibonacci series without using Recursion , Recursion is not always good .
 */
public class Fibonacci
{

   public static void main(String[] args)
   {
      int result = new Fibonacci().Fib(11);
      System.out.println("using iterative "+result);
      int result1 = new Fibonacci().Fib2(11);
      System.out.println("using recursive "+result1);
   }

   //using iterative
   public int Fib(int n)
   {
      if(n<=1)
         return n;
      int f = 0,f1,f2;
      f1 = 0;
      f2 = 1;
      for(int i=2; i<=n;i++)
      {
         f = f1 + f2;
         f1 = f2;
         f2 = f;
      }
      return f;
   }

   // using recursive
   public int Fib2(int n)
   {
      if(n<=1)
         return n;
      return Fib2(n-1)+Fib2(n-2);
   }
}
