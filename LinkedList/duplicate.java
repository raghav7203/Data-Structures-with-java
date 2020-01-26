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
   public void removeDuplicacy(){
      node i=head;
        node j;
	node previous;
        while(i!=null){
	  j=i.next;
	  previous=i;
	 while(j!=null){
           if(i.data==j.data){
              previous.next=j.next;
           }
	   else{
	    previous=j;
           }
	  j=j.next;
         }
	i=i.next;
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

class duplicate{
    public static void main(String args[]){
       linkedlist li=new linkedlist();
	li.add(1);
	li.add(1);
	li.add(1);
	li.add(1);
	li.add(1);
	li.removeDuplicacy();
	li.display();
   }
 }
