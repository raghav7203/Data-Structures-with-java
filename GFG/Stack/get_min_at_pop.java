/*
Now, we'll try to solve a famous stack problem.
You are given an array A of size N. You need to push the elements of the array into a stack and then print minimum in the stack at each pop.

Input:
The first line of input contains T denoting the number of test cases. T test cases follow. Each testcase contains two lines of input. The first line of input contains the size of array N. The second line of the array contains the elements of array separated by spaces.

Output:
For each testcase, in a new line, print the required output.

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided functions _push() and _getMinAtPop().

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= Ai <= 107

Examples:
Input:
2
5
1 2 3 4 5
7
1 6 43 1 2 0 5
Output:
1 1 1 1 1
0 0 1 1 1 1 1

Explanation:
Testcase 1: After pushing elements to the stack, the stack will be top --- > 5, 4, 3, 2, 1. Now, start popping elements from the stack:
popping 5: min in the stack is 1. popped 5
popping 4: min in the stack is 1. popped 4
popping 3: min in the stack is 1. popped 3
popping 2: min in the stack is 1. popped 2
popping 1: min in the stack is 1. popped 1.
Testcase 2: After pushing the elements to the stack, the stack will be 5->0->2->1->43->6->1. Now, poping the elements from the stack:
popping 5: min in the stack is 0. popped 5
popping 0: min in the stack is 0. popped 0
popping 2: min in the stack is 1. popped 2
popping 1: min in the stack is 1. popped 1
popping 43: min in the stack is 1. popped 43
popping 6: min in the stack is 1. popped 6
popping 1: min in the stack is 1. popped 1.
*/

//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class getMin
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
            Stack<Integer>mys = new GetMin()._push(arr,n);
            new GetMin()._getMinAtPop(mys);
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class GetMin
{
    
    /* inserts elements of the array into 
        stack and return the stackn*/
    public static Stack<Integer> _push(int arr[],int n)
    {
        // your code here
        Stack<Integer> st=new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<n;i++){
            if(st.peek()>arr[i]){
                st.push(arr[i]);
            }
            else{
                st.push(st.peek());
            }
        }
        return st;
    }
    
    /* print minimum element of the stack each time
       after popping*/
    static void _getMinAtPop(Stack<Integer>s)
    {
        // your code here
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        
    }
}

