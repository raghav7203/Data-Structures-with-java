/*
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
        for(int t=1;t<=test;t++){
            int n=Integer.parseInt(br.readLine());
            int a[]=new int[n];
            String s[]=br.readLine().trim().split("\\s");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(s[i]);
            int sum=0, hold=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                sum+=a[i];
                if(sum>hold)
                    hold=sum;
                if(sum<0)
                    sum=0;
            }
            System.out.println(hold);
        }
	}
}
