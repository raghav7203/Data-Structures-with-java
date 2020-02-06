class linkedlist{
   class node{
     int data;
     node next,prev;
    public node(int d){
        data=d;
	next=null;
	prev=null;
    }
   }
   node head=null;
   node tail=null;
     public void add(int d){
        node newnode=new node(d);
	   if(head==null){
              head=newnode;
	      tail=newnode;
           }
	   else{
              tail.next=newnode;
	      tail=newnode;
	      tail.next=head;
           }
     }
    public void display(){
	node current=head;
	   do{
              System.out.println(current.data);
		current=current.next;
           }
	   while(current!=head);
    }
 }

class circular1{
   public static void main(String args[]){
      linkedlist li=new linkedlist();
	li.add(23);
	li.add(7);
	li.add(1);
	li.add(9);
	li.display();
   }
 }
