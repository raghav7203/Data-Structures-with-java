/*
Given an array, write a program that prints 1 if array represents Inorder traversal of a BST, else prints 0. Note that all keys in BST must be unique.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the size of array. The second line of each test case contains N input C[i].

Output:
Print 1 array represents BST, else 0.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 500
1 ≤ Keys in BST ≤ 1200

Example:
Input
3
5
10 20 30 40 50
6
90 80 100 70 40 30
3
1 1 2

Output
1
0
0
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
		    for(int i=0;i<n;i++){
		        a[i]=s.nextInt();
		    }
		    int f=1;
		    for(int i=0;i<n-1;i++){
		        if(a[i]>=a[i+1]){
		            f=0;
		            break;
		        }
		    }
		    System.out.println(f);
		}
	}
}
