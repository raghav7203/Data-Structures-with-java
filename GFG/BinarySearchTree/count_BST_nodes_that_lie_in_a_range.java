/*
Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.

The values smaller than root go to the left side
The values greater and equal to the root go to the right side
Example 1:

Input:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the
range
Example 2:

Input:
     5
    /  \
   4    6
  /      \
 3        7
l = 2, h = 8
Output: 5
Explanation: All the nodes are in the
given range.
Your Task:
This is a function problem. You don't have to take input. You are required to complete the function getCountOfNode() that takes root, l ,h as parameters and returns the count.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 100
1 <= l < h < 103
*/

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    Node root=null;
		    int sizeOfArray=sc.nextInt();
		    int arr[]=new int[sizeOfArray];
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        int x=sc.nextInt();
		        arr[i]=x;
		    }
		   
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        root=Geeks.newNode(root,arr[i]);
		    }
		    int l,h;
		    l=sc.nextInt();
		    h=sc.nextInt();
		    System.out.println(Geeks.getCountOfNode(root,l,h));
		
		}
	}
}


class Geeks
{
    public static Node createNewNode(int value)
    {
        Node temp=new Node(value);
        
        return temp;
    }
    static public Node newNode(Node root,int data)
    {
        if(root==null)
        root=createNewNode(data);
        else if(data<root.data)
        root.left=newNode(root.left,data);
        else
        root.right=newNode(root.right,data);
        
        return root;
    }
  
    
 // } Driver Code Ends


// A Binary Search Tree node
/*

class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

*/
//Complete this function
public static int getCountOfNode(Node root,int l, int h)
{
    //Your code here
    int h1=height(root);
    int c=0;
    for(int i=1;i<=h1;i++){
        c=c+get(root, i, l, h);
    }
    return c;
}
static int get(Node root, int i, int l, int h){
    if(root==null)
        return 0;
    else if(i==1){
        if(root.data>=l && root.data<=h)
            return 1;
        else
            return 0;
    }
    else{
        int ls=get(root.left, i-1, l, h);
        int rs=get(root.right, i-1, l, h);
        return ls+rs;
    }
}
static int height(Node root){
    if(root==null)
        return 0;
    else{
        int lh=height(root.left);
        int rh=height(root.right);
        if(lh>rh)
            return lh+1;
        else
            return rh+1;
    }
}


// { Driver Code Starts.

    
}
  // } Driver Code Ends
