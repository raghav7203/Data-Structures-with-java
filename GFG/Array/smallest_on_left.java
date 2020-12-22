/*
Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.

Input:

The first line of input contains T test cases. 

The first line of each test case contains the number of elements in the array.

The second line of each test case contains the elements of the array.

Output:

Print the n elements.
Constraints:

1<=T<=100

1<=N<=100

0<=A[i]<10000
Example:

Input:

2

3

1 6 2

6

1 5 0 3 4 5

Output:

-1 1 1

-1 1 -1 0 3 4
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
		    leftMin(a,n);
		    System.out.println();
		}
	}
	public static void leftMin(int a[], int n){
	    for(int i=0;i<n;i++){
	        int min=-1;
	        for(int j=0;j<i;j++){
	            if(a[j]<a[i]){
	                min=a[j];
	            }
	        }
	        System.out.print(min+" ");
	    }
	}
}
