/*
You are given a linked list of N nodes. The task is to remove the loop from the linked list, if present.

Input:
First line of input contains number of testcases T. T testcases follow. For each testcase, first line of input contains length N of the linked list and next line contains N data of the linked list. The third line contains the position of the node(from head) to which the last node will get connected. If it is 0 then there is no loop.

Output:
For each testcase, in a new line, 1 will be printed if loop is removed and the list still has all N nodes connected to it, else 0 will be printed.

User Task:
Your task is to complete the function removeLoop(). The only argument of the function is head pointer of the linked list. Do not print anything. Simply remove the loop in the list (if present) without disconnecting any nodes from the list.

Expected time complexity : O(n)

Expected auxiliary space : O(1)

Constraints:
1 <= T <= 102
1 <= N <= 104

Example:
Input:
2
3
1 3 4
2
4
1 8 3 4
0
Output:
1
1

Explanation:
Testcase 1: In the first test case N = 3.The linked list with nodes N = 3 is given. Here, x = 2 which means last node is connected with xth node of linked list. Therefore, there exists a loop. 
Testcase 2: N = 4 and x = 0, which means lastNode->next = NULL, thus the Linked list does not contains any loop.
*/



// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            solver x = new solver();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class solver
{
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node c1 = head, c2 = head.next;
        int flag = 0;
        while(c1!=c2){
            if(c2==null || c2.next==null){
                flag = 1;
                break;
            }
            c1=c1.next;
            c2=c2.next.next;
        }
        int size = 1;
        if(flag==0){
            do{
                size++;
                c2=c2.next;
            }while(c1!=c2);
            
            Node n1=head,n2=head;
            // System.out.println(size-1);
            for(int i=1;i<size;i++){
                n2=n2.next;
            }
            // System.out.println(n1.data+" "+n2.data);
            if(n1==n2){
                c1.next=null;
            }
            else{
                while(n1!=n2){
                    n1=n1.next;
                    n2=n2.next;
                }
                for(int i=1;i<size-1;i++){
                    n1=n1.next;
                }
                // System.out.println(n1.data +" n1");
                n1.next=null;
            }
            // Node r=head;
            // System.out.println("c1==="+c1.data+" "+c2.data);
            // while(r!=null){
            //     System.out.print(r.data+" ");
            //     r=r.next;
            // }
        }
    }
}
