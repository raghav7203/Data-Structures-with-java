/*
Given a binary tree, print nodes of extreme corners of each level but in alternate order.

Example:


For above tree, the output is

1 2 7 8 31
– print rightmost node of 1st level
– print leftmost node of 2nd level
– print rightmost node of 3rd level
– print leftmost node of 4th level
– print rightmost node of 5th level

Example 1:

Input:
       1
     /  \
    2    3
Output: 1 2
​Explanation: This represents a tree
with 3 nodes and 2 edges where root
is 1, left child of 1 is 3 and
right child of 1 is 2.
Your Task:
You don't have to take any input. Just complete the function printExtremeNodes() that takes root node as paramter  and print the answer. New line will be added by the driver code only.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000
*/


//Contributed by Sudarshan Sharma
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
    	        g.printExtremeNode(root);
    	        System.out.println();
	        }
	}
}
// } Driver Code Ends


/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;
    
    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/
class Tree{
    public  void printExtremeNode(Node node)
      {
        //add code here.
        int f=0;
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                Node temp=q.poll();
                if(f==0 && i==s-1){
                    System.out.print(temp.data+" ");
                }
                else if(f==1 && i==0){
                    System.out.print(temp.data+" ");
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(f==0)
                f=1;
            else
                f=0;
        }
      }
}
