class linkedlist{
  class node{
    int data;
    node next,prev;
   public node(int d){
      data=d;
   }
  }
  node head=null;
  node tail=null;
   public void add(int d){
      node newnode=new node(d);
	if(head==null){
           head=newnode;
	   newnode.prev=null;
	   tail=newnode;
        }
	else{
          tail.next=newnode;
	  newnode.prev=tail;
	  tail=newnode;
        }
   }
   public void duplicate(){
    try{
     node current=head;
	while(current!=null){
	   while(current.data==current.next.data){
		current.next=current.next.next;
	   }
	  current=current.next;
        }
      }
     catch(Exception e){

     }
   }
   public void display(){
      node current=head;
	while(current!=null){
           System.out.println(current.data);
		current=current.next;
        }
   }
}

class doubly7{
  public static void main(String args[]){
     linkedlist li=new linkedlist();
	li.add(1);
	li.add(3);
	li.add(3);
	li.add(4);
	li.add(5);
	li.add(5);
	li.add(5);
	li.add(7);
	li.add(9);
	li.add(9);
	li.add(9);
	li.add(9);
	li.duplicate();
	li.display();
  }
}
