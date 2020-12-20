/*
Given a doubly linked list and a position. The task is to delete a node from given position in a doubly linked list.

Example 1:

Input:
LinkedList = 1 <--> 3 <--> 4 
x = 3
Output: 1 3  
Explanation: After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.
Example 2:

Input:
LinkedList = 1 <--> 5 <--> 2 <--> 9  
x = 1
Output: 5 2 9
Your Task:
The task is to complete the function deleteNode() which should delete the node at given position and return the head of the linkedlist.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
2 <= size of the linked list <= 1000
1 <= x <= N
*/


//Initial Template for Java
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
class Delete_Node_From_DLL
{
	Node head;
	Node tail;
	
	void addToTheLast(Node node)
	{
		if(head ==  null)
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	void printList(Node head)
	{	Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp =  temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Delete_Node_From_DLL list = new Delete_Node_From_DLL();
			
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			list.addToTheLast(head);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			a1 = sc.nextInt();
			GfG g = new GfG();
			//System.out.println(list.temp.data);
			Node ptr = g.deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}
}


                               // } Driver Code Ends


//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class GfG
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
    	// Your code here
    	if(head==null)
    	    return null;
    	Node current=head;
    	int i=1;
    	if(x==1){
    	    head=head.next;
    	    return head;
    	}
    	while(current!=null){
    	    if(i==x){
    	        current.prev.next=current.next;
    	        break;
    	    }
    	    i++;
    	    current=current.next;
    	}
    	return head;
    }
}

