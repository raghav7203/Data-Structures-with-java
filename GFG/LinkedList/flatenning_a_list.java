/*
Given a Linked List of size N, where every node represents a linked list and contains two pointers of its type:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.

You have to flatten the linked list to a single linked list which should be sorted.

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
And after flattening the above list, the sorted linked list looks like:

 5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.

Note: The flattened list will be printed using the bottom pointer instead of next pointer.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer N denoting the number of head nodes connected to each other.
Second line of each test case contains N space separated numbers (M1, M2...Mn) denoting number of elements in linked lists starting with each head.
Third line of each test case contains all the elements of the linked list starting with 1st head node and covering all the elements through its down pointer, then 2nd head node and covering all its elements through down pointer and so on till the last head node of the linked list.

Output:
For each testcase, in a new line, print the flattened list in sorted order.

Your Task:
This is a function problem. You need to complete the function flatten() that takes head of the list as parameter and returns the root of flattened list. The printing is done by the driver code.

Note: Try to solve the problem without using any extra space.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 100
0 <= N <= 50
1 <= Mi <= 20
1 <= Element of linked list <= 103

Example:
Input:
1                   
4 
4 2 3 4                  
5 7 8 30 10 20 19 22 50 28 35 40 45

Output:
5 7 8 10 19 20 22 28 30 35 40 45 50
*/


import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	    // Your code here
	    ArrayList<Integer> a=new ArrayList<>();
	    Node c1=root, c2=root;
	    while(c1!=null){
	        c2=c1;
	        while(c2!=null){
	            a.add(c2.data);
	           //System.out.println(c2.data);
	            c2=c2.bottom;
	        }
	        c1=c1.next;
	    }
	    Collections.sort(a);
	   // System.out.println(a);
	    Node head=null, tail=null;
	    for(int i=0;i<a.size();i++){
	       // System.out.println("data "+a.get(i));
	        Node node=new Node(a.get(i));
	        if(head==null){
	            head=node;
	            tail=node;
	        }
	        else{
	            tail.bottom=node;
	            tail=node;
	        }
	    }
	    return head;
    }
}
