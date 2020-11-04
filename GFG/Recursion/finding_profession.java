/*
Consider a special family of Engineers and Doctors with following rules :

Everybody has two children.
First child of an Engineer is an Engineer and second child is a Doctor.
First child of an Doctor is Doctor and second child is an Engineer.
All generations of Doctors and Engineers start with Engineer.
We can represent the situation using below diagram:

                E
           /        \
          E          D
        /   \       /  \
       E     D     D    E
      / \   / \   / \   / \
     E   D D   E  D  E  E  D
Given level and position of a person in above ancestor tree, find profession of the person.

Examples:

Input : level = 4, pos = 2
Output : Doctor

Input : level = 3, pos = 4
Output : Engineer
Input:

First line of input contains number of test cases T. Each test case will be of one line. Each test case will have two space separated integers. First input represents Generation and second input represents child number.

Output:
Corresponding to each test case you have to print Doctor or Engineer in new line,based on input.

Example:
Input:
2
4 2
3 4

Output:
Doctor
Engineer
*/


// idea is same as kth-symbol-in-grammar quesn (already done)


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		//code		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++){
		    String s[]=br.readLine().trim().split("\\s+");
		    int n=Integer.parseInt(s[0]);
		    int k=Integer.parseInt(s[1]);
            
            int ans=get(n, k);
            if(ans==0)
                System.out.println("Engineer");
            else
                System.out.println("Doctor");
		}
	}
	public static int get(int n, int k){
	    if(k==0)
	        return 1;
	    // above condn is just for passing a testcase rest idea behind the ques is exactly same
	    if(n==1 && k==1)
	        return 0;
	    else{
	        int mid=((int)Math.pow(2, n-1))/2;
	        if(k<=mid)
	            return get(n-1, k);
	        else{
	            int res=get(n-1, k-mid);
	            if(res==0)
	                return 1;
	            else
	                return 0;
	        }
	    }
	}
}
