//basic binary tree structure
class node{
   int data;
   node right,left;
     public node(int d){
	data=d;
	left=right=null;
     }
}	
class binaryTree1{
node root=null;
   public void display(){
        System.out.println("root--->"+root.data);
	System.out.println("root.left--->"+root.left.data);
	System.out.println("root.right--->"+root.right.data);
	System.out.println("root.left.left--->"+root.left.left.data);
	System.out.println("root.left.right--->"+root.left.right.data);	
   }
 public static void main(String args[]){
   binaryTree1 tree=new binaryTree1();
	tree.root=new node(1);
	tree.root.left=new node(2);
	tree.root.right=new node(3);
	tree.root.left.left=new node(4);
	tree.root.left.right=new node(5);
        tree.display();
 }
}
