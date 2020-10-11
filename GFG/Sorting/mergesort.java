/*
The task is to complete merge() function which is used to implement Merge Sort.

Example 1:

Input:
N = 5
arr[] = {4,1,3,9,7}
Output: 1 3 4 7 9
Example 2:

Input:
N = 10
arr[] = {10,9,8,7,6,5,4,3,2,1}
Output: 1 2 3 4 5 6 7 8 9 10
Your Task:
You don't need to take the input or print anything. Your task is to complete the function merge() which takes the array arr[], the starting position of the first array (l),  the ending position of the first array (m) and the ending position of the second array (r) as its inputs and modifies the array arr[] such that it is sorted from position l to position r. The range [l,m] and [m+1,r] are already sorted.

Expected Auxiliary Space: O(n)
Expected Time Complexity: O(n)  (for the merge() function) 

Constraints:
1 <= N <= 105
1 <= arr[i] <= 103
*/


import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //method for dividing the array into halves
    static void mergeSort(int arr[], int l, int r)
    {
        GfG g = new GfG();
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            g.merge(arr, l, m, r);
        }
    }

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			GfG g = new GfG();
			
			//calling the method mergeSort
			mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}


// } Driver Code Ends


/* The task is to complete merge() which is used
in below mergeSort() */
class GfG
{
   // Merges two subarrays of arr[].  First subarray is arr[l..m]
   // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int n1, n2;
         n1=m-l+1;
         n2=r-m;
         int le[]=new int[n1];
         int ri[]=new int[n2];
         for(int i=0;i<n1;i++)
            le[i]=arr[l+i];
         for(int i=0;i<n2;i++)
            ri[i]=arr[m+1+i];
         int k=l, i=0, j=0;
         while(i<n1 && j<n2){
            if(le[i]<=ri[j]){
                arr[k]=le[i];
                i++;
            }
            else{
                arr[k]=ri[j];
                j++;
            }
            k++;
         }
         while(i<n1){
            arr[k]=le[i];
            i++;
            k++;
         }
         while(j<n2){
             arr[k]=ri[j];
             j++;
             k++;
         }
         
    }
}

 /* This method is present in a class other than GfG class .
static void mergeSort(int arr[], int l, int r)
 {
    GfG g = new GfG();
    if (l < r)   
   {
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr , m+1, r);
        g.merge(arr, l, m, r);
    }
}*/
