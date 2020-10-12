/*
Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the new formed list is: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2.

Input:
You have to complete the method which takes 1 argument: the head of the  linked list. You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

Output:
Your function should return a pointer to the rearranged list so obtained.

User Task:
The task is to complete the function inPlace() which should rearrange the given linked list as required.

Constraints:
1 <=T<= 50
1 <= size of linked lists <= 100

Example:
Input:
2
4
1 2 3 4
5
1 2 3 4 5

Output:
1 4 2 3
1 5 2 4 3

Explanation:
Testcase 1: After rearranging the linked list as required, we have 1, 4, 2 and 3 as the elements of the linked list.
*/


import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rerrange
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i < n; i++)
            {
                int data = sc.nextInt();
                addToTheLast(new Node(data));
            }
            GfG gfg = new GfG();
            Node node = gfg.rearrange(head);
            printList(head);
            System.out.println();
        }
    }
    
    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
              temp = temp.next;
              temp.next = node;
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class GfG 
{
    public static Node rearrange(Node root)
    {
        Node slow=root, fast=root;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node h1=root, h2=slow.next, prev=null;
        slow.next=null;
        
        while(h2!=null){
            Node temp=h2.next;
            h2.next=prev;
            prev=h2;
            h2=temp;
        }
        h1=root.next;
    
        while(prev!=null || h2!=null){
            if(prev!=null){
                root.next=prev;
                root=root.next;
                prev=prev.next;
            }
            if(h1!=null){
                root.next=h1;
                root=root.next;
                h1=h1.next;
            }
        }
        return root;
    }
}


