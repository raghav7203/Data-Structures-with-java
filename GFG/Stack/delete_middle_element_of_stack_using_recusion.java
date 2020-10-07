/*
Given a stack with push(), pop(), empty() operations, delete the middle of it without using any additional data structure.
Middle: ceil(size_of_stack/2.0)
 

Example 1:

Input: 
5
1 2 3 4 5

Output:
1 2 4 5

Explanation:
As the number of elements is 5 , 
hence the middle element will be the 3rd
element which is deleted
Example 2:

Input: 
4
1 2 3 4

Output:
1 3 4

Explanation:
As the number of elements is 4 , 
hence the middle element will be the 2nd
â€‹element which is deleted
 

Your Task:
This is a function problem. The input is already taken by the driver code. You only need to complete the function deleteMid() which takes 3 arguments(stack, size of the stack, and current index - initially 0) and returns the modified stack.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= sizeOfStack <= 100

Note: The output on the console is printed in reverse order of elements in the modified stack.
*/


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    Scanner sc=new Scanner(System.in);
	    
	    //Taking input total testcases
	    int testcases=sc.nextInt();
	    
	    while(testcases-->0)
	    {
	        //Taking the total number of elements in the stack
	        int sizeOfStack =sc.nextInt();
	        
	        
	        Stack <Integer> myStack=new Stack<>();
	        
	        //adding elements to the stack
	        for(int i=0;i<sizeOfStack;i++)
	        {
	            int x=sc.nextInt();
	            myStack.push(x);
	            
	        }
	        
	        //stack size is 1 
	        //then just ouput the first element
	        if(sizeOfStack==1)
	        {
	            System.out.println(myStack.peek());
	        }
	        else
	        {
	            Geeks obj=new Geeks();
	            
	            //calling deleteMid method of class Geeks
	            //which gives a new stack after removing
	            //the middle element
	            Stack <Integer> modified=obj.deleteMid(myStack,sizeOfStack,0);
	            
	            //printing all the elements 
	            // of the modified stack
	            while(!modified.isEmpty())
	            {
	                System.out.print(modified.peek()+" ");
	                modified.pop();
	            }
	            System.out.println();
	        }
	    }
	    
	    
	}
}
// } Driver Code Ends


//User function Template for Java

class Geeks
{
    //Complete this function
    public Stack<Integer> deleteMid(Stack<Integer>s,int sizeOfStack,int current)
    {
        //Your code here
        if(s.size()==0)
            return s;
            
        int mid=((s.size()/2)+1);
        solve(s, mid);
        
        return s;
    } 
    public void solve(Stack<Integer> s, int k){
        if(k==1)
            s.pop();
        
        else{
            int t=s.pop();
            solve(s, k-1);
            s.push(t);
        }
    }
}


