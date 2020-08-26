package org.practice.heap;

import java.util.Arrays;
/*
 * sorting array using heap concept
 */
public class HeapSort
{

   void heap_sort(int[] arr)
   {
      int N = arr.length-1;
      int heap_size = N;
      build_maxheap(arr);
      for (int i = N; i >= 2; i--)
      {
         swap(arr, 1, i);
         heap_size = heap_size - 1;
         max_heapify(arr, 1, heap_size);

      }
   }

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
      int N = arr.length - 1;
      for (int i = N / 2; i >= 1; i--)
      {
         max_heapify(arr, i, N);
      }
   }

   public static void main(String[] args)
   {
      int[] arr = {0,4,3,7,1,8,5};
      Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
      System.out.println("");
      new HeapSort().heap_sort(arr);
      Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
   }
}
