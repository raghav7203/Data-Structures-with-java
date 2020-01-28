//simple add function
class linkedlist{
  class node{
   int data;
   node prev,next;
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
	  newnode.prev=null;
	  tail=newnode;
       }
	else{
          tail.next=newnode;
	  newnode.prev=tail;
	  tail=newnode;
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

class doubly1{
  public static void main(String args[]){
    linkedlist li=new linkedlist();
	li.add(12);
	li.add(4);
	li.add(31);
	li.add(23);
	li.display();
  }
}
