/*
Given a binary matrix. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Example 1:

Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.
Your Task: 
Your task is to complete the function maxArea which returns the maximum size rectangle area in a binary-sub-matrix with all 1’s. The function takes 3 arguments the first argument is the Matrix M[ ] [ ] and the next two are two integers n and m which denotes the size of the matrix M. 

Expected Time Complexity : O(n*m)
Expected Auixiliary Space : O(m)

Constraints:
1<=n,m<=1000
0<=M[][]<=1

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/


import java.util.*;
import java.lang.*;
class MaxRect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[1000][1000];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();
            GfG g = new GfG();

            System.out.println(g.maxArea(a, m, n));
        }
    }
}
// } Driver Code Ends


/*Complete the function given below*/
class node{
    int data, index;
    public node(int data, int index){
        this.data=data;
        this.index=index;
    }
}
class GfG {
    public int maxArea(int M[][], int m, int n) {
        // add code here.
        int a[]=new int[n];
        for(int j=0;j<n;j++)
            a[j]=M[0][j];
        
        int max=hist(a, n);
        // System.out.println(max);
        
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==0)
                    a[j]=0;
                else
                    a[j]=a[j]+M[i][j];
                
            }
            // System.out.println(hist(a, n));
            max=Math.max(max, hist(a, n));
        }
        return max;
    }
    public int hist(int a[], int n){
        Stack<node> st1=new Stack<>();
        int nsl[]=new int[n];
        
        for(int i=0;i<n;i++){
            if(st1.isEmpty()){
                nsl[i]=-1;
                st1.push(new node(a[i], i));
                continue;
            }
            while(!st1.isEmpty()){
                if(st1.peek().data<a[i]){
                    nsl[i]=st1.peek().index;
                    st1.push(new node(a[i], i));
                    break;
                }
                else
                    st1.pop();
            }
            if(st1.isEmpty()){
                nsl[i]=-1;
                st1.push(new node(a[i], i));
            }
        }

        Stack<node> st2=new Stack<>();
        int nsr[]=new int[n];
        
        for(int i=n-1;i>=0;i--){
            if(st2.isEmpty()){
                nsr[i]=n;
                st2.push(new node(a[i], i));
                continue;
            }
            while(!st2.isEmpty()){
                if(st2.peek().data<a[i]){
                    nsr[i]=st2.peek().index;
                    st2.push(new node(a[i], i));
                    break;
                }
                else
                    st2.pop();
            }
            if(st2.isEmpty()){
                nsr[i]=n;
                st2.push(new node(a[i], i));
            }
        }
        // Arrays work faster as compare to list so use nsr nsl as arrays not list
        
        int width[]=new int[n];
        for(int i=0;i<n;i++)
            width[i]=nsr[i]-nsl[i]-1;
        
        int area[]=new int[n];
        for(int i=0;i<n;i++)
            area[i]=width[i]*a[i];
            
        // for(int i:area)
        //     System.out.print(i+" ");
        // System.out.println();    
        
        int maxA=0;
        for(int i=0;i<n;i++){
            if(area[i]>maxA)
                maxA=area[i];
        }
        return maxA;
    }
}
