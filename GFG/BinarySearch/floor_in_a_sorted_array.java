/*
Given a sorted array arr[] of size N without duplicates, and given a value x. Find the floor of x in given array. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array and element whose floor is to be searched. Last line of input contains array elements.

Output:
Output the index of floor of x if exists, else print -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]

Example:
Input:
3
7 0
1 2 8 10 11 12 19
7 5
1 2 8 10 11 12 19
7 10
1 2 8 10 11 12 19

Output:
-1
1
3

Explanation:
Testcase 1: No element less than 0 is found. So output is "-1".
Testcase 2: Number less than 5 is 2, whose index is 1(0-based indexing).
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
		    String s1[]=br.readLine().trim().split("\\s+");
		    int n=Integer.parseInt(s1[0]);
		    int x=Integer.parseInt(s1[1]);
		    String s2[]=br.readLine().trim().split("\\s+");
		    long a[]=new long[n];
		    for(int i=0;i<n;i++)
		        a[i]=Long.parseLong(s2[i]);
		    
		    int res=getIndex(a, 0, n-1, x);
		    System.out.println(res);
		}
	}
	public static int getIndex(long a[], int l, int r, int x){
	    int mid=0, ans=-1;
	    if(x>a[a.length-1])
	        return a.length-1;
	    if(x<a[0])
	        return -1;
	    while(l<=r){
	        mid=(l+r)/2;
	        if(a[mid]==x){
	            ans=mid;
	            break;
	        }
	        if(a[mid]<x){
	            ans=mid;
	            l=mid+1;
	        }
	        else if(a[mid]>x)
	            r=mid-1;
	    }
	    return ans;
	}
}
