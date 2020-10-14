/*
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Note: If the number x is not found in the array just print '-1'.

Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case contains two integers n and x. The second line contains n spaced integers.

Output:
Print index of the first and last occurrences of the number x with a space in between.

Constraints: 
1<=T<=100
1<=n,a[i]<=1000

Example:
Input:
2
9 5
1 3 5 5 5 5 67 123 125
9 7
1 3 5 5 5 5 7 123 125

Output:
2 5
6 6
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
    		int k=Integer.parseInt(s1[1]);
    		int a[]=new int[n];
    		String s2[]=br.readLine().trim().split("\\s+");
    		for(int i=0;i<n;i++)
    		    a[i]=Integer.parseInt(s2[i]);
    		
    		int first=getFirst(a, 0, n-1, k);
    		int last=getLast(a, 0, n-1, k);
    		
    		if(first==-1 && last==-1)
    		    System.out.println(-1);
    		else
    		    System.out.println(first+" "+last);
		}
	}
	public static int getLast(int a[], int l, int r, int k){
	    int ans=-1, mid=0;
	    while(l<=r){
	        mid=(l+r)/2;
	        if(a[mid]==k){
	            ans=mid;
	            l=mid+1;
	        }
	        else if(a[mid]<k)
	            l=mid+1;
	        else
	            r=mid-1;
	    }
	    return ans;
	}
	public static int getFirst(int a[], int l, int r, int k){
	    int ans=-1, mid=0;
	    while(l<=r){
	        mid=(l+r)/2;
	        if(a[mid]==k){
	            ans=mid;
	            r=mid-1;
	        }
	        else if(a[mid]<k)
	            l=mid+1;
	        else
	            r=mid-1;
	    }
	    return ans;
	}
}
