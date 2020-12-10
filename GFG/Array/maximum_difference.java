/*
You are given an array A (distinct elements) of size N. Find out the maximum difference between any two elements such that larger element appears after the smaller number in A.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line of each test case is N,N is the size of array. The second line of each test case contains N elements separated by spaces.

Output:
For each testcase, print the maximum difference between two element. Otherwise print -1

Constraints:
1 <= T <= 100
2 <= N <= 107
0 <= Ai <= 107

Example:
Input:
2
7
2 3 10 6 4 8 1
6
7 9 5 6 3 2

Output:
8
2
Explanation:
Testcase1:  Array is [2, 3, 10, 6, 4, 8, 1] then returned value is 8 (Diff between 10 and 2).
Testcase2: Array is [ 7, 9, 5, 6, 3, 2 ] then returned value is 2 (Diff between 7 and 9).
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++){
		    int n=Integer.parseInt(br.readLine());
		    String s[]=br.readLine().trim().split("\\s");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s[i]);
		    int min=0, max=0;
		    int d=-1;
		    min=a[0];
		    for(int i=1;i<n;i++){
		        if(a[i]>min){
		            d=Math.max(d, a[i]-min);
		        }
		        else
		            min=a[i];
		    }
		    
		    System.out.println(d);
		}
	}
}
