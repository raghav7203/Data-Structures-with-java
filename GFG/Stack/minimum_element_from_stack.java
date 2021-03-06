/*
You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer Q denoting the number of queries.
A Query Q may be of 3 Types:
    1. 1 x (a query of this type means  pushing 'x' into the stack)
    2. 2 (a query of this type means to pop element from stack and print the poped element)
    3. 3 (a query of this type means to print the minimum element from the stack)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out  or min element from the stack.

User Task:
You are required to complete the three methods push() which take one argument an integer 'x' to be pushed into the stack, pop() which returns a integer poped out from the stack and getMin() which returns the min element from the stack.

Expected Time Complexity : O(1) for all the 3 methods.
Expected Auixilliary Space : O(1) for all the 3 methods.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
1
6
1 2 1 3 2 3 1 1 3   

Output:
3 2 1

Explanation:
Testcase 1:
In the first test case for query 
1 2  the stack will be {2}
1 3  the stack will be {2 3}
2 poped element will be 3 the stack will be {2}
3 min element will be 2 
1 1 the stack will be {2 1}
3 min element will be 1
*/


import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}


// } Driver Code Ends


class GfG
{
    class stackNode{
        int data, val;
        public stackNode(int data, int val){
            this.data=data;
            this.val=val;
        }
    }
    int min = -1;
    Stack<stackNode> st = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	    if(!(st.isEmpty())){
            return st.peek().val;
        }
        else{
            return -1;
        }
	    
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here	
        if(!(st.isEmpty())){
            return st.pop().data;
        }
        else{
            return -1;
        }
    }

    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here
	    if((st.isEmpty())){
	       st.push(new stackNode(x, x));
	    }
	    else{
	        if(x<st.peek().val){
	            st.push(new stackNode(x, x));
	        }
	        else{
	            st.push(new stackNode(x, st.peek().val));
	        }
	    }
	    
    }	
}


