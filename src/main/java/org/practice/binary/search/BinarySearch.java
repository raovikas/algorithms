package org.practice.binary.search;
/*
 * Binary search is the most popular Search algorithm.It is efficient and also one of the most commonly used techniques that is used to solve problems.

If all the names in the world are written down together in order and you want to search for the position of a specific name, binary search will accomplish this in a maximum of 35 iterations.

Binary search works only on a sorted set of elements. To use binary search on a collection, the collection must first be sorted.

When binary search is used to perform operations on a sorted set, the number of iterations can always be reduced on the basis of the value that is being searched
 */
/*
 * int binarySearch(int low,int high,int key)
{
   while(low<=high)
   {
     int mid=(low+high)/2;
     if(a[mid]<key)
     {
         low=mid+1;
     }
     else if(a[mid]>key)
     {
         high=mid-1;
     }
     else
     {
         return mid;
     }
   }
   return -1;                //key not found
 }
 */
//https://www.hackerearth.com/practice/algorithms/searching/binary-search/tutorial/
/*You have been given an array A consisting of N integers. All the elements in this array A are unique. You have to answer some queries based on the elements of this array. Each query will consist of a single integer x. You need to print the rank based position of this element in this array considering that the array is 1 indexed. The rank based position of an element in an array is its position in the array when the array has been sorted in ascending order.

Note: It is guaranteed that all the elements in this array are unique and for each x belonging to a query, value x shall exist in the array

Input Format

The first line consists of a single integer N denoting the size of array A. The next line contains N unique integers, denoting the content of array A. The next line contains a single integer q denoting the number of queries. Each of the next q lines contains a single integer x denoting the element whose rank based position needs to be printed.

Output Format

You need to print q integers denoting the answer to each query.



Sample input
5
1 2 3 4 5
5
1
2
3
4
5

Sample Output
1
2
3
4
5



 */
import java.util.Arrays;
import java.util.Scanner;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class BinarySearch {
   public static void main(String args[] ) throws Exception {

      // Write your code here
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();

      int[] arr = new int[n];
      for(int i=0;i<n;i++)
      {
         arr[i] = s.nextInt();
      }
      Arrays.sort(arr);
      int q = s.nextInt();
      for(int j=1;j<=q;j++)
      {
         int x =  s.nextInt();
         int low = 0;
         int high = arr.length-1;
         while(low<=high)
         {
            int mid = (low+high)/2;
            if(arr[mid]>x){
               high = mid-1;
            }else if(arr[mid]<x){
               low = mid+1;
            }else
            {
               System.out.println(mid+1);
               break;
            } }
      }
   }
}
