/*
Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. The converted array should be in form a < b > c < d > e < f. The relative order of elements is same in the output i.e you have to iterate on the original array only.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line contains a single integer N denoting the size of array.
The second line contains N space-separated integers denoting the elements of the array.

Output:
For each testcase, print the array in Zig-Zag fashion.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= Ai <= 10000

Example:
Input:
2
7
4 3 7 8 6 2 1
4
1 4 3 2
Output:
3 7 4 8 2 6 1
1 4 2 3
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
		    for(int i=0;i<n;i++)
		        a[i]=s.nextInt();
		    for(int i=0;i<n-1;i++){
		        if(i%2==0){
		            if(a[i]>a[i+1]){
		                int t1=a[i];
		                a[i]=a[i+1];
		                a[i+1]=t1;
		            }
		        }
		        else{
		            if(a[i]<a[i+1]){
		                int t2=a[i];
		                a[i]=a[i+1];
		                a[i+1]=t2;
		            }
		        }
		    }
		    for(int i:a)
		        System.out.print(i+" ");
		    System.out.println();
		}
	}
}
