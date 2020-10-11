/*
Given an array of integers. Complete the partition() function used for the implementation of Quick Sort.

Example 1:

Input: N = 5, arr[] = { 4, 1, 3, 9, 7}
Output: 1 3 4 7 9
Example 2:

Input: N = 10, 
arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output: 1 2 3 4 5 6 7 8 9 10

Your Task: You don't need to read input or print anything. Your task is to complete the function partition() which takes the array arr[] and the range of indices to be considered [low, high] and partitions the array in the given range considering the last element as the pivot such that, all the elements less than(or equal to) the pivot lie before the elements greater than it. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103
1 <= arr[i] <= 104
*/

import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
   /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = new QuickSort().partition(arr, low, high);
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }// } Driver Code Ends


/* The main function that implements QuickSort() (present in a class 
   different from QuickSort)
   arr[] --> Array to be sorted,   low  --> Starting index,  high  --> Ending index 
static void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        
        int pi = new QuickSort().partition(arr, low, high);
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    } }*/
class QuickSort
{
    /* This function takes last element as pivot, places  the pivot element 
    at its correct position in sorted  array, and places all smaller (smaller
    than pivot) to left of pivot and all greater elements to right  of pivot */
    static int partition(int arr[], int low, int high)
    {
        // add your code here
        int p=arr[high], i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<p){
                i++;
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        int t=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=t;
        return i+1;
    } 
}
