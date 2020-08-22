/*
Given a binary tree and an integer X. Your task is to complete the function countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to the value X.
Example: For the tree given below:            

              5
            /    \
        -10     3
        /    \    /  \
      9     8  -4 7

Subtree with sum 7:
             -10
            /      \
          9        8

and one node 7.

Example 1:

Input:
       5
    /    \
  -10     3
 /   \   /  \
 9   8 -4    7
X = 7
Output: 2
Explanation: Subtrees with sum 7 are
[9, 8, -10] and [7] (refer the example
in the problem description).
Example 2:

Input:
    1
  /  \
 2    3
X = 5
Output: 0
Explanation: No subtree has sum equal
to 5.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countSubtreesWithSumX() which takes the root node and an integer X as inputs and returns the number of subtrees of the given Binary Tree having sum exactly equal to X.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 103
-103 <= Node Value <= 103
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
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            
                int x=Integer.parseInt(br.readLine());
	            Tree tr = new Tree();
                System.out.println(tr.countSubtreesWithSumX(root,x));
	            
	        }
	    
	}
}

// } Driver Code Ends


//User function Template for Java


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

// Return the count of the sub-trees having sum as X.
class Tree
{
    
    int c=0;
    int countSubtreesWithSumX(Node root, int X)
    {
    	//Add your code here.
    	count(root, X);
    	return c;
    }
    int count(Node root, int X){
        if(root==null){
    	    return 0;
    	}
    	int ls=count(root.left, X);
    	int rs=count(root.right, X);
    	if(ls+rs+root.data==X){
    	    c++;
    	}
    	return ls+rs+root.data;
    }
}


