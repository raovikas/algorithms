package org.practice.linear.search;

public class LinearSearch
{

   public static void main(String[] args)
   {
      int[] arr = { 1, 22, 4, 7, 10, 6 };
      int element = 2;
      LinearSearch ls = new LinearSearch();
      int index = ls.search(arr, element);
      System.out.println("index of element 7 in array: " + index);//-1 means element is not present in array
   }

   private int search(int[] arr, int element)
   {
      for (int i = 0; i < arr.length; i++)
      {
         if (arr[i] == element)
            return i;
      }

      return -1;
   }
}
