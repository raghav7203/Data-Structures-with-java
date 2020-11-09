/*
Given an array arr[] and an integer K, you have to Add the first two minimum elements of the array until all the elements are greater than or equal to K and find the number of such operations required. 

Examples:

Input : arr[] = {1 10 12 9 2 3}
          K = 6
Output : 2
First we add (1 + 2), now the new list becomes 
3 10 12 9 3, then we add (3 + 3),  now the new 
list becomes 6 10 12 9, Now all the elements in 
the list are greater than 6. Hence the output is 
2 i:e 2 operations are required 
to do this. 
Input :  The first line of input contains an integer T denoting the Test cases. Then T test cases follow.  Second line contains no. of array elements - N and K Third line array elements A[i] 

Output : 
Print number of operations required. If it is not possible to make elements greater than or equal to K, print "-1".

Constraints :
1 ≤ T ≤ 50
1 ≤ N, K ≤ 10^5
1 ≤ A[i] ≤ 10^6

Input : 
2
6 6
1 10 12 9 2 3
5 15
1 2 1 2 2
Output : 
2
-1
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
		    int f=0, c=0;
		    
		    for(int i=0;i<n;i++){
		        minHeap.add(a[i]);
		    }
		    
		    for(int i=0;i<n;i++){
		        if(minHeap.peek()>=k){
		            f=1;
		            break;
		        }
		        int n1=minHeap.poll();
		        if(minHeap.size()==0)
		            break;
		        int n2=minHeap.poll();
		        minHeap.add(n1+n2);
		        c++;
		    }
		    if(f==0)
		        System.out.println(-1);
		    else
		        System.out.println(c);
		}
	}
}
