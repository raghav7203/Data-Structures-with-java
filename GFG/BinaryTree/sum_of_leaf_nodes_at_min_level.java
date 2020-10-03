/*
Given a Binary Tree of size N, your task is to complete the function minLeafSum(), that should return the sum of all the leaf nodes that are at minimum level of the given binary tree.
Example:

Input : 
         1
        /  \
       2    3
     /  \     \
    4    5     8 
  /  \ 
 7    2      
Output :
sum = 5 + 8 = 13
Input:
The function takes a single arguments as input, the reference pointer to the root of the binary tree.
There are T test cases and for each test case the function will be called separately.

Output:
The function should return the sum of all the leaf nodes that are at the minimum level of the binary tree.

Constraints:
1<=T<=103
0<=N<=103

Example:
Input:
2
2
1 2 L 1 3 R
5
10 20 L 10 30 R 20 40 L 20 60 R 30 90 L
Output:
5
190
*/

//Initial Template for Java
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class TreeNode{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            //inorder(root);
            GfG g=new GfG();
            System.out.println(g.minLeafSum(root));
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class GfG{
    public int minLeafSum(Node root){
        //Your Code Here.
        if(root==null)
            return 0;
        else{
            get(root, 1);
            int i=c;
            c=0;
            return sum(root, i);
        }
    }
    public int sum(Node root, int i){
        if(root==null || i==0)
            return 0;
        else if(i==1 && root.left==null && root.right==null)
            return root.data;
        else{
            int ls=sum(root.left, i-1);
            int rs=sum(root.right, i-1);
            return ls+rs;
        }
    }
    int c=1, f=0;
    public void get(Node root, int i){
        if(root==null)
            return;
        else if(root.left==null && root.right==null){
            if(f==0){
                c=i;
                f=1;
            }
            if(f==1 && i<c){
                c=i;
            }
        }
        else{
            get(root.left, i+1);
            get(root.right, i+1);
        }
    }
}
