/*
Given an array of integers. Check whether it contains a triplet that sums up to zero. 

Example 1:

Input: N = 5, arr[] = {0, -1, 2, -3, 1}
Output: true
Explanation: 0, -1 and 1 forms a triplet
with sum equal to 0.
Example 2:

Input: N = 3, arr[] = {1, 2, 3}
Output: false
Explanation: No triplet with zero sum exists. 

Your Task:
You don't need to read input or print anything. Your task is to complete the boolean function findTriplets() which takes the array arr[] and the size of the array (n) as inputs and returns True if the given array has a triplet with zero sum and False otherwise. 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constrains:
1 <= N <= 104
-106 <= Ai <= 106
*/

import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Triplet g=new Triplet();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}// } Driver Code Ends


/*Complete the function below*/


class Triplet
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array
	public boolean findTriplets(int a[] , int n)
    {
        //add code here.
        Arrays.sort(a);
        int sum=0;
        for(int i=0;i<n;i++){
            int l=i+1, r=n-1;
            while(l<r){
                if(sum==a[i]+a[l]+a[r])
                    return true;
                else if(sum<a[i]+a[l]+a[r])
                    r--;
                else if(sum>a[i]+a[l]+a[r])
                    l++;
            }
        }
        return false;
    }
}
