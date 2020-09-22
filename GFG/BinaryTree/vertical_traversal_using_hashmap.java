/*
Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:

Input:
     2
      \
       3
      /
     4
Output: 2 4 3

Example 2:

Input:
       1
    /    \
   2      3
 /   \      \
4     5      6
Output: 4 2 1 5 3 6

Your Task:
You don't need to read input or print anything. Your task is to complete the function verticalOrder() which takes the root node as input and returns an array containing the vertical order traversal of the tree from the leftmost to the rightmost level. If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.

Expected Time Complexity: O(N log N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 5000
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
                BinaryTree obj = new BinaryTree();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}
// } Driver Code Ends


//User function Template for Java


/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/

class BinaryTree
{
    
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        class custom{
        Node node;
        int hd;
            custom(Node node, int hd){
                this.node=node;
                this.hd=hd;
            }
        }
        ArrayList<Integer> a=new ArrayList<>();
        Queue<custom> q=new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        
        q.add(new custom(root, 0));
        int min=0, max=0;
        
        while(!q.isEmpty()){
            custom temp=q.poll();
            if(temp.node.left!=null)
                q.add(new custom(temp.node.left, temp.hd-1));
            if(temp.node.right!=null)
                q.add(new custom(temp.node.right, temp.hd+1));
            
            if(temp.hd<min)
                min=temp.hd;
            if(temp.hd>max)
                max=temp.hd;
                
            if(map.containsKey(temp.hd)){
                ArrayList<Integer> list = map.get(temp.hd);
                list.add(temp.node.data);
                map.put(temp.hd, list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.node.data);
                map.put(temp.hd, list);
            }
        }
        for(int i=min;i<=max;i++){
            ArrayList<Integer> list = map.get(i);
            for(int j=0;j<list.size();j++)
                a.add(list.get(j));
        }
        return a;
    }
}
