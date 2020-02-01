//add at any index first,last and middle
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
   public void merge(int ind,int d){
       node current=head;
	node c2=head;
	int r=0;
	  while(c2!=null){
             r++;
	     c2=c2.next;
          }
	node newnode=new node(d);
	int c=0;
	  if(ind==0){
             head.prev=newnode;
	     newnode.next=head;
	     head=newnode;
          }
         else if(ind==r){
            tail.next=newnode;
	    newnode.prev=tail;
	    tail=newnode;
         }
	else if(ind>r)
	  {
	     System.out.println("Index out of bound");
	     clearAll();
	  }
         else{
	while(current!=null){
            if(c==ind){
               node temp=current.prev;
	       newnode.next=current;
	       current.prev=newnode;
	       newnode.prev=temp;
	       temp.next=newnode;
		break;
            }
	    else{
              c++;
            }
	  current=current.next;
        }
       }
   }
   public void clearAll(){
	head=null;
   }
   public void display(){
     node c1=head;
       while(c1!=null){
          System.out.println(c1.data);
	  c1=c1.next;
       }
   }
 }

class doubly3{
   public static void main(String args[]){
   linkedlist li=new linkedlist();
	li.add(23);
	li.add(7);
	li.add(1);
	li.add(9);
	li.add(15);
	li.merge(6,5);
	li.display();
   }	
 }
