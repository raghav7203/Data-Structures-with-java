/*
Given number of edges 'E' and vertices 'V' of a bidirectional graph. Your task is to build a graph through adjacency list and print the adjacency list for each vertex.

Input:
The first line of input is T denoting the number of testcases.Then first line of each of the T contains two positive integer V and E where 'V' is the number of vertex and 'E' is number of edges in graph. Next, 'E' line contains two positive numbers showing that there is an edge between these two vertex.

Output:
For each vertex, print their connected nodes in order you are pushing them inside the list . See the  given  example.

Constraints:
1 <= T <= 200
1 <= V <= 103
1 <= E = V*(V-1)

Example:
Input:
2
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
3 3
0 1
1 2
2 0

Output:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
0-> 1-> 2
1-> 0-> 2
2-> 1-> 0

Explanation:
Testcase 1: Given graph has 5 nodes and 7 edges. After creating adjacency list of given graph, we have list as:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
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
		    int v=s.nextInt();
		    int e=s.nextInt();
		    ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
		    for(int i=0;i<v;i++){
		        a.add(new ArrayList<Integer>(i));
		    }
		    for(int i=0;i<e;i++){
		        int v1=s.nextInt();
		        int v2=s.nextInt();
		        make(v1, v2, a);
		    }
		    print(a);
		}
	}
	static void print(ArrayList<ArrayList<Integer>> a){
	    for(int i=0;i<a.size();i++){
	        ArrayList<Integer> temp=a.get(i);
	        System.out.print(i);
	        for(int j=0;j<temp.size();j++){
	            System.out.print("-> "+temp.get(j));
	        }
	        System.out.println();
	    }
	}
	static void make(int v1, int v2, ArrayList<ArrayList<Integer>> a){
	    a.get(v1).add(v2);
	    a.get(v2).add(v1);
	}
}
