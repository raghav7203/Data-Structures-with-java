/*
Given an array of distinct positive numbers, the task is to calculate the minimum number of subsets (or subsequences) from the array such that each subset contains consecutive numbers.

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(1)

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N, denoting the length of the array. Next line contains N space seperated integers of the array. 

Output:
For each test case output a new line denoting count of number of such subset's that contains consecutive numbers.

Your task:
You don't have to print anything, printing is done by the driver code itself. Complete the function numofsubset() and return the answer.

Constraints:
1<=T<=30
1<=N<=105

Example:
Input
2
10
100 56 5 6 102 58 101 57 7 103 
3
10 100 105

Output
3
3

Explanation
Test Case 1 -
{5, 6, 7}, { 56, 57, 58}, {100, 101, 102, 103} are 3 subset in which numbers are consecutive.

Test Case 2 -
{10}, {100} and {105} are 3 subset in which numbers are consecutive.
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
		    Arrays.sort(a);
		    int c=1, f=0;
		    for(int i=0;i<n-1;i++){
		        if(a[i+1]-a[i]!=1){
		            c++;
		        }
		    }
		    System.out.println(c);
		}
	}
}
