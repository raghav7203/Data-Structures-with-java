/*
Given an array of positive integers where all numbers occur even number of times except one number which occurs odd number of times. Find the number.

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array. The second line of each test case contains N space separated integers denoting array elements.

 

Output:
Corresponding to each test case, print the number which occur odd number of times. If no such element exists, print 0.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ A[i] ≤ 106

Example:
Input:
1
5
8 4 4 8 23
Output:
23

Explanation:
Testcase 1: 23 is the element which occurs odd number of times.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++){
		    int n=Integer.parseInt(br.readLine());
		    String s[]=br.readLine().trim().split("\\s");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s[i]);
		  //  HashMap<Integer, Integer> map=new HashMap<>();
		  //  for(int i:a){
		  //      if(map.containsKey(i))
		  //          map.replace(i, map.get(i)+1);
		  //      else
		  //          map.put(i, 1);
		  //  }
		  //  int r=0;
		  //  for(int i:a){
		  //      if((map.get(i)%2)!=0){
		  //          r=i;
		  //          break;
		  //      }
		  //  }
		  //  System.out.println(r);
		  // xor of two same no is zero
		  int xor=a[0];
		  for(int i=1;i<n;i++){
		      xor=xor^a[i];
		  }
		  System.out.println(xor);
		}
	}
}
