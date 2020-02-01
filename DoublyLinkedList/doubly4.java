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
    public void swapNodes(int x,int y){
        int i=1;
        node c1=head;
	node temp1=head,temp2=head;
	int temp;
	while(c1!=null){
           if(i==x){
             temp1=c1;
           }
	   else if(i==y){
            temp2=c1;
           }
	   i++;
	   c1=c1.next;
        }
        temp=temp1.data;
	temp1.data=temp2.data;
	temp2.data=temp;
    }
   public void display(){
      node current=head;
	while(current!=null){
           System.out.println(current.data);
		current=current.next;
        }
   }
}

class doubly4{
  public static void main(String args[]){
     linkedlist li=new linkedlist();
	li.add(1);
	li.add(2);
	li.add(3);
	li.add(4);
	li.add(5);
	li.add(6);
	li.swapNodes(3,5);
	li.display();
  }
}
