/*
Given an array containing N integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains two Integers N and K and the second line contains N space separated elements of the array.

Output:
For each test case, print the required lenght of the longest Sub-Array in new line. If no such sub array can be formed print 0.

Constraints:
1<=T<=500
1<=N,K<=105
-105<=A[i]<=105

Example:
Input:
3
6 15
10 5 2 7 1 9
6 -5
-5 8 -14 2 4 12
3 6
-1 2 3
Output:
4
5
0
Explanation:
TestCase 1:

Input : arr[] = { 10, 5, 2, 7, 1, 9 }, 
K = 15
Output : 4
The sub-array is {5, 2, 7, 1}.
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
		    String s1[]=br.readLine().trim().split("\\s");
		    int n=Integer.parseInt(s1[0]);
		    int k=Integer.parseInt(s1[1]);
		    String s2[]=br.readLine().trim().split("\\s");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s2[i]);
            HashMap<Integer, Integer> map=new HashMap<>();
            int c=0, sum=0;
            map.put(0, -1);
            for(int i=0;i<n;i++){
                sum+=a[i];
                if(map.containsKey(sum-k))
                    c=Math.max(c, i-map.get(sum-k));
                if(!map.containsKey(sum))
                    map.put(sum, i);
            }
            System.out.println(c);
		}
	}
}
