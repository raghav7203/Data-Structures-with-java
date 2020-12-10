/*
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.

Input:  
The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.

Output: 
For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.

Constraints:
1 <= T<= 100
1 <= N <= 107
0 <= Ai <= 106

Example:
Input:
2
5
3 1 3 3 2
3
1 2 3

Output:
3
-1

Explanation:
Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.
*/

import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s=new Scanner(System.in);
		int test=s.nextInt();
		for(int t=1;t<=test;t++){
		    int n=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=s.nextInt();
            HashMap<Integer, Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                if(map.containsKey(a[i]))
                    map.replace(a[i], map.get(a[i])+1);
                else
                    map.put(a[i], 1);
            }
            int r=-1;
            ArrayList<Integer> al=new ArrayList<>(map.keySet());
            for(int i:al){
                if(map.get(i)>n/2){
                    r=i;
                    break;
                }
            }
            System.out.println(r);
		}
	}
}
