/*
You are given N number of books. Every ith book has Pi number of pages. 
You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value. 
Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.
Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding).

Input:
The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:Each case begins with a single positive integer N denoting the number of books.The second line contains N space separated positive integers denoting the pages of each book.And the third line contains another integer M, denoting the number of students.

Output:
For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A [ i ] <= 106
1 <= M <= 106

Example:
Input:
2
4
12 34 67 90
2
3
15 17 20
2
Output:
113
32

Explaination:
Testcase 1:Allocation can be done in following ways:
{12} and {34, 67, 90}     Maximum Pages = 191
{12, 34} and {67, 90}     Maximum Pages = 157
{12, 34, 67} and {90}        Maximum Pages = 113

Therefore, the minimum of these cases is 113, which is selected as output.

Testcase 2: Allocation can be done in following ways:
{15} and {17, 20} Maximum pages = 37
{15, 17} and {20} Maximum Pages = 32

So, the output will be 32.
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
		    int k=Integer.parseInt(br.readLine().trim());
		    
		    long max=0, sum=0, start=0, end=0, mid=0, ans=-1;
		    
		    for(int i=0;i<n;i++){
		        if(a[i]>max)
		            max=a[i];
		    }
		    for(int i=0;i<n;i++){
		        sum+=a[i];
		    }
		    
		    start=max; //sabse max wali book kisi ko to ayegi wo hogi min
            end=sum;   //saari book ek hi student ko, aur ek hi student tha
		    
		    if(n<k){
		        System.out.println(-1);
		        continue;
		    }
		    
		    while(start<=end){
		        mid=start+(end-start)/2;
		        if(isValid(a, mid, k)){
		            ans=mid;
		            end=mid-1;
		        }
		        else
		            start=mid+1;
		    }
		    System.out.println(ans);;
		}
	}
	public static boolean isValid(long a[], long mid, int k){
	    int student=1;
	    long sum=0;
	    
	    for(int i=0;i<a.length;i++){
	        sum+=a[i];
	        if(sum>mid){
	            student++;
	            sum=a[i];
	        }
	        if(student>k)
	            return false;
	    }
	    return true;
	}
}
