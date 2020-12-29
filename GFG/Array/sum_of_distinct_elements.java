/*
You are given an array of size N. Find the sum of distinct elements in an array.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input:
The first line is N, the size of array.
The second line contains N elements separated by spaces.

Output:
For each testcase, print the sum of all distinct elements.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 103

Example:
Input:
3
5
1 2 3 4 5
5
5 5 5 5 5
4
22 33 22 33
Output:
15
5
55
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
		    HashMap<Integer, Integer> map=new HashMap<>();
		    for(int i=0;i<n;i++){
		        if(map.containsKey(a[i]))
		            map.replace(a[i], map.get(a[i])+1);
		        else
		            map.put(a[i], 1);
		    }
            ArrayList<Integer> k=new ArrayList<>(map.keySet());
            int sum=0;
            for(int i:k)
                sum+=i;
            System.out.println(sum);
		}
	}
}
