/*
Given a Binary Tree, find maximum and minimum elements in it.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the number of edges. The following line contains the edges as shown in the example.

Output:
Print two space-separated integers maximum and minimum element in the binary tree.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=data of the node<=10^5

Example:
Input:
1
7
2 7 L 2 5 R 7 6 R 6 1 L 6 11 R 5 9 R 9 4 L

Output:
11 1

Explanation:

                                                       

The above tree is constructed through the example in the input. The maximum and minimum element in this binary tree is 11 and 1 respectively.
*/

import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.lang.Math;
    class Node
    {
        int data;
        Node left,right;
        Node(int d) {data = d; left =right= null; }
    }
		
public class GFG2
{
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-->0)
         {
			int n = sc.nextInt();
			GFG2 llist=new GFG2();
			Node root=null,parent=null;
			HashMap<Integer, Node> m = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                char c=sc.next().charAt(0);
                if(m.containsKey(a)==false)
                {
                    parent=new Node(a);
                    m.put(a,parent);
                    if(root==null)
                    root=parent;
                }
                else
                    parent=m.get(a);
                Node child=new Node(b);
                if(c=='L')
                parent.left=child;
                else
                parent.right=child;
                m.put(b,child);
            }
            GFG obj = new GFG();
            int Max=obj.findMax(root);
            int Min=obj.findMin(root);
            System.out.println(Max+" "+Min);
		}
	}
}// } Driver Code Ends


/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

//Complete the findMax and findMin functions.
class GFG
{
	public static int findMax(Node root)
	{
	    //Add your code here.
	    Queue<Node> q=new LinkedList<>();
	    q.add(root);
	    int max=root.data;
	    while(!q.isEmpty()){
	        Node temp=q.poll();
	        if(temp.data>max)
	            max=temp.data;
	        if(temp.left!=null)
	            q.add(temp.left);
	        if(temp.right!=null)
	            q.add(temp.right);
	    }
	    return max;
	}
	public static int findMin(Node root)
	{
	    //Add your code here.
	    Queue<Node> q=new LinkedList<>();
	    q.add(root);
	    int min=root.data;
	    while(!q.isEmpty()){
	        Node temp=q.poll();
	        if(temp.data<min)
	            min=temp.data;
	        if(temp.left!=null)
	            q.add(temp.left);
	        if(temp.right!=null)
	            q.add(temp.right);
	    }
	    return min;
	}
}
