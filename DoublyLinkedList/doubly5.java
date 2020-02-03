//it's more or less a singly list coz i haven't updated prev value here.
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
    public void rotate(int k){
       node current=head;
	while(k>0){
          node temp=new node(current.data);
	  tail.next=temp;
	  head=current.next;
	  tail=temp;
	  current=current.next;
	  k--;
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

class doubly5{
  public static void main(String args[]){
     linkedlist li=new linkedlist();
	li.add(1);
	li.add(2);
	li.add(3);
	li.add(4);
	li.add(5);
	li.add(6);
	li.add(7);
	li.rotate(4);
	li.display();
  }
}
