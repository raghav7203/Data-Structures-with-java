/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. The task is to find the index of the given element K in the array A.

Input:
The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given array. Second line of each test case contains N space separated integers denoting the elements of the array A. Third line of each test case contains an integer K denoting the element to be searched in the array.

Output:
Corresponding to each test case, output the index of the element found in the array.  If element is not present, then output -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 ≤ Ai ≤ 108
1 ≤ K ≤ 108

Example:
Input:
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6

Output:
5
1
-1

Explanation:
Testcase 1: 10 is found at index 5.
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
		    int n=Integer.parseInt(br.readLine().trim());
		    int a[]=new int[n];
		    String s[]=br.readLine().trim().split("\\s+");
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s[i]);
		    int k=Integer.parseInt(br.readLine().trim());
		    
		    int minIndex=getMin(a, 0, n-1, n);
		  //  System.out.println("minIndex "+minIndex+" "+a[minIndex]);
		   
		    int first=bs(a, 0, minIndex-1, k);
		    int second=bs(a, minIndex, n-1, k);
		  
		  //  System.out.println(first+" "+second);
		    
		    if(first==-1 && second==-1)
		        System.out.println(-1);
		    else if(first==-1)
		        System.out.println(second);
		    else
		        System.out.println(first);
		        
		}
	}
	public static int bs(int a[], int l, int r, int k){
	    int mid=0, ans=-1;
	    while(l<=r){
	        mid=(l+r)/2;
	        if(a[mid]==k){
	            ans=mid;
	            break;
	        }
	        else if(a[mid]<k)
	            l=mid+1;
	        else
	            r=mid-1;
	    }
	    return ans;
	}
	public static int getMin(int a[], int l, int r, int n){
	    int mid=0, ans=0;
	    
	    while(l<=r){
	        if(a[l]<=a[r]){ // this if condn is imp when mid+1 is smallest then there will be a sorted array and below algo wont work then
	            ans=l;
	            break;
	        }
	        mid=(l+r)/2;
	        int next=(mid+1)%n;
	        int prev=(mid-1+n)%n;
	        if(a[mid]<=a[next] && a[mid]<=a[prev]){
	            ans=mid;
	            break;
	        }
	        else if(a[l]<=a[mid])
	            l=mid+1;
	        else if(a[mid]<=a[r])
	            r=mid-1;
	    }
	    return ans;
	}
}
