/*
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106
*/

import java.util.*;


 // } Driver Code Ends


class Missing{
    
    // function to find first positive missing number
    static int missingNumber(int arr[], int size)
    {
        
        // Your code here
        // You can add utility functions (if required)
        int max=0;
        for(int i:arr){
            if(i>max)
                max=i;
        }
        int a[]=new int[max+1];
        for(int i=0;i<size;i++){
            if(arr[i]>0){
                a[arr[i]]=1;
            }
        }
        // for(int i:a)
        //     System.out.print(i+" ");
        // System.out.println();
        for(int i=1;i<a.length;i++){
            if(a[i]==0)
                return i;
        }
        return a.length;
    }
    
}


// { Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Missing obj = new Missing();
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

  // } Driver Code Ends
