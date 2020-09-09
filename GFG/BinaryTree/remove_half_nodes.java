/*
Given A binary Tree. Your task is to remove all the half nodes (which has only one child).

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Single line output, print the modified tree in inorder traversal.

Your Task:
You don't need to read input or print anything. Your task is to complete the function removeHalfNodes() which takes the root node of the tree as input and returns the root node of the modified tree after removing all the half nodes, ie the ones having just a single child node.
For example consider the below tree.


Nodes 7, 5 and 9 are half nodes as one of their child is Null. We need to remove all such half nodes and return the root pointer of following new tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Binary Tree).

Constraints:
1<=T<=100
1<=N<=104

Example:
Input:
2
7 7 8 2
2 7 5 N 6 N 9 1 11 4
Output:
2 7 8 
1 6 11 2 4

Explanation:
Test Case 1: The given tree is:
      7
    /    \
  7      8
 /
2
The bolded 7 valued node above is the only half node in the given Binary Tree. Modified tree after removing this node is:
      7
    /    \ 
   2     8
The in-order traversal of this tree is: 2 7 8

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/


//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    Node fresh = g.RemoveHalfNodes(root);
			    printInorder(fresh);
			    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


//User function Template for Java


/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

*/

class Tree
{
    // Return the root of the modified tree after removing all the half nodes.
    public static Node RemoveHalfNodes(Node root)
    {
        // Code Here
        if(root==null)
            return null;
        root.left=RemoveHalfNodes(root.left);
        root.right=RemoveHalfNodes(root.right);
        if(root.left==null && root.right!=null)
            return root.right;
        else if(root.left!=null && root.right==null)
            return root.left;
        else
            return root;
    }
}

