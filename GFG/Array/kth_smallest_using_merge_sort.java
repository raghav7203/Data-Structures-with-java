/*
Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the kth smallest element in a new line.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4
Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.
Testcase 2: 4th smallest elemets in the given array is 15.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s=new Scanner(System.in);
		    int test=s.nextInt();
		    for(int t=1;t<=test;t++){
		        int n=s.nextInt();
		        int a[]=new int[n];
		        for(int i=0;i<n;i++){
		            a[i]=s.nextInt();
		        }
		        int k=s.nextInt();
		      //  Arrays.sort(a);
		        mergesort(a, 0, n-1);
		        System.out.println(a[k-1]);
		    }
	}
	static void merge(int a[], int l, int m, int r){
	    int n1=m-l+1;
	    int n2=r-m;
	    int L[]=new int[n1];
	    int R[]=new int[n2];
	    for(int i=0;i<n1;i++){
	        L[i]=a[l+i];
	    }
	    for(int i=0;i<n2;i++){
	        R[i]=a[m+1+i];
	    }
	    int k=l, i=0, j=0;
	    while(i<n1 && j<n2){
	        if(L[i]<R[j]){
	            a[k]=L[i];
	            i++;
	        }
	        else{
	            a[k]=R[j];
	            j++;
	        }
	        k++;
	    }
	    while(i<n1){
	        a[k]=L[i];
	        i++;
	        k++;
	    }
	    while(j<n2){
	        a[k]=R[j];
	        j++;
	        k++;
	    }
	}
	static void mergesort(int a[], int l, int r){
	    if(l<r){
	        int m=(l+r)/2;
	        mergesort(a, l, m);
	        mergesort(a, m+1, r);
	        merge(a, l, m, r);
	    }
	}

// 	static int partition(int a[], int l, int r){
// 	    int p=a[r];
// 	    int i=l-1;
// 	    for(int j=l;j<r;j++){
// 	        if(a[j]<p){
// 	            i++;
// 	            int t=a[i];
// 	            a[i]=a[j];
// 	            a[j]=t;
// 	        }
// 	    }
// 	    int t=a[i+1];
// 	    a[i+1]=a[r];
// 	    a[r]=t;
// 	    return i+1;
// 	}
// 	static void quicksort(int a[], int l, int r){
// 	    if(l<r){
// 	        int p=partition(a, l, r);
// 	        quicksort(a, l, p-1);
// 	        quicksort(a, p+1, r);
// 	    }
// 	}
}
