/*
Given postorder traversal of a Binary Search Tree, you need to complete the function constructTree() which will create a BST. The output will be the inorder of the constructed BST.

Input:
The constructTree() method consist of two arguments as input, the array consisting of the post order traversal and the size of the array.

Output:
Print the Inorder traversal of the constructed BST.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
6
1 7 5 50 40 10
9
216 823 476 429 850 93 18 975 862

Output:
1 5 7 10 40 50
18 93 216 429 476 823 850 862 975

Explanation:
Testcase 1: The BST for the given post order traversal is:


Thus the inorder traversal of BST is: 1 5 7 10 40 50.
*/

//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG(n);
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    GFG(int n){}
    
    public static Node constructTree(int post[],int n)
    {
        //Add your code here.
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(post[i]>post[j]){
                    int t=post[i];
                    post[i]=post[j];
                    post[j]=t;
                }
            }
        }
        int mid=0;
        if(n%2==0){
            mid=(n/2)+1;
        }
        else{
            mid=n/2;
        }
        Node root=new Node(post[mid]);
        root.left=bst(post, 0, mid-1);
        root.right=bst(post, mid+1, n-1);
        
        return root;
    }
    static Node bst(int a[], int l, int r){
        if(l<=r){
            int mid=(l+r)/2;
            Node root=new Node(a[mid]);
            root.left=bst(a, l, mid-1);
            root.right=bst(a, mid+1, r);
            return root;
        }
        else{
            return null;
        }
    }
    
}
