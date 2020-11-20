/*
Given N non-negative integers a_1, a_2, ..., a_n  where each represents a point at coordinate  (i, a_i) . N vertical lines are drawn such that the two endpoints of line i is at  (i, a_i)  and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Input: 
The first line of input contains an integer T denoting the number of test cases. Each test case contains an integer N followed by N space separated integers.

Output:
For each test case, the output is the integer denoting the maximum area of water that can be contained ( maximum area instead of maximum volume as working with 2D)

Constraints:
1 <= T <= 100
2 <= N <= 50
1 <= A[] <= 100

Example:
Input:
2
4
1 5 4 3 
5
3 1 2 4 5
Output:
6
12

Explanation:
1. 5 and 3 are distance 2 apart. So the size of the base = 2. Height of container = min(5, 3) = 3. So total area = 3 * 2 = 6.
2. 5 and 3 are distance 4 apart. So the size of the base = 4. Height of container = min(5, 3) = 3. So total area = 4 * 3 = 12.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

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
		        
		    System.out.println(solve(a, n));
		}
	}
	public static int solve(int a[], int n){
	    int max=Integer.MIN_VALUE;
	    int i=0, j=n-1;
	    while(i<j){
	        max=Math.max(max, (Math.min(a[i], a[j]))*(j-i));
	        if(a[i]<a[j])
	            i++;
	        else
	            j--;
	    }
	    return max;
	}
}
