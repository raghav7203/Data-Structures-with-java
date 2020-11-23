/*
Given an array A[] of size N. Find the number of pairs (i, j) such that A_i XOR A_j = 0, and 1 <= i < j <= N.

Input:
The first line of the input contains a single integer T denoting the number of test cases. The first line of each test case contains N. followed by N separate integers. 

Output:
For each test case, output a single integer i.e counts of Zeros Xors Pairs

Constraints
1 ≤ T ≤ 200
2 ≤ N ≤ 10^5
1 ≤ A[i] ≤ 10^5

Example:
Input :
2
5
1 3 4 1 4

3
2 2 2

Output :

2
3

Explanation :

Test Case 1: Index( 0, 3 ) and (2 , 4 ) are only pairs whose xors is zero so count is 2.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++){
		    int n=Integer.parseInt(br.readLine().trim());
		    int a[]=new int[n];
		    String s[]=br.readLine().trim().split("\\s");
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s[i]);
		    HashMap<Integer, Integer> map=new HashMap<>();
		    for(int i:a){
		        if(map.containsKey(i))
		            map.replace(i, map.get(i)+1);
		        else
		            map.put(i, 1);
		    }
		    ArrayList<Integer> key=new ArrayList<>(map.keySet());
		    int sum=0, hold=0;
		    for(int i:key){
		        hold=map.get(i);
		        if(hold>1){
		            sum+=(hold*(hold-1))/2;
		        }
		    }
		    System.out.println(sum);
		}
	}
}
