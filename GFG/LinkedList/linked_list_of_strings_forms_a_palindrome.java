/*
Given a linked list of strings having n nodes check to see whether the combined string formed is palindrome or not. 

Input:
You have to complete the method which takes one argument: the head of the linked list . You should not read any input from stdin/console.. There are multiple test cases. For each test case, this method will be called individually.

Output:
Your function should return True if the combined string is pallindrome else it should return False.

User Task:
The task is to complete the function compute() which returns true or false.

Constraints:
1 <=T<= 103
1 <=n<= 103

Example:
Input :
2
5
a bc d dcb a
4
a bc d ba

Output :
True
False

Explanation:
case 1 : as String "abcddcba" is palindrome the function should return true
case 2 : as String "abcdba" is not palindrome the function should return false
*/



import java.util.*;
import java.lang.*;

class Node
{
    String data;
    Node next;
    Node(String key)
    {
        data = key;
        next = null;
    }
}

class Palindrome
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String a = sc.next();
            Node head = new Node(a);
            addToTheLast(head);
            for(int i = 1; i < n; i++)
            {
                String a1 = sc.next();
                addToTheLast(new Node(a1));
            }
            
            GfG gfg = new GfG();
            boolean res = gfg.compute(head);
            if(res == true)
            System.out.println("True");
            else
            System.out.println("False");
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
}// } Driver Code Ends


/*node class of the linked list
class Node
{
    String data;
    Node next;
    Node(String key)
    {
        data = key;
        next = null;
    }
}*/
class GfG
{
    public static boolean compute(Node node)
    {
        Node current=node;
        String s1="";
        while(current!=null){
            s1+=current.data;
            current=current.next;
        }
        String s2="";
        for(int i=s1.length()-1;i>=0;i--){
            s2+=s1.charAt(i);
        }
        
        if(s1.equals(s2))
            return true;
        else
            return false;
    }
}

