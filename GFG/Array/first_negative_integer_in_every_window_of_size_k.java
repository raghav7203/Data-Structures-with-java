/*
Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains n space separated integers forming the array. The last line contains the window size k.

Output:
Print the space separated negative integer starting from the first till the end for every window size k. If a window does not contain a negative integer , then print 0 for that window.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5
1<=k<=n

Example:
Input:
2
5
-8 2 3 -6 10
2
8
12 -1 -7 8 -15 30 16 28
3

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0
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
		    int k=s.nextInt();
		    int f=0;
		    Queue<Integer> q=new LinkedList<>();
		    for(int i=0;i<n;i++){
		        q.add(a[i]);
		        if(q.size()==k){
		            f=0;
		            for(int j=0;j<k;j++){
		                if(a[i-k+1+j]<0){
		                    f=1;
		                    System.out.print(a[i-k+1+j]+" ");
		                    q.poll();
		                    break;
		                }
		            }
		            if(f==0){
		                System.out.print(0+" ");
		                q.poll();
		            }
		        }
		    }
		    System.out.println();
		}
	}
}
