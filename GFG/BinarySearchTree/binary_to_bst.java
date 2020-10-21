/*
Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.

Input Format:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

For example:



For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output Format:
Print the inorder traversal of the the converted  binary search tree.

Your Task:
You don't need to read input or print anything. Your task is to complete the function binaryTreeToBST() which takes the root of the Binary tree as input and returns the root of the BST.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:

1 <= T <= 100
1 <= Number of nodes <= 1000

Example:
Sample Input:
3
1 2 3 4 
1 3 2
10 20 30 40 60

Output:
1 2 3 4 
1 2 3
10 20 30 40 60

Explanation:
Testcase 1 : The binary tree is 

          1
       /    \
     2       3
   /        
4       

The converted BST will be

        3
      /   \
    2     4
  /
1
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

class GFG {
    
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
    static void printInorder(Node root){
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
            GfG g = new GfG();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class GfG
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root)
    {
       // Your code here
       int h=height(root);
       ArrayList<Integer> a=new ArrayList<>();
       for(int i=1;i<=h;i++){
           getValues(root, i, a);
       }
       int arr[]=new int[a.size()];
        for(int i=0;i<a.size();i++)  
            arr[i]=a.get(i);
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
        return root=bst(root, arr);
    }
    int i=0;
    Node bst(Node root, int a[]){
        if(root==null){
            return null;
        }
            
        else{
            bst(root.left, a);
            root.data=a[i];
            i++;
            bst(root.right, a);
            return root;
        }
    }
    
    void getValues(Node root, int i, ArrayList a){
        if(root==null)
            return;
        else if(i==1)
            a.add(root.data);
        else{
            getValues(root.left, i-1, a);
            getValues(root.right, i-1, a);
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
 
