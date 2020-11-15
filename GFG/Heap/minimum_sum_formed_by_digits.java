/*
Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Next line of each test contains N space seperated integers denoting the elements of the array.
Output:

For each test case output a single line containing the required sum.
Constraints:

1<=T<=100
1<=N<=50
Example:

Input

2
6
6 8 4 5 2 3
5
5 3 0 7 4

Output

604
82

Explanation:

Test Case 1-

The minimum sum is formed by numbers 
358 and 246
Test Case 2 -

The minimum sum is formed by numbers 
35 and 047
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
		    
		    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		    for(int i=0;i<n;i++){
		        minHeap.add(a[i]);
		    }
		    String s1="", s2="";
		    while(minHeap.size()>0){
		        s1+=minHeap.poll();
		        if(minHeap.size()==0)
		            break;
		        s2+=minHeap.poll();
		    }
		    int n1=Integer.parseInt(s1);
		    int n2=Integer.parseInt(s2);
		    System.out.println(n1+n2);
		}
	}
}
