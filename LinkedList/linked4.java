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
   public void mid(int p,int d1){
      node newnode1=new node(d1);
        node current1=head;
       int c=1; 
      while(current1!=null){
         if(c==p-1){
           newnode1.next=current1.next;
	   current1.next=newnode1;
	   break;
         }
	current1=current1.next;
        c++;
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
public class linked4{
 public static void main(String args[]){
    linkedlist1 li=new linkedlist1();
     li.add(2);
     li.add(3);
     li.add(4);
     li.add(6);
     li.add(7);
     li.mid(4,5);
     li.display();
 } 
}
