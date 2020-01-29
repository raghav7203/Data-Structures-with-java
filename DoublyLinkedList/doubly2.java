//simple reverse traversing on doubly linkedlist
class linkedlist{
 class node{
   int data;
   node next;
   node prev;
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
    public void reverse(){
       node current=tail;
	while(current!=null){
	    System.out.println(current.data);
	    current=current.prev;
        }
    }
}

class doubly2{
  public static void main(String args[]){
     linkedlist li=new linkedlist();
	li.add(23);
	li.add(7);
	li.add(1);
	li.add(9);
	li.reverse();
  }
}
