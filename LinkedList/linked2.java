import java.util.*;
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
    public void display(){
       node current=head;
        if(current==null){
           System.out.println("EmptyList");
         }
	else{
           while(current!=null){
             System.out.println(current.data);
	      current=current.next;
            }
          }
     }
}

public class linked2{
  public static void main(String args[]){
     linkedlist li=new linkedlist();
     //li.add(2);
     //li.add(4);
     li.display();
  }
}
