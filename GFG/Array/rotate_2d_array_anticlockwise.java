/*
You are given an N x N 2D matrix Arr representing an image. Rotate the image by 90 degrees (clockwise). You need to do this in place. Note that if you end up using an additional array, you will only receive partial score.

Example 1:

Input:
N = 3
Arr[][] = {{1,  2,  3}
           {4,  5,  6}
           {7,  8,  9}}
Output:
 3  6  9 
 2  5  8 
 1  4  7 
Explanation: The given matrix is rotated
by 90 degree in anti-clockwise direction.
Example 2:

Input:
N = 4
Arr[][] = {{1,  2,  3,  4}
           {5,  6,  7,  8}
           {9, 10, 11, 12}
           {13, 14, 15, 16}}
Output:
 4  8 12 16 
 3  7 11 15 
 2  6 10 14 
 1  5  9 13
Explanation: The given matrix is rotated
by 90 degree in anti-clockwise direction.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function rotate() which takes the 2D array of integers arr and n as parameters and returns void. You need to change the array itself.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ N ≤ 1000
1 ≤ Arr[i][j] ≤ 1000
*/

//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * n + j]);
                }
            }

            new Solution().rotateMatrix(arr, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    void rotateMatrix(int arr[][], int n) {
        // code here
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int t=arr[i][j];
                arr[i][j]=arr[j][n-1-i];
                arr[j][n-1-i]=arr[n-1-i][n-1-j];
                arr[n-1-i][n-1-j]=arr[n-1-j][i];
                arr[n-1-j][i]=t;
            }
        }
    }
}
