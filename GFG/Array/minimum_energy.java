/*
Given an array containing positive and negative numbers. The array represents checkpoints from one end to other end of street. Positive and negative values represent amount of energy at that checkpoint. Positive numbers increase the energy and negative numbers decrease. Find the minimum initial energy required to cross the street such that Energy level never becomes 0 or less than 0.
 

Note :  The value of minimum initial energy required will be 1 even if we cross street successfully without loosing energy to less than and equal to 0 at any checkpoint. The 1 is required for initial check point.
 

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array. The second line of each test case contains N space separated integers denoting array elements.

Output:
Corresponding to each test case, in a new line, print the minimum initial energy required to cross the street.
 

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
-500 ≤ A[i] ≤ 500

Example:

Input
2
5
4 -10 4 4 4
5
3  5 2  6 1

Output
7
1

Explanation
(i) For first test case, By having an initial energy of 7 we can make sure that all the checkpoints are visited and the fuel never reaches 0 or less value.
(ii) For second test case, We need at least 1 initial energy to reach first checkpoint
*/



import java.util.*;
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
		    int e=1, req=0;
		    for(int i=0;i<n;i++){
		        req+=a[i];
		        if(req==0)
		            e+=1;
		        if(req<0){
		           e=e+(-req);
		           req=0;
		        }
		    }
		  System.out.println(e);
		}
	}
}
