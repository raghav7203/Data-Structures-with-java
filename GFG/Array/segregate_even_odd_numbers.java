/*
Given an array A[], write a program that segregates even and odd numbers. The program should put all even numbers first in sorted order, and then odd numbers in sorted order.

Input:
The first line of input contains an integer T, denoting the number of test cases. For each testcase there will be two lines of input: The first line contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, print the segregated array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
0 ≤A[i]<=105

Example:
Input:
2
7
12 34 45 9 8 90 3
5
0 1 2 3 4
Output:
8 12 34 90 3 9 45
0 2 4 1 3
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
		    ArrayList<Integer> even=new ArrayList<>();
		    ArrayList<Integer> odd=new ArrayList<>();
		    int n=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=s.nextInt();
		        if(a[i]%2==0)
		            even.add(a[i]);
		        else
		            odd.add(a[i]);
		    }
		    Collections.sort(even);
		    Collections.sort(odd);
		    for(int i:even)
		        System.out.print(i+" ");
		    for(int i:odd)
		        System.out.print(i+" ");
		    System.out.println();
		}
	}
}
