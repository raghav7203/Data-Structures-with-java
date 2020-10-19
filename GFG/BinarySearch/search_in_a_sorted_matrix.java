/*
Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.

Example 1:

Input:
N = 3
M = 3
mat[][]: 3 30 38 
         44 52 54 
         57 60 69
X = 62
Output:
0
Explanation: 62 is not present in the
matrix, so output is 0

Example 2:

Input:
N = 1
M = 6
mat[][] : 18 21 27 38 55 67
X = 55
Output:
1
Explanation: 55 is present in the
matrix at 5th cell.

Your Task:
You don't need to read input or print anything. You just have to complete the function matSearch() which takes a 2D matrix mat[][], its dimensions N and M and integer X as inputs and returns 1 if the element X is present in the matrix and 0 otherwise.

Expected Time Complexity: O(N+M).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N, M <= 30
1 <= mat[][] <= 100
1<= X <= 100
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}// } Driver Code Ends


class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        int i=0, j=M-1, ans=0;
        
        while(i<=N-1 && j>=0){
            if(mat[i][j]==X){
                ans=1;
                break;
            }
            else if(mat[i][j]>X)
                j--;
                
            else if(mat[i][j]<X)
                i++;
        }
        return ans;
    }
}
