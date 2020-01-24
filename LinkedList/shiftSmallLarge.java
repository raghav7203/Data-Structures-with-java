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
	public void shift(){
          node min,max,current1;
	    min=max=current1=head;
	  while(current1!=null){
	       if(current1.data<min.data){
                   min=current1;
               }
	       if(current1.data>max.data){
                   max=current1;
               }
	    current1=current1.next;
          }
	 node temp1,temp2,previous1,previous2;
	  temp1=temp2=previous1=previous2=head;
	   while(temp1!=min){
             previous1=temp1;
	     temp1=temp1.next;
           }
	      previous1.next=min.next;
		min.next=head;
		head=min;
	   while(temp2!=max){
              previous2=temp2;
	      temp2=temp2.next;
           }
		previous2.next=max.next;
		tail.next=max;
		max.next=null;
	  
        }
     public void display(){
	node current=head;
	   while(current!=null){
              System.out.println(current.data);
		current=current.next;
           }
     }
}

class shiftSmallLarge{
  public static void main(String args[]){
    linkedlist li=new linkedlist();
	li.add(1);
	li.add(8);
	li.add(6);
	li.add(20);
	li.add(12);
	li.add(50);
	li.add(16);
	li.shift();
	li.display();
 }
}
