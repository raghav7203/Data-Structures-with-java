//depth first postorder traversal
class node{
   int data;
   node left,right;
      public node(int d){
         data=d;
	 left=right=null;
      }
}
class binaryTree6{
 node root=null;
 public void display(){
   display(root);
 }
 public void display(node root){
    if(root==null)
	return;
    else{
      display(root.left);
      display(root.right);
      System.out.println(root.data);
    }
 }
 public static void main(String args[]){
    binaryTree6 tree=new binaryTree6();
	tree.root=new node(1);
	tree.root.left=new node(2);
	tree.root.right=new node(3);
	tree.root.left.left=new node(4);
	tree.root.left.right=new node(5);
     tree.display();	
 }
}
