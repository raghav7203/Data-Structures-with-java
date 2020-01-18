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
    if(head==null)
      {
         head=newnode;
	 tail=newnode;
      }
     else{
       tail.next=newnode;
       tail=newnode;
     }
  }
  public void insert(int d1){
    node newnode1=new node(d1);
      node current1=head;
      node previous=head; 
      while(current1!=null){
        if(newnode1.data>current1.data){
         previous=current1; //previous is kinda temp to hold value here
         current1=current1.next;
         }
	else{
         previous.next=newnode1;
	 newnode1.next=current1;
	 break;
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
class linked6{
   public static void main(String args[]){
      linkedlist li=new linkedlist();
        li.add(11);
	li.add(23);
	li.add(27);
	li.add(30);
	li.add(36);
        li.insert(17);
     li.display();
   }
 }
