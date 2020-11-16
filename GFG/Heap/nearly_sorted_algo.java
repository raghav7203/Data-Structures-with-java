/*
Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

Input:
First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k positions away from its target position respectively. Second line of every test case consists of elements of array.

Output:
Single line output to print the sorted array.

Constraints:
1<=T<=100
1<=N<=100
1<=K<=N

Example:
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56
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
		    
		    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		    ArrayList<Integer> al=new ArrayList<>();
		    
		    for(int i=0;i<n;i++){
		      minHeap.add(a[i]);
		      if(minHeap.size()>k)
		        al.add(minHeap.poll());
		    }
		    while(!minHeap.isEmpty()){
		        al.add(minHeap.poll());
		    }
		    for(int i:al)
		        System.out.print(i+" ");
		    System.out.println();
		}
	}
}
