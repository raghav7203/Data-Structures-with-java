/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.

Input:
The first line contains an integer 'T' denoting the total number of test cases. T test-cases follow. In each test cases, the first line contains an integer 'N' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array. The elements of the array represents the height of the bars.

Output:
For each test-case, in a separate line, the maximum rectangular area possible from the contiguous bars.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 104

Example:
Input: 
2
7
6 2 5 4 5 1 6
4
6 3 4 2
Output:
12
9
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
		    ArrayList<Integer> nsl=new ArrayList<>(); //nearest smaller left
		    ArrayList<Integer> nsr=new ArrayList<>(); //nearest smaller right
		    for(int i=0;i<n;i++){
		        if(st.isEmpty()){
		            nsl.add(-1);
		            st.push(new node(a[i], i));
		            continue;
		        }
		        while(!st.isEmpty()){
		            if(st.peek().data<a[i]){
		                nsl.add(st.peek().index);
		                st.push(new node(a[i], i));
		                break;
		            }
		            else
		                st.pop();
		        }
		        if(st.isEmpty()){
		            nsl.add(-1);
		            st.push(new node(a[i], i));
		        }
		    }
		  //  System.out.println(nsl);
		  Stack<node> st1=new Stack<>();
		  for(int i=n-1;i>=0;i--){
		      if(st1.isEmpty()){
		          nsr.add(n); // n is kind of pseudo index here just like -1 for boundaries
		          st1.push(new node(a[i], i));
		          continue;
		      }
		      while(!st1.isEmpty()){
		          if(st1.peek().data<a[i]){
		              nsr.add(st1.peek().index);
		              st1.push(new node(a[i], i));
		              break;
		          }
		          else
		            st1.pop();
		      }
		      if(st1.isEmpty()){
		          nsr.add(n);
		          st1.push(new node(a[i], i));
		      }
		  }
		  ArrayList<Integer> nsr1=new ArrayList<>();
		  for(int i=nsr.size()-1;i>=0;i--)
		      nsr1.add(nsr.get(i));
		  
		  int width[]=new int[n];
		  for(int i=0;i<n;i++)
		    width[i]=nsr1.get(i)-nsl.get(i)-1;
		  
		  int area[]=new int[n];
		  for(int i=0;i<n;i++)
		    area[i]=width[i]*a[i];
		    
		  int max=0;
		  for(int i=0;i<n;i++){
		      if(area[i]>max)
		        max=area[i];
		  }
		  System.out.println(max);
		}
	}
}
