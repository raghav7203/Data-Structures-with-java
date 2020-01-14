import java.util.*;
 class linkedlist1{
 class node{
   int data;
   node next;
  
  public node(int d){
     data=d;
     next=null;
   }
 }
 public node head=null;
 public node tail=null;
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
public class linked1{
 public static void main(String args[]){
    linkedlist1 li=new linkedlist1();
     li.add(3);
     li.add(5);
     li.display();
 } 
}
