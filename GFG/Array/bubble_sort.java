/*
The task is to complete bubble() function which is used to implement Bubble Sort!

Example 1:

Input: N = 5, arr[] = { 4, 1, 3, 9, 7}
Output: 1 3 4 7 9
Example 2:

Input: N = 10, 
arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output: 1 2 3 4 5 6 7 8 9 10

Your Task: This is a function problem. You only need to complete the function bubble() that sorts the array. Printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103
1 <= arr[i] <= 103
*/

//Initial Template for Java

import java.util.*;
import java.io.*;
class Sorting
{
    //method to print the Elements of the array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		while(t>0)
		{
		    //taking total elements
			int n = sc.nextInt();
			
			//creating a new array of length n
			int arr[] = new int[n];
			
			//inserting elements to the array
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt(); 
			}
			
			
			//calling bubbleSort() method
			bubbleSort(arr,n);
			
			//calling printArray() method
			printArray(arr);
			
		t--;	
		}
	}
	static void bubbleSort(int arr[], int n)
	{
	    int i, j;
        for (i = 0; i < n-1; i++)      
            new BubbleSort().bubble(arr, i, n);
	 }
}// } Driver Code Ends


//User function Template for Java

/* The task is to complete bubble() which is used 
   in below bubbleSort() */

/* A function to implement bubble sort
void bubbleSort(int arr[], int n)
{
   for (int i = 0; i < n-1; i++)      
        bubble(arr, i, n);
} */
class BubbleSort
{
	static void bubble(int arr[], int i, int n)
    {
       // add your code here
       //You do not need to print
       for(int b=0;b<n-1-i;b++){
           if(arr[b]>arr[b+1]){
               int t=arr[b];
               arr[b]=arr[b+1];
               arr[b+1]=t;
           }
       }
    }
}
