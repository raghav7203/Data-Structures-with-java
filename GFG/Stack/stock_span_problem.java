/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the size of the array. The second line of each test case contains N input C[i].

Output:
For each testcase, print the span values for all days.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 200
1 ≤ C[i] ≤ 800

Example:
Input:
2
7
100 80 60 70 60 75 85
6
10 4 5 90 120 80

Output:
1 1 1 2 1 4 6
1 1 2 4 5 1
*/


import java.util.*;
import java.lang.*;
import java.io.*;
class node{
    int data, index;
    public node(int data, int index){
        this.data=data;
        this.index=index;
    }
}
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
		    Stack<node> st=new Stack<>();
		    ArrayList<Integer> al=new ArrayList<>();
		    for(int i=0;i<n;i++){
		        if(st.isEmpty()){
		            al.add(-1);
		            st.push(new node(a[i], i));
		            continue;
		        }
		        while(!st.isEmpty()){
		            if(st.peek().data>a[i]){
		                al.add(st.peek().index);
		                st.push(new node(a[i], i));
		                break;
		            }
		            else
		                st.pop();
		        }
		        if(st.isEmpty()){
		            al.add(-1);
		            st.push(new node(a[i], i));
		        }
		    }
		  //  System.out.println(al);
		  for(int i=0;i<al.size();i++)
		      System.out.print(i-al.get(i)+" ");
		 
		  System.out.println();
		}
	}
}
