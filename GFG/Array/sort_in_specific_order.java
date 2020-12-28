/*
Given an array A of positive integers. Your task is to sort them in such a way that the first part of the array contains odd numbers sorted in descending order, rest portion contains even numbers sorted in ascending order.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the array. The next line contains N space separated values of the array.

Output:
For each test case in a new line print the space separated values of the modified array.

Constraints:
1 <= T <= 103
1 <= N <= 107
0 <= Ai <= 1018

Example:
Input:
2
7
1 2 3 5 4 7 10
7
0 4 5 3 7 2 1

Output:
7 5 3 1 2 4 10
7 5 3 1 0 2 4

Explanation:
Testcase1: Array elements 7 5 3 1 are odd and sorted in descending order, whereas 2 4 10 are even numbers and sorted in ascending order.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
// 		Scanner s=new Scanner(System.in);
// 		int test=s.nextInt();
// 		for(int t=1;t<=test;t++){
// 		    int n=s.nextInt();
// 		    int a[]=new int[n];
// 		    for(int i=0;i<n;i++)
// 		        a[i]=s.nextInt();
// 		    ArrayList<Integer> odd=new ArrayList<Integer>();
// 		    ArrayList<Integer> even=new ArrayList<Integer>();
// 		    for(int i:a){
// 		        if(i%2==0)
// 		            even.add(i);
// 		        else
// 		            odd.add(i);
// 		    }
// 		    Collections.sort(even);
// 		    Collections.sort(odd);
// 		    ArrayList<Integer> res=new ArrayList<>();
// 		    for(int i=odd.size()-1;i>=0;i--)
// 		        res.add(odd.get(i));
// 		    for(int i:even)
// 		        res.add(i);
// 		    for(int i:res)
// 		        System.out.print(i+" ");
// 		    System.out.println();
		      
// 		}
        
		Scanner s=new Scanner(System.in);
		int test=s.nextInt();
		for(int t=1;t<=test;t++){
		    int n=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=s.nextInt();
		        if(a[i]%2!=0)
		            a[i]=-a[i];
		    }
		    Arrays.sort(a);
		    for(int i:a){
		        if(i%2!=0)
		            i=-i;
		        System.out.print(i+" ");
		    }
		    System.out.println();
		}
	}
}
