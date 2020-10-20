/*
Given a sorted array. Write a program that creates a Balanced Binary Search Tree using array elements. If there are N elements in array, then floor(n/2)'th element should be chosen as root and same should be followed recursively.

Input:
The first line of input contains an integer T, denoting the number of test cases. The first line of each test case is N(size of array). The second line of each test case contains N input A[].

Output:
Print the preorder traversal of constructed BST.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 1000
1 ≤ A[i] ≤ 10000

Example:
Input:
1
7
1 2 3 4 5 6 7

Output:
4 2 1 3 6 5 7
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=1;i<=t;i++){
		    int n=s.nextInt();
    		int a[]=new int[n];
    		for(int j=0;j<n;j++){
    		    a[j]=s.nextInt();
		    }
		    bst(a, 0, n-1);
                
            System.out.println();
		}
		
	}
	static void bst(int a[], int l, int r){
	    if(l<=r){
	        int mid=(l+r)/2;
	        System.out.print(a[mid]+" ");
	        
	        
	            bst(a, l, mid-1);
	            bst(a, mid+1, r);
	    }
	        
	}
}
