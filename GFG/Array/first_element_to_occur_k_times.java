/*
Given an array of N integers. The task is to find the first element that occurs K number of times. If no element occurs K times the print -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the size of an array and the number K. The second line of each test case contains N space separated integers denoting elements of the array A[ ].

Output:
For each test case in a new line print the required answer.

Constraints:
1 <= T <= 100
1 <= N, K <= 105
1<= A <= 106

Example:
Input :
1
7 2
1 7 4 3 4 8 7
Output :
7

Explanation:
Both 7 and 4 occur 2 times. But 7 is the first that occurs 2 times.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++){
		    String s1[]=br.readLine().trim().split("\\s");
		    int n=Integer.parseInt(s1[0]);
		    int k=Integer.parseInt(s1[1]);
		    String s2[]=br.readLine().trim().split("\\s");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(s2[i]);
		    HashMap<Integer, Integer> map=new HashMap<>();
		    for(int i=0;i<n;i++){
		        if(map.containsKey(a[i]))
		            map.replace(a[i], map.get(a[i])+1);
		        else
		            map.put(a[i], 1);
		    }
		    int r=-1;
		    for(int i=0;i<n;i++){
		        if(map.get(a[i])==k){
		            r=a[i];
		            break;
		        }
		    }
		    System.out.println(r);
		}
	}
}
