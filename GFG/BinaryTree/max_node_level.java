/*
Given a Binary tree. Find the level in binary tree which has the maximum number of nodes.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Print the level number with maximum nodes.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxNodeLevel() that takes root node of the tree as input and returns an integer which is level of the tree with maximum nodes. The root is at level 0. If two or more levels have same number of maximum nodes , then print smallest level.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=T<=50
1<=N<=105
Example:
Input:
2
2 1 3 4 6 N 8 N N 5
1 2 
Output:
2
0

Explanation:
Test Case 1: The given Binary Tree is:
      2
    /    \ 
  1      3
 /   \      \
4    6     8
     / 
    5
The level 2 with nodes 4, 6 and 8 is the level with maximum number of nodes. 
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
			    int ans = g.maxNodeLevel(root);
			    System.out.println(ans);
                t--;
            
        }
    }
  
}

// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/
class Tree
{
    // Return the level (0-indexed) with maximum number of nodes.
    public static int maxNodeLevel(Node root)
    {
        // add your code here
        int h=height(root);
        // System.out.println("HEIGHT "+h);
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<h;i++){
            int count=0;
            int c=max(root, i, count);
            // System.out.println("COUNT "+c);
            a.add(c);
        }
        int index=0;
        int val=a.get(0);
        for(int i=0;i<a.size();i++){
            if(val<a.get(i)){
                val=a.get(i);
                index=i;
            }
        }
        return index;
    }
    static int max(Node root, int i, int count){
        if(root==null)
            return 0;
        else if(i==0){
           count++;
           return count;
        }
        else{
           int ls=max(root.left, i-1, count);
           int rs=max(root.right, i-1, count);
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
}
