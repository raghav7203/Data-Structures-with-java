/*
Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

Input:
First line of input contains the number of test cases T. For each test case, there will be only two line of input, first line contains a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Second line of each test case will contain the integer value k.

Output:
The kth largest element for given input tree.

Your Task:
You don't need to read input or print anything. Your task is to complete the function kthLargest() which takes the root of the BST and an integer K as inputs and returns the Kth largest element in the given BST.

Expected Time Complexity: O(H + K).
Expected Auxiliary Space: O(H).

Constraints:
1 <= T <= 1000
1 <= N <= 1000
1 <= K <= N

Example:
Input:
2
4 2 9 1 3 N 10
3
9 N 10
1
Output:
4
10
*/

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str)
    {
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
  
	public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
            
            while(t > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                
                int k=Integer.parseInt(br.readLine());
                
                Tree g = new Tree();
                System.out.println (g.kthLargest(root,k));
                t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tree
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        int h=height(root);
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=1;i<=h;i++){
            get(root, i, a);
        }
        Collections.sort(a);
        return a.get(a.size()-K);
    }
    void get(Node root, int i, ArrayList a){
        if(root==null)
            return;
        else if(i==1)
            a.add(root.data);
        else{
            get(root.left, i-1, a);
            get(root.right, i-1, a);
        }
    }
    int height(Node root){
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
