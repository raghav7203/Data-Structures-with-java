/*
Gotham has been attacked by Joker . Bruce Wayne has deployed automatic machine gun at each tower of Gotham.
All the towers in Gotham are in straight line.
You are given no of towers 'n' followed by height of 'n' towers.
For every tower(p), find the height of the closest tower (towards the right), greater than the height of tower(p).
Now , Print sum of all such heights (mod 1000000001).

Note : If for a tower(k) , no such tower exsits then take its height as 0.

Input:
First line of the input contains t, the number of test cases. First line of each test case contains 'n' denoting no of towers.
This is followed by 'n' spaced integers h1,h2.....h(n) representing height of towers. 

Output:
On a single line, output the sum(mod 1000000001). 
 

Constraints:
1<=t<=100
1<=n<=18000
0<=a[i]<=100000


Example:

Input:
1
9
112 133 161 311 122 512 1212 0 19212
 

Output:
41265

Explanation :
nextgreater(112) : 133
nextgreater(133) : 161
nextgreater(161) : 311
nextgreater(311) : 512
nextgreater(122) : 512
nextgreater(512) : 1212
nextgreater(1212) : 19212
nextgreater(0) : 19212
nextgreater(19212) : 0

add = 133+161+311+512+512+1212+19212+19212+0 = 41265.

Expected Time complexity - O(n).
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
		    long a[]=new long[n];
		    String s[]=br.readLine().trim().split("\\s+");
		    for(int i=0;i<n;i++)
		        a[i]=Long.parseLong(s[i]);
		        
		    Stack<Long> st=new Stack<>();
		    ArrayList<Long> al=new ArrayList<>();
		    for(int i=n-1;i>=0;i--){
		        if(st.isEmpty()){
		            al.add(0l);
		            st.push(a[i]);
		            continue;
		        }
		        while(!st.isEmpty()){
		            if(st.peek()>a[i]){
		                al.add(st.peek());
		                st.push(a[i]);
		                break;
		            }
		            else
		                st.pop();
		        }
		        if(st.isEmpty()){
		            al.add(0l);
		            st.push(a[i]);
		        }
		    }
		    long sum=0;
		    for(long i:al)
		        sum+=i;
		    System.out.println(sum%1000000001);
		}
	}
}
