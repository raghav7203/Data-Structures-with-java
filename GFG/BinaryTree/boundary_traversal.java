/*
Write a function to print Boundary Traversal of a binary tree. Boundary Traversal of a binary tree here means that you have to return boundary nodes of the binary tree Anti-Clockwise starting from the root.
Note: Boundary node means nodes present at the boundary of left subtree and nodes present at the right subtree also including leaf nodes.
For the below tree, the function should print 20 8 4 10 14 25 22 .
    
                         

Example 1:

Input:
        1
      /   \
     2    3       
Output: 1 2 3
Explanation:

The first test case represents a tree
with 3 nodes and 2 edges where the
root is 1, the left child of 1 is 2
and the right child of 1 is 3. And
boundary traversal of this tree
prints nodes as 1 2 3.

Example 2:

Input:
          10
        /   \
       20   30
     /   \
    40   60
Output: 10 20 40 60 30

Your Task:
This is a function problem. You don't have to take input. Just complete the function printBoundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes<= 105
1 <= Data of a node<= 105
*/

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.printBoundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> l=new ArrayList<>();
	    ArrayList<Integer> r=new ArrayList<>();
	    ArrayList<Integer> c=new ArrayList<>();
	    
	    cleft(node.left, l);
	    cright(node.right, r);
	    cleaves(node, c);
	   // System.out.println(l);
	   // System.out.println(r);
	   // System.out.println(c);
	    ArrayList<Integer> res=new ArrayList<>();
	    res.add(node.data);
	    for(int i=0;i<l.size();i++)
	        res.add(l.get(i));
	    for(int i=0;i<c.size();i++)
	        res.add(c.get(i));
	    for(int i=r.size()-1;i>=0;i--)
	        res.add(r.get(i));
	        
	    return res;
	}
	void cleaves(Node root, ArrayList<Integer> c){
	    if(root==null)
	        return;
	    if(root.left==null && root.right==null){
	        c.add(root.data);
	        return;
	    }
	    cleaves(root.left, c);
	    cleaves(root.right, c);
	}
	void cright(Node root, ArrayList<Integer> r){
	    if(root==null || root.left==null && root.right==null)
	        return;
	    else{
	        r.add(root.data);
	        if(root.right!=null)
    	        cright(root.right, r);
    	    else
    	        cright(root.left, r);
	    }
	}
	void cleft(Node root, ArrayList<Integer> l){
	    if(root==null || root.left==null && root.right==null)
	        return;
	    else{
	        l.add(root.data);
	        if(root.left!=null)
	            cleft(root.left, l);
	        else
	            cleft(root.right, l);
	    }
	}
}

