class stack{
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
public static int c=1;
public int flag=0;
 public void push(int d){
   //4 is limit of stack here
   if(c>4){
     System.out.println("Overflow");
	flag=1;
   }
   else{
   node newnode=new node(d);
   if(head==null){
     head=newnode;
     tail=newnode;
   }
   else{
     newnode.next=head;
     head=newnode;
   }
    c++;
  }
 }
 public void pop(){
     c--;
   if(head==null){
      System.out.println("Underflow");
   }
   else{
   head=head.next;
   }
 }
  public void peak(){
	if(flag==1)
	  return;
	else
    System.out.println(head.data);
  }
  public void display(){
         if(flag==1)
	   head=null;
	node current=head;
	while(current!=null){
          System.out.println(current.data);
	  current=current.next;
        }
  }
}
class stack1{
  public static void main(String args[]){
   stack st=new stack();
	st.push(1);
	st.push(2);
	st.push(3);
	st.push(4);
	st.push(5);
	st.pop();
	st.pop();
	st.peak();
	st.display();
 }
}
