class LinkedList{  
    class Node{
        int data;
        Node next;
        public Node(int d){
            data=d;
            next=null;
        }
    }
    public Node head=null;
    public Node tail=null;
    public void add(int d){
        Node newNode=new Node(d);
	if(head==null){
        head=newNode;
        tail=newNode;
      }
        
	if(newNode.data>head.data && newNode.data<tail.data){
            Node current1=head;
	    Node previous=head;
	      while(current1!=null){
		if(current1.data<newNode.data){
                  previous=current1;
		  current1=current1.next;
                }
		else{
                 previous.next=newNode;
		 newNode.next=current1;
		 
		 break;
                }
              }
         }
       else if(newNode.data>head.data){
           tail.next=newNode;
	   tail=newNode;
        }
	else if(newNode.data<head.data){
           newNode.next=head;
	   head=newNode;
         }
    }
    public void display(){
        Node current=head;
        if(current==null){
            System.out.println("Empty");
        }
        else{
            while(current!=null){
                System.out.println(current.data);
                current=current.next;
            }
        }
	
    }
}
public class sortedItself {

	public static void main(String[] args) {

		LinkedList li=new LinkedList();
		li.add(2);
		li.add(4);
		li.add(3);
		li.add(1);
	   	li.add(6);
		li.add(9);
		li.add(5);
		li.add(11);
		li.add(21);
		li.add(15);
		li.display();
	}

}
