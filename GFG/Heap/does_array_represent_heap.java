/*
Given an array A of size N, the task is to check if the given array represents a Binary Max Heap.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains an integer N denoting the size of the array. Then in the next line are N space separated array elements.

Output:
If array represents a Binary Max Heap, print "1", else print "0" (without quotes).

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1015

Example:
Input:
2
6
90 15 10 7 12 2
6
9 15 10 7 12 11

Output:
1
0

Explanation:
Testcase 1: Array of first elements represents Binary Max Heap, so output is 1.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++){
		    int n=Integer.parseInt(br.readLine().trim());
		    int a[]=new int[n];
		    String s[]=br.readLine().trim().split("\\s+");
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s[i]);
		    int f=1, i=0;
		    while(i<n){
		        if(2*i+2<n){
		            if(a[i]<a[2*i+1] || a[i]<a[2*i+2]){
		                f=0;
		                break;
		            }
		        }
		        else if(2*i+1<n){
		            if(a[i]<a[2*i+1]){
		                f=0;
		                break;
		            }
		        }
		        i++;
		    }
		    System.out.println(f);
		}
	}
}
