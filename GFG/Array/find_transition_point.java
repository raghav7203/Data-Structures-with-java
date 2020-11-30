/*
You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently. The transition point is a point where "0" ends and "1" begins (0 based indexing).
Note that, if there is no "1" exists, print -1.
Note that, in case of all 1s print 0.

Example 1:

Input:
N = 5
C[] = {0,0,0,1,1}
Output: 3
Explanation: position 3 is 0 and next
one is 1, so answer is 3.
Example 2:

Input:
N = 4
C[] = {0,0,0,0}
Output: -1
Explanation: Since, there is no "1",so
the answer is -1.
Your Task:
The task is to complete the function transitionPoint() that takes array and N as input and returns the value of the position where "0" ends and "1" begins.

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 500000
0 ≤ C[i] ≤ 1
*/

import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG {
    int transitionPoint(int arr[], int n) {
        // code here
        if(arr[0]==1)
            return 0;
        if(arr[n-1]==0)
            return -1;
        return get(arr, 0, n-1);
    }
    int get(int a[], int l, int r){
        if(l<=r){
            int mid=(l+r)/2;
            if(a[mid]==0 && a[mid+1]==1)
                return mid+1;
            else if(a[mid]==1)
                return get(a, l, mid-1);
            else
                return get(a, mid+1, r);
        }
        return -1;
    }
}
/*
class GfG {
    int transitionPoint(int arr[], int n) {
        // code here
        int l=0, r=n-1;
        if(arr[0]==1)
            return 0;
        if(arr[n-1]==0)
            return -1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==0)
                l=mid+1;
            else{
                r=mid-1;
            }
        }
        return l;
    }
}*/
