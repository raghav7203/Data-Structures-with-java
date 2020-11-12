/*
Given an input stream of n integers, find the kth largest element for each element in the stream.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two lines. The first line of each test case contains two space separated integers k and n . Then in the next line are n space separated values of the array.

Output:
For each test case, in a new line, print the space separated values denoting the kth largest element at each insertion, if the kth largest element at a particular insertion in the stream doesn't exist print -1.

Constraints:
1 <= T <= 100
1 <= K <= n
1 <= n <= 106
1 <= stream[] <= 105

Example:
Input:
2
4 6
1 2 3 4 5 6
1 2
3 4

Output:
-1 -1 -1 1 2 3
3 4 

Explanation:
Testcase1:
k = 4
For 1, the 4th largest element doesn't exist so we print -1.
For 2, the 4th largest element doesn't exist so we print -1.
For 3, the 4th largest element doesn't exist so we print -1.
For 4, the 4th largest element is 1 {1, 2, 3, 4}
For 5, the 4th largest element is 2 {2, 3, 4 ,5}
for 6, the 4th largest element is 3 {3, 4, 5}
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
		    int k=Integer.parseInt(s1[0]);
		    int n=Integer.parseInt(s1[1]);
		    int a[]=new int[n];
		    String s2[]=br.readLine().trim().split("\\s+");
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s2[i]);
		    
		    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		    for(int i=0;i<n;i++){
		        if(i<k-1){
		            minHeap.add(a[i]);
		            System.out.print(-1+" ");
		        }
		        else if(i==k-1){
		            minHeap.add(a[i]);
		            System.out.print(minHeap.peek()+" ");
		        }
		        else{
		            if(a[i]>minHeap.peek()){
		                minHeap.poll();
		                minHeap.add(a[i]);
		            }
		            System.out.print(minHeap.peek()+" ");
		        }
		    }
		    System.out.println();
		}
	}
}
