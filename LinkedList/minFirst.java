class linkedlist{
  class node{
    int data;
    node next;
   public node(int d){
     data=d;
     next=null;
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
        }
   }
   public void shiftSmall(){
      node current1=head;
	node min=current1;
	while(current1!=null){
          if(current1.data<min.data){
              min=current1;
          }
	  current1=current1.next;
        }
      node temp=head;
	node previous=head;
	while(temp!=min){
          previous=temp;
	  temp=temp.next;
        }
     previous.next=min.next;
     min.next=head;
     head=min;  
   }
    public void display(){
      node current=head;
	while(current!=null){
          System.out.println(current.data);
	  current=current.next;
        }
    }
}

class minFirst{
   public static void main(String args[]){
  linkedlist li=new linkedlist();
	li.add(12);
	li.add(8);
	li.add(6);
	li.add(20);
	li.add(1);
	li.add(50);
	li.add(16);
	li.shiftSmall();
	li.display();
 }
}
