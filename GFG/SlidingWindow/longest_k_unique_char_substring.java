/*
Given a string you need to print the size of the longest possible substring that has exactly k unique characters. If there is no possible substring print -1.
Example
For the string aabacbebebe and k = 3 the substring will be cbebebe with length 7.


Input:
The first line of input contains an integer T denoting the no of test cases then T test cases follow. Each test case contains two lines . The first line of each test case contains a string s and the next line conatains an integer k.

Output:
For each test case in a new line print the required output.

Constraints:
1<=T<=100
1<=k<=10

Example:
Input:
2
aabacbebebe
3
aaaa
1
Output:
7
4
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    String s=br.readLine();
		    int k=Integer.parseInt(br.readLine());
		    int i=0, j=0;
		    int n=s.length();
		    HashMap<Character, Integer> map=new HashMap<>();
		    int count=-1;
		    while(j<n){
		        if(map.containsKey(s.charAt(j)))
		            map.replace(s.charAt(j), map.get(s.charAt(j))+1);
		        else
		            map.put(s.charAt(j), 1);
		        
		        if(map.size()<k)
		            j++;
		        else if(map.size()==k){
		            count=Math.max(count, j-i+1);
		            j++;
		        }
		        else if(map.size()>k){
		            while(map.size()>k){
		                map.replace(s.charAt(i), map.get(s.charAt(i))-1);
		                if(map.get(s.charAt(i))==0)
		                    map.remove(s.charAt(i));
		                i++;
		            }
		            j++;
		        }
		    }
            System.out.println(count);
		}
	}
}
