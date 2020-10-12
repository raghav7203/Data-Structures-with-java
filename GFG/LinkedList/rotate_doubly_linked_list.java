/*
Given a doubly linked list, rotate the linked list counter-clockwise by P nodes. Here P is a given positive integer and is smaller than the count of nodes(N) in a linked list.

Input:
The first line of input contains an integer T denoting the no of test cases. For each test case, the first line of input contains two integers N and P denoting the number of nodes in Linked List and the number of nodes to be rotated respectively.

Output:
For each test case, output the final linked list after the P rotations in it.

Constraints:
1 <= T <= 100
2 <= N <= 100
1 <= P <= N

Example:
Input:
1
6 2
1 2 3 4 5 6

Output:
3 4 5 6 1 2

Explanation:
Testcase 1: Doubly linked list after rotating 2 nodes is: 3 4 5 6 1 2.
*/


//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node prev, next;
    
    public Node (int d){
        this.data = d;
        prev = null;
        next = null;
    }
}

public class doubly_LL {
    
    static void display(Node node){
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }
    

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int p = sc.nextInt();
		       
		    //Entering the data
		    Node head = new Node(sc.nextInt());
		    Node curr = head;
		    
		    //Entering the rest of the list
		    for(int i=0; i<n-1; i++){
		        int d = sc.nextInt();
		        curr.next = new Node(d);
		        curr = curr.next;
		    }
            
            Gfg obj = new Gfg();
            display(obj.rotateP(head, p));
		}
	}

}
// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node prev, next;
    
    public Node (int d){
        this.data = d;
        prev = null;
        next = null;
    }
}
*/

class Gfg {
    Node rotateP (Node head, int p){
        //Write your code here
        Node tail=head;
        int c=1;
        
        while(tail.next!=null){
            c++;
            tail=tail.next;
        }
        // System.out.println(tail.data+" "+c);
        if(c==1)
            return head;
        
        while(p>0){
            head.prev=tail;
            tail.next=head;
            head=head.next;
            head.prev=null;
            tail=tail.next;
            tail.next=null;
            p--;
        }
        return head;
    }
}
