/*
Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.

Constraints:
1 ≤ T ≤ 70
30 ≤ N ≤ 130
1 ≤ Ai ≤ 60 

Example:
Input:
2
5
5 5 4 6 4
5
9 9 9 2 5

Output:
4 4 5 5 6
9 9 9 2 5

Explanation:
Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.

Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. So we print smaller element first.
The output is 9 9 9 2 5.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class node{
    int freq, data;
    public node(int freq, int data){
        this.freq=freq;
        this.data=data;
    }
}
class sortComparator implements Comparator<node>{
    public int compare(node a, node b){
        int count=b.freq-a.freq;
        int min=a.data-b.data;
        if(count==0)
            return min;
        else
            return count;
    }
}
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
		    
		    HashMap<Integer, Integer> map=new HashMap<>();
		    for(int i=0;i<n;i++){
		        if(map.containsKey(a[i]))
		            map.replace(a[i], map.get(a[i])+1);
		        else
		            map.put(a[i], 1);
		    }
		    
		    sortComparator comp=new sortComparator();
		    
		    PriorityQueue<node> minHeap=new PriorityQueue<>(comp);
		    ArrayList<Integer> key=new ArrayList<>(map.keySet());
		    for(int i:key){
		        minHeap.add(new node(map.get(i), i));
		    }
		    
		    while(minHeap.size()>0){
		        node temp=minHeap.poll();
		        for(int i=1;i<=temp.freq;i++){
		            System.out.print(temp.data+" ");
		        }
		    }
		    System.out.println();
		}
	}
}
