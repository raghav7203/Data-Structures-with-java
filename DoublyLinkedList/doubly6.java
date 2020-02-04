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
    public void rearrangeEvenodd(){
        node current=head;
	int c=1;
	  node h1=null,t1=null,h2=null,t2=null;
	while(current!=null){
           if(c%2==0){
		
	     node newnode1=new node(current.data);
	     if(h1==null){
		h1=newnode1;
		t1=newnode1;
	     }
	     else{
		t1.next=newnode1;
		t1=newnode1;
             }
	   }
          else{
	    
	   node newnode2=new node(current.data);
	       if(h2==null){
		  h2=newnode2;
		  t2=newnode2;
	       }
	       else{
		  t2.next=newnode2;
		  t2=newnode2;
	       }
          }
	 c++;
	 current=current.next;
        }
      t1.next=h2;
	head=h1;
    }
   public void display(){
      node current=head;
	while(current!=null){
           System.out.println(current.data);
		current=current.next;
        }
   }
}

class doubly6{
  public static void main(String args[]){
     linkedlist li=new linkedlist();
	li.add(1);
	li.add(3);
	li.add(5);
	li.add(7);
	li.add(9);
	li.add(11);
	li.add(13);
	li.rearrangeEvenodd();
	li.display();
  }
}
