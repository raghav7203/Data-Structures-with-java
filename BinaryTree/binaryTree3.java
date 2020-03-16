//breadth first traversal or level order traversal using queue
import java.util.*;
class node{
  int data;
  node left,right;
    public node(int d){
      data=d;
      left=right=null;
    }
}
class binaryTree3{
  node root=null;
  public void display(){
	ArrayDeque<node> queue=new ArrayDeque<node>();
	queue.add(root);
	while(!queue.isEmpty()){
	   node temp=queue.poll();
	   System.out.println(temp.data);
		if(temp.left!=null)
		  queue.add(temp.left);
		if(temp.right!=null)
		  queue.add(temp.right);
	}
  }
  public static void main(String args[]){
     binaryTree3 tree=new binaryTree3();
	tree.root=new node(1);
	tree.root.left=new node(2);
	tree.root.right=new node(3);
	tree.root.left.left=new node(4);
	tree.root.left.right=new node(5);
     tree.display();
  }
}
