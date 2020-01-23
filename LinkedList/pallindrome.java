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
  public void checkPallindrome(){
     node current=head;
	node previous=null;
	while(current!=null){
	  node n1=new node(current.data);
            n1.next=previous;
	    previous=n1;
	    current=current.next;
        }
     node head1=previous;
    node c=head;
	node c1=head1;
	int f=0;
	while(c!=null){
             if(c.data==c1.data){
		c=c.next;
		c1=c1.next;
              }
	     else{
		f=1;
		break;
             }
        }
      if(f==0){
	System.out.println("Yes,the given list is pallindrome");
      }
      else{
         System.out.println("No,the given list is not pallindrome");
      }
  }
}

class pallindrome{
  public static void main(String args[]){
     linkedlist li=new linkedlist();
	li.add(2);
	//li.add(1);
	//li.add(1);
	//li.add(2);
	li.checkPallindrome();
  }
}
