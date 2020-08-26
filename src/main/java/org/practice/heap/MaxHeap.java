package org.practice.heap;

import java.util.Arrays;
/*
 * Max Heap: In this type of heap, the value of parent node will always be greater
 * than or equal to the value of child node across the tree
 *  and the node with highest value will be the root node of the tree.
 */
public class MaxHeap
{

   private void max_heapify(int[] arr, int i, int N)
   {
      int left = 2 * i;
      int right = 2 * i + 1;
      int largest;
      if (left <= N && arr[left] > arr[i])
      {
         largest = left;
      }
      else
      {
         largest = i;
      }

      if (right <= N && arr[right] > arr[largest])
      {
         largest = right;
      }

      if (largest != i)
      {
         swap(arr, i, largest);
         max_heapify(arr, largest, N);
      }
   }

   private void swap(int[] arr, int i, int j)
   {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public void build_maxheap(int[] arr)
   {
      int N = arr.length-1;
      for (int i = N/2; i >=1; i--)
      {
         max_heapify(arr, i, N);
      }
   }


   public static void main(String[] args)
   {
      int[] arr = {0,1,4,3,7,8,9,10};
      Arrays.stream(arr)
      .forEach(e->System.out.print(e + " "));
      new MaxHeap().build_maxheap(arr);
      System.out.println();
      Arrays.stream(arr)
      .forEach(e->System.out.print(e + " "));

   }

}
