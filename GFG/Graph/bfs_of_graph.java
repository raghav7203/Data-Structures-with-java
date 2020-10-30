/*
Given a directed graph. The task is to do Breadth First Search of this graph.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'E'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'E'  space separated pairs u and v denoting that there is a edge from u to v .

Output:
For each testcase, print the BFS of the graph starting from 0.

Note: The expected output button always produces BFS starting from node 0.

User Task:
You don't need to read input or print anything. Your task is to complete the function bfs() takes the Graph and the number of vertices as its input and returns a list containing the BFS traversal of the graph starting from the 0th vertex.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= E <= (N*(N-1))/2
Graph doesn't contain multiple edges and self loops.

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4
3 2
0 1 0 2

Output:
0 1 2 3 4    // BFS from node 0
0 1 2

Explanation:
Testcase 1: 
0 is connected to 1 , 2 , 3
2 is connected to 4
so starting from 0 , bfs will be 0 1 2 3 4.
*/


// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov; i++) list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            ArrayList<Integer>res = new Traversal().bfs(list,nov);
            for (int i =0 ;i < res.size (); i++) 
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*  g[]: adj list of the graph
*  N : number of vertices
*/


/*
USING ENHANCED FOR LOOP
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here
        ArrayList<Integer> a=new ArrayList<>();
        boolean v[]=new boolean[N];
        Queue<Integer> q=new LinkedList<>();
        v[0]=true;
        q.add(0);
        while(!q.isEmpty()){
            int t=q.poll();
            a.add(t);
            for(int i:g.get(t)){
                if(!v[i]){
                    v[i]=true;
                    q.add(i);
                }
            }
        }
        return a;
    }
}
*/


class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here
        ArrayList<Integer> a=new ArrayList<>();
        boolean v[]=new boolean[N];
        Queue<Integer> q=new LinkedList<>();
        v[0]=true;
        q.add(0);
        while(!q.isEmpty()){
            int t=q.poll();
            a.add(t);
            for(int i=0;i<g.get(t).size();i++){
                if(!v[g.get(t).get(i)]){
                    v[g.get(t).get(i)]=true;
                    q.add(g.get(t).get(i));
                }
            }
        }
        return a;
    }
}




