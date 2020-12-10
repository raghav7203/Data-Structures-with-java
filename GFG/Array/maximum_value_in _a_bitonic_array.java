/*
Given an array Arr of N elements which is first increasing and then may be decreasing, find the maximum element in the array.
Note: If the array is increasing then just print then last element will be the maximum value.

Example 1:

Input: 
N = 9
Arr[] = {1,15,25,45,42,21,17,12,11}
Output: 45
Explanation: Maximum element is 45.
Example 2:

Input: 
N = 5
Arr[] = {1, 45, 47, 50, 5}
Output: 50
Explanation: Maximum element is 50.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMaximum() which takes the array arr[], and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ N ≤ 106
1 ≤ Arri ≤ 106
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
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] arr, int n) {
        // code here
        int l=0, r=n-1;
        return get(arr, l, r);
    }
    int get(int a[], int l, int r){
        if(l<=r){
            int mid=(l+r)/2;
            if(mid==0 && a[mid]>a[mid+1])
                return a[mid];
            if(mid==a.length-1 && a[mid]>a[mid-1])
                return a[mid];
            if(a[mid]>a[mid+1] && a[mid]>a[mid-1]){
                return a[mid];
            }
            else if(a[mid]<a[mid+1]){
                return get(a, mid+1, r);
            }
            else if(a[mid]<a[mid-1]){
                return get(a, l, mid-1);
            }
        }
        return -1;
    }
}
