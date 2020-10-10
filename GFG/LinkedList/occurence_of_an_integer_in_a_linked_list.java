/*
Given a singly linked list and a key, count number of occurrences of given key in linked list. For example, if given linked list is 1->2->1->2->1->3->1 and given key is 1, then output should be 4.

Input:
You have to complete the method which takes two argument: the head of the linked list and int k. You should not read any input from stdin/console. The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list. There are multiple test cases. For each test case, this method will be called individually.

Output:
You have to count a number of occurrences of given key in linked list and return the count value.

User Task:
The task is to complete the function count() which counts the number of occurrences of given element.

Example:
Input:
1
8
1 2 2 4 5 6 7 8
2

Output:
2

Explanation:
Testcase 1: 2 is occurring twice in the given linked list.
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

class Occurrence
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            int k = sc.nextInt();
            GfG gfg = new GfG();
            System.out.println(gfg.frequency(head, k));
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
            while(temp.next !=  null)
              temp = temp.next;
              temp.next = node;
        }
    }
}// } Driver Code Ends



/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
// complete the below function
class GfG
{
    public static int frequency(Node node, int search)
    {
        int c=0;
        Node current=node;
        while(current!=null){
            if(current.data==search)
                c++;
            current=current.next;
        }
        return c;
    }
}
