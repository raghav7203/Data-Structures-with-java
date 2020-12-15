/*
Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
Note: Expected time complexity is O(N log(N)).

Input:
First line of input contains number of testcases. For each testcase, first line of input contains length of arrays N and M and next two line contains N and M elements respectively.

Output:
Print the relatively sorted array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N,M  ≤ 106
1 ≤ A1[], A2[] <= 106

Example:
Input:
2
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3
8 4
2 6 7 5 2 6 8 4 
2 6 4 5
Output:
2 2 1 1 8 8 3 5 6 7 9
2 2 6 6 4 5 7 8

Explanation:
Testcase 1: After sorting the resulted output is 2 2 1 1 8 8 3 5 6 7 9.
Testcase 2: After sorting the resulted output is 2 2 6 6 4 5 7 8.
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
		    int m=s.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    for(int i=0;i<n;i++)
		        a1[i]=s.nextInt();
		    for(int i=0;i<m;i++)
		        a2[i]=s.nextInt();
		    HashMap<Integer, Integer> map=new HashMap<>();
		    for(int i=0;i<n;i++){
		        if(map.containsKey(a1[i])){
		            int temp=map.get(a1[i]);
		            map.replace(a1[i], temp+1);
		        }
		        else{
		            map.put(a1[i], 1);
		        }
		    }
		    ArrayList<Integer> a=new ArrayList<>();
		    for(int i=0;i<m;i++){
		        if(map.containsKey(a2[i])){
		            for(int j=1;j<=map.get(a2[i]);j++){
		                a.add(a2[i]);
		            }
		            map.remove(a2[i]);
		        }
		    }
		    ArrayList<Integer> key=new ArrayList<>();
		    for(int i:map.keySet()){
		        for(int j=0;j<map.get(i);j++){
		            key.add(i);
		        }
		    }
		    int fix[]=new int[key.size()];
		    for(int i=0;i<key.size();i++)
		        fix[i]=key.get(i);
		 
		    Arrays.sort(fix);
		    for(int i=0;i<fix.length;i++)
		        a.add(fix[i]);
		        
		   for(int i=0;i<a.size();i++)
		    System.out.print(a.get(i)+" ");
		    
		    System.out.println();
		}
	}
}
