import java.util.*; //using this only for Scanner
class stack{
class node{
  char data;
  node next;
 public node(char d){
   data=d;
   next=null;
 }
}
  node head=null;
  node tail=null;
public static int c=1;
public int flag=0;
 public void push(char d){
   //20 is limit of stack here
   if(c>20){
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
  /*public void peak(){
	if(flag==1)
	  return;
	else
    System.out.println(head.data);
  }*/
   public char peak(){
      return head.data;
   }
   public boolean isEmpty(){
     if(head==null)
	return true;
     else
	return false;
   }
  public void display(){
         if(flag==1)
	   head=null;
	node current=head;
	while(current!=null){
          System.out.print(current.data);
	  current=current.next;
        }
  }
}
class stack2{
  public static void main(String args[]){
   stack st=new stack();
	Scanner s=new Scanner(System.in);
	System.out.print("Enter a string:");
	String str=s.next();
	String s1="";
	char temp=0;
	for(int i=0;i<str.length();i++){
	   if(str.charAt(i)>='A' && str.charAt(i)<='Z' || str.charAt(i)>='a' && str.charAt(i)<='z'){
              s1+=str.charAt(i);
           }
	   else{
		if(st.isEmpty()){
		  st.push(str.charAt(i));
		}
		else if(str.charAt(i)=='+' && st.peak()=='-' || str.charAt(i)=='-' && st.peak()=='+'){
              	     temp=st.peak();
 		     s1+=temp;
		     st.pop();
		     st.push(str.charAt(i));
                }
	        else if(str.charAt(i)=='*' && st.peak()=='/' || str.charAt(i)=='*' && st.peak()=='%'){
		     temp=st.peak();
 		     s1+=temp;
		     st.pop();
		     st.push(str.charAt(i));
		}
		else if(str.charAt(i)=='/' && st.peak()=='*' || str.charAt(i)=='/' && st.peak()=='%'){
		     temp=st.peak();
 		     s1+=temp;
		     st.pop();
		     st.push(str.charAt(i));
		}
		else if(str.charAt(i)=='%' && st.peak()=='*' || str.charAt(i)=='%' && st.peak()=='/'){
		     temp=st.peak();
 		     s1+=temp;
		     st.pop();
		     st.push(str.charAt(i));
		}
		else{
                  st.push(str.charAt(i));
                }
           }
	}
	while(!st.isEmpty()){
	  temp=st.peak();
	  s1+=temp;
	  st.pop();
	}
	System.out.println(s1);
	st.display();
 }
}
