/*
Delete a node from BST 
Given a Binary Search Tree (BST) and a node value. Delete the node with the given value from the BST. If no node with value x exists, then do not make any change. 

 

Example 1:

Input:
      2
    /   \
   1     3
X = 12
Output: 1 2 3
Explanation: In the given input there
is no node with value 12 , so the tree
will remain same.
Example 2:

Input:
            1
             \
              2
                \
                 8 
               /    \
              5      11
            /  \    /  \
           4    7  9   12
X = 9
Output: 1 2 4 5 7 8 11 12
Explanation: In the given input tree after
deleting 9 will be
             1
              \
               2
                 \
                  8
                 /   \
                5     11
               /  \     \
              4    7     12
Your Task:
You don't need to read input or print anything. Your task is to complete the function deleteNode() which takes two arguments. The first being the root of the tree, and an integer 'X' denoting the node value to be deleted from the BST. Return the root of the BST after deleting the node with value X. Do not make any update if there's no node with value X present in the BST. The inorder traversal of the tree is printed by the driver's code.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= N <= 100000

Note: The Input/Output format and Example are given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.
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

class GfG
{
    
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
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            String s = br.readLine();
	            int x = Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    root = g.deleteNode(root,x);
			    printInorder(root);
			    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


//User function Template for Java

/*
Structure of a Node is as follows:-
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
*/

class Tree
{
    // Return the root of the modified BST after deleting the node with value X
	public static Node deleteNode(Node root, int X)
	{
		// code here.
		int h=height(root);
		int l=0;
		for(int i=1;i<=h;i++){
		   l=get(root, i,  X);
		   if(l==1){
		       
		       l=i;
		       break;
		   }
		}
// 		System.out.println("L "+l);
        if(l==1){
            if(root.left==null && root.right==null)
                return null;
        }
		    delete(root, l, X);
		    return root;
	}
	static void delete(Node root, int l, int x){
	    if(root==null)
	        return;
	    else if(l==1){
	        if(root.data==x){
	            if(root.left==null && root.right==null){
	                root=null;
	            }
	            else if(root.left!=null && root.right==null){
	                root.data=root.left.data;
	                root.left=root.left.left;
	                root.right=root.left.right;
	            }
	                
	            else if(root.left==null && root.right!=null){
	                root.data=root.right.data;
	                root.left=root.right.left;
	                root.right=root.right.right;
	            }
	            else{
	               Node t1=root.left, t2=root.right;
	               root.data=root.left.data;
	               root.left=root.left.left;
	               if(t1.right==null){
	                   root.right=t2;
	               }
	               else if(t1.right!=null){
	                   t1.right.right=t2;
	                   root.right=t1.right;
	               }
	                
	            }
	        }
	    }
	    else{
	        delete(root.left, l-1, x);
	        delete(root.right, l-1, x);
	    }
	        
	}
	static int get(Node root,int i, int x){
	    if(root==null)
	        return 0;
	    else if(i==1){
            if(x==root.data)
                return 1;
            else
                return 0;
	    }
	    else{
	        int ls=get(root.left, i-1, x);
	        int rs=get(root.right, i-1, x);
	        if(ls==1 || rs==1)
	            return 1;
	        else
	            return 0;
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
