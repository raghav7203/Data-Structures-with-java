/*
Given a sorted array, arr[] of N integers, and a value X. Find the K closest elements to X in arr[].
Keep the following points in mind:

If X is present in the array, then it need not be considered.
If there are two elements with the same difference with X, the greater element is given priority.
If sufficient elements are not present on the right side then take elements from left and vice versa.
 
Example 1:

Input:
N = 13
arr[] = {12, 16, 22, 30, 35, 39, 42, 
         45, 48, 50, 53, 55, 56}
K = 4, X = 35
Output: 30 39 42 45
Explanation: 
First closest element to 35 is 30.
Second closest element to 35 is 39.
Third closest element to 35 is 42.
And fourth closest element to 35 is 45.

Example 2:

Input:
N = 5
Arr[] = {1, 2, 3, 6, 10}
K = 3, X = 4
Output: 3 6 2
Explanation: 
First closest element is 3.
There are two elements 2 and 6 for which 
the difference with 4 is same i.e. 2.
So first take greatest number 6 
then the lower number 2.

Your Task:
You don't need to read input or print anything. Complete the function printKClosest() which takes arr[], n, k and x as input parameters and returns an array of integers containing the K closest elements to X in arr[].


Expected Time Complexity: O(logN + K)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
*/



import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);


            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class node{
    int diff, data;
    public node(int diff, int data){
        this.diff=diff;
        this.data=data;
    }
}
class sortComparator implements Comparator<node>{
    public int compare(node a, node b){
        int d=b.diff-a.diff;
        int max=a.data-b.data;
        if(d==0)
            return max;
        else
            return d;
    }
}
class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        
        sortComparator comp=new sortComparator();
        // no Collections.reverseOrder for maxHeap here coz we are using comp and sorting heap accordingly
        PriorityQueue<node> maxHeap=new PriorityQueue<>(comp);
        
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]!=x)
                al.add(arr[i]);
        }
        
        for(int i=0;i<al.size();i++){
            maxHeap.add(new node(Math.abs(x-al.get(i)), al.get(i)));
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=maxHeap.poll().data;
        }
        
        int closest[]=new int[k];
        for(int i=0, j=k-1;j>=0;i++, j--)
            closest[i]=res[j];
        
        return closest;
    }
}

