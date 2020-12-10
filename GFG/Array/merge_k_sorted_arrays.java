/*
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be 
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
6, 6, 7, 8, 9, 9 ].
Your Task:
You need to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays. The function should return the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList<Integer> in java, and list in python)

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)

Note: This space is required for returning the resulted sorted array, other work should be done in O(K) Auxiliary Space.

Constraints:
1 <= K <= 100
*/


//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

/*Complete the function below*/
class Solution{
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        // Write your code here.
        ArrayList<Integer> res=new ArrayList<>();
        int a[]=new int[k*k];
        int c=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                a[c]=arrays[i][j];
                c++;
            }
        }
        quicksort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++)
            res.add(a[i]);
        return res;
        
    }
    static int partition(int a[], int l, int r){
        int p=a[r], i=l-1;
        for(int j=l;j<r;j++){
            if(a[j]<p){
                i++;
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        int t=a[i+1];
        a[i+1]=a[r];
        a[r]=t;
        return i+1;
    }
    static void quicksort(int a[], int l, int r){
        if(l<r){
            int p=partition(a, l, r);
            quicksort(a, l, p-1);
            quicksort(a, p+1, r);
        }
    }
}
