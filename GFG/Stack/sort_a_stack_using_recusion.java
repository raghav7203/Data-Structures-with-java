/*
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Input:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an integer N denoting the size of the stack. Then in the next line are N space separated values which are pushed to the the stack. 

Output:
For each test case output will be the popped elements from the sorted stack.

Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack.

Expected Time Complexity : O(N*N)
Expected Auixilliary Space : O(N) recursive.

Constraints:
1<=T<=100
1<=N<=100

Example(To be used only for expected output):
Input:
2
3
3 2 1
5
11 2 32 3 41

Output:
3 2 1
41 32 11 3 2

Explanation:
For first test case stack will be
1
2
3
After sorting 
3
2 
1

When elements  popped : 3 2 1

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/

import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.\
		if(s.size()==1)
		    return s;
		int temp=s.pop();
		sort(s);
		insert(s, temp);
		return s;
	}
	public void insert(Stack<Integer> s, int t){
	    if(s.size()==0 || s.peek()<t){
	        s.push(t);
	        return;
	    }
	    else{
	        int temp=s.pop();
	        insert(s, t);
	        s.push(temp);	        
	    }
	}
}
