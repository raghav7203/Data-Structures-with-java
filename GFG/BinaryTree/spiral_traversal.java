/*
Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.


 
 

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
1 <= Data of a node <= 105
*/

//Initial Template for Java



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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Spiral g = new Spiral();
                g.printSpiral(root);
			    System.out.println();
    	        
	        }
	}
}



// } Driver Code Ends


//User function Template for Java


/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Spiral
{
      void printSpiral(Node node) 
      {
           // Your code here
            if(node==null)
                return;
            ArrayList<Integer> result=new ArrayList<>();
            Queue<Node> q=new LinkedList<>();
    	    q.add(node);
    	    int f=1;
    	    while(!q.isEmpty()){
    	        int s=q.size();
    	        ArrayList<Integer> a=new ArrayList<>();
    	        for(int i=0;i<s;i++){
    	            Node temp=q.poll();
    	            if(temp.left!=null)
    	                q.add(temp.left);
    	            if(temp.right!=null)
    	                q.add(temp.right);
                    a.add(temp.data);
    	        }
    	        if(f==0){
    	            for(int i=0;i<a.size();i++){
    	                result.add(a.get(i));
    	            }
    	            f=1;
    	        }
    	        else if(f==1){
    	            for(int i=a.size()-1;i>=0;i--){
    	                result.add(a.get(i));
    	            }
    	            f=0;
    	        }
    	    }
    	    for(int i=0;i<result.size();i++)
    	        System.out.print(result.get(i)+" ");
      }
}
