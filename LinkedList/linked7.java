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
 public void delete(int index){
    node current1=head;
    node previous=head;
     int c=0;
      while(current1!=null){
        if(c==index){
          previous.next=current1.next;
	  break;
        }
	else{
          previous=current1;
	  current1=current1.next;
	  c++;
         }
      }
 }
 public void display(){
    node current=head;
    if(current==null){
       System.out.println("emptylist");
     }
    else{
      while(current!=null){
         System.out.println(current.data);
	 current=current.next;
       }
    }
  }
 
}
class linked7{
  public static void main(String args[]){
    linkedlist li=new linkedlist();
        li.add(11);
	li.add(12);
	li.add(13);
	li.add(14);
	li.add(15);
      li.delete(2);
      li.display();	
  }
}
