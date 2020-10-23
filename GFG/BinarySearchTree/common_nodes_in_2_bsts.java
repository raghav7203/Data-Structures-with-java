/*
Given two Binary Search Trees(without duplicates). Find need to print the common nodes in them. In other words, find intersection of two BSTs

Example 1:

Input:
BST1:
                  5
               /     \
             1        10
           /   \      /
          0     4    7
                      \
                       9
BST2:
                10 
              /    \
             7     20
           /   \ 
          4     9
Output: 4 7 9 10

Example 2:

Input:
BST1:
     10
    /  \
   2   11
  /  \
 1   3
BST2:
       2
     /  \
    1    3
Output: 1 2 3
Your Task:
You don't need to read input or print anything. Your task is to complete the function printCommon() that takes roots of both the BSTs as input and returns an array containing the intersection of the 2 BSTs in a sorted order. 

Expected Time Complexity: O(N1 + N2) where N1 and N2 are the sizes of the 2 BSTs.
Expected Auxiliary Space: O(H1 + H2) where H1 and H2 are the Heights of the 2 BSTs.

Constraints:
1 <= N <= 103
*/

//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

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
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            BST g=new BST();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.printCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node (int d){
		data=d;
		left=right=null;
	}
}
*/
class BST
{
	// print a list containing the intersection of the two BSTs in a sorted order
	public static ArrayList<Integer> printCommon(Node root1,Node root2)
    {
        //add code here.
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        int h1=height(root1);
        int h2=height(root2);
        for(int i=1;i<=h1;i++){
            get(root1, i, a1);
        }
        for(int i=1;i<=h2;i++){
            get(root2, i, a2);
        }
        Collections.sort(a1);
        Collections.sort(a2);
        ArrayList<Integer> r=new ArrayList<>();
        int r1[]=new int[a1.size()];
        int r2[]=new int[a2.size()];
        
        for(int i=0;i<a1.size();i++)
            r1[i]=a1.get(i);
        for(int i=0;i<a2.size();i++)
            r2[i]=a2.get(i);
        for(int i=0;i<r1.length;i++){
            for(int j=0;j<r2.length;j++){
                if(r1[i]==r2[j]){
                    r.add(r1[i]);
                    break;
                }
            }
        }
        return r;
        
    }
    static void get(Node root, int i, ArrayList a){
        if(root==null)
            return;
        else if(i==1)
            a.add(root.data);
        else{
            get(root.left, i-1, a);
            get(root.right, i-1, a);
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

