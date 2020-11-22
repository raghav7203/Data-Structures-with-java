/*
Given an array of integers, and an integer  ‘K’ , find the count of pairs of elements in the array whose sum is equal to 'K'.

Input:
First line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains 2 space separated integers N and K denoting the size of array and the sum respectively. Second line of each test case contains N space separated integers denoting the elements of the array.

Output:
Print the count of pairs of elements in the array whose sum is equal to the K.

Constraints:
1<=T<=50
1<=N<=50
1<=K<=50
1<=A[i]<=100

Example:
Input
2
4 6
1  5  7 1
4 2
1 1 1 1
Output
2
6
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
		    String s1[]=br.readLine().trim().split("\\s+");
		    int n=Integer.parseInt(s1[0]);
		    int k=Integer.parseInt(s1[1]);
		    String s2[]=br.readLine().trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s2[i]);
		    int c=0;
		    for(int i=0;i<n;i++){
		        for(int j=i+1;j<n;j++){
		            if(a[i]+a[j]==k)
		                c++;
		        }
		    }
		    System.out.println(c);
		}
	}
}
