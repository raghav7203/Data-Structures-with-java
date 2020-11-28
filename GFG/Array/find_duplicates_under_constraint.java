/*
Given a sorted array having 10 elements which contains 6 different numbers in which only 1 number is repeated five times. Your task is to find the duplicate number using two comparisons only.

Examples:

Input: A[] = {1, 1, 1, 1, 1, 5, 7, 10, 20, 30}
Output: 1

Input: A[] = {1, 2, 3, 3, 3, 3, 3, 5, 9, 10}
Output: 3


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow . Each test case contains 10 space separated values of the array A[].

Output:
For each test case in a new line print the required duplicate element.

Constraints:
1<=T<=100
1<=A[]<=10^5+5

Example:
Input:
2
1 2 4 5 6 9 9 9 9 9
1 2 3 3 3 3 3 5 9 10

Output:
9
3
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
// 		Scanner s=new Scanner(System.in);
// 		int test=s.nextInt();
// 		for(int t=1;t<=test;t++){
// 		    int a[]=new int[10];
// 		    for(int i=0;i<10;i++)
// 		        a[i]=s.nextInt();
// 		        int r=0;
// 		    HashMap<Integer, Integer> map=new HashMap<>();
// 		    for(int i=0;i<10;i++){
// 		        if(map.containsKey(a[i])){
// 		            r=a[i];
// 		            break;
// 		        }
// 		        else
// 		            map.put(a[i], 1);
// 		    }
// 		    System.out.println(r);
// 		}
        Scanner s=new Scanner(System.in);
		int test=s.nextInt();
		for(int t=1;t<=test;t++){
		    int a[]=new int[10];
		    for(int i=0;i<10;i++){
		        a[i]=s.nextInt();
		    }
		        if(a[4]==a[0] || a[4]==a[5])
		            System.out.println(a[4]);
		        else
		            System.out.println(a[9]);
		}
	}
}
