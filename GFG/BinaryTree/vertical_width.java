/*
Given a Binary Tree of N nodes. The task is to find the vertical width of the tree.
The width of a binary tree is the number of vertical paths in that tree.



The above tree contains 6 vertical lines which is the required vertical width of the tree.

Example 1:

Input:
          1
       /    \
      2      3
     / \    / \
    4   5  6   7
            \   \
             8   9
Output: 6

Example 2:

Input:
      1
    /  \
   2    3
Output: 3
Your Task:

You don't have to read input or print anything. Your task is to complete the function verticalWidth() which takes root as the only parameter, and returns the vertical width of the binary tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 103
*/


//Initial Template for Java

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
                Tree obj = new Tree();
                int ans=obj.verticalWidth(root);
                System.out.println(ans);
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


/*
class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
} */

// Function should return vertical width of the binary tree.
class Tree
{
    public static int verticalWidth(Node root)
	{
	    //Add your code here.
	    class custom{
	        Node node;
	        int hd;
	        custom(Node node, int hd){
	            this.node=node;
	            this.hd=hd;
	        }
	    }
	    if(root==null)
	        return 0;
	    Queue<custom> q=new LinkedList<>();
	    HashMap<Integer, Integer> map=new HashMap<>();
	    int min=0, max=0;
	    q.add(new custom(root, 0));
	    while(!q.isEmpty()){
	        custom t=q.poll();
	        if(t.node.left!=null)
	            q.add(new custom(t.node.left, t.hd-1));
	        if(t.node.right!=null)
	            q.add(new custom(t.node.right, t.hd+1));
	        if(min>t.hd)
	            min=t.hd;
	        if(max<t.hd)
	            max=t.hd;
	    }
	    return max-min+1;
	}
}
