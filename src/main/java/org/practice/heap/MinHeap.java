package org.practice.heap;

import java.util.Arrays;

/*
 * Min Heap: In this type of heap, the value of parent node will always be less
 * than or equal to the value of child node across the tree
 *  and the node with lowest value will be the root node of tree.
 */
public class MinHeap
{

   private void min_heapify(int[] arr, int i, int N)
   {
      int left = 2 * i;
      int right = 2 * i + 1;
      int smallest;
      if (left <= N && arr[left] < arr[i])
      {
         smallest = left;
      }
      else
      {
         smallest = i;
      }

      if (right <= N && arr[right] < arr[smallest])
      {
         smallest = right;
      }

      if (smallest != i)
      {
         swap(arr, i, smallest);
         min_heapify(arr, smallest, N);
      }

   }

   private void swap(int[] arr, int i, int j)
   {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public void build_minheap(int[] arr)
   {
      int N = arr.length-1;
      for (int i = N/2; i >= 1; i--)
      {
         min_heapify(arr, i, N);
      }
   }

   public static void main(String[] args)
   {
      int[] arr = { 0, 10, 8, 9, 7, 6, 5, 4 };
      Arrays.stream(arr).forEach(a -> System.out.print(a+" "));
      System.out.println();
      new MinHeap().build_minheap(arr);
      Arrays.stream(arr).forEach(a -> System.out.print(a+" "));
   }

}
