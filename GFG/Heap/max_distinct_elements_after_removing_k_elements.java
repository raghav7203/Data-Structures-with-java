/*
Given an array containing N elements. The task is to find maximum number of distinct elements after removing K elements from the array.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains two Integers N and K and the second line contains N space separated elements.

Output:
For each test case, print the maximum distinct elements after removing K elements in new line.

Constraints:
1<=T<=100
1<=K<=N<=106
1<=A[i]<=105

Example:
Input:
2
7 3
5 7 5 5 1 2 2
7 5
1 2 3 4 5 6 7
Output:
4
2

Explanation:

Input : A[] = {5, 7, 5, 5, 1, 2, 2}, K = 3
Output : 4
Remove 2 occurrences of element 5 and
1 occurrence of element 2.
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
		    
		    sortComparator comp=new sortComparator();
		    PriorityQueue<node> heap=new PriorityQueue<>(comp);
		    HashMap<Integer, Integer> map=new HashMap<>();
		    for(int i=0;i<n;i++){
		        if(map.containsKey(a[i]))
		            map.replace(a[i], map.get(a[i])+1);
		        else
		            map.put(a[i], 1);
		    }
		    ArrayList<Integer> al=new ArrayList<>(map.keySet());
		    
		    for(int i:al){
		        heap.add(new node(map.get(i), i));    
		    }
		    
		    while(k>0){
		        node temp=heap.poll();
		        int d=temp.data;
		        int c=temp.count;
		        c--;
		        if(c>0){
		            heap.add(new node(c, d));
		        }
		        k--;
		    }
		  
		    
		    System.out.println(heap.size());
		}
	}
}
class node{
    int count, data;
    public node(int count, int data){
        this.count=count;
        this.data=data;
    }
}
class sortComparator implements Comparator<node>{
    public int compare(node a, node b){
        return b.count-a.count;
    }
}
