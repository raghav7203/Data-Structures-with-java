/*
A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

Expected Time Complexity: O(Log n)

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array.
The second line of each test case contains N space separated integers denoting array elements.

Output:
Corresponding to each test case, in a new line, print the minimum element in the array.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 500
1 ≤ A[i] ≤ 1000

Example:

Input
2
5
4 5 1 2 3
6
10 20 30 40 50 5 7

Output
1
5
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
		        
		    int smallest=get(a, 0, n-1, n);
		    System.out.println(a[smallest]);
		}
	}
	public static int get(int a[], int l, int r, int n){
	    int mid=0, ans=0, prev=0, next=0;
	    while(l<=r){
	        if(a[l]<=a[r]){
	            ans=l;
	            break;
	        }
	        mid=l+(r-l)/2;
	        next=(mid+1)%n;
	        prev=(mid-1+n)%n;
	        if(a[mid]<=a[prev] && a[mid]<=a[next]){
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
