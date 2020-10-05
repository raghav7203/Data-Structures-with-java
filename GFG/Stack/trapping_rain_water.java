/*
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.



Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains an integer N denoting the size of the array, followed by N space separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.
*/

/*package whatever //do not write package name here */



// THE APPROACH OF THIS CODE MAY BE RIGHT BUT THIS IS NOT WORKING ON GFG (TLE GIVING) 

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
		        
		    int ml[]=new int[n];
		  //  int temp=a[0];
		  //  for(int i=0;i<n;i++){
		  //      if(a[i]>temp)
		  //          temp=a[i];
		  //      ml[i]=temp;
		  //  }
		    
		    int mr[]=new int[n];
		  //  temp=a[n-1];
		  //  for(int i=n-1;i>=0;i--){
		  //      if(a[i]>temp)
		  //          temp=a[i];
		  //      mr[i]=temp;
		  //  }
		    
		    int temp1=a[0], temp2=a[n-1];
		    for(int i=0, j=n-1;i<n;i++, j--){
		        if(a[i]>temp1)
		            temp1=a[i];
		        ml[i]=temp1;
		        if(a[j]>temp2)
		            temp2=a[j];
		        mr[j]=temp2;
		    }
		    
		    int ans=0;
		  //  int water[]=new int[n];
		  //  for(int i=0;i<n;i++)
		  //      water[i]=Math.min(ml[i], mr[i])-a[i];
		      for(int i=0;i<n;i++)
		        ans+=Math.min(ml[i], mr[i])-a[i];
		  
		  //  for(int i=0;i<n;i++)
		  //      ans+=water[i];
		    
		    System.out.println(ans);
		}
	}
}
