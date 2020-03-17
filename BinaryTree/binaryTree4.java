//depth first inorder traversal
class node{
  int data;
  node left,right;
    public node(int d){
	data=d;
	left=right=null;
    }
}
class binaryTree4{
  node root=null;
  public void display(){
    display(root);
  }
  public void display(node root){
    if(root==null)
      return;
    else{
        display(root.left);
	System.out.println(root.data);
	display(root.right);
    }
  }
  public static void main(String args[]){
     binaryTree4 tree=new binaryTree4();
	tree.root=new node(1);
	tree.root.left=new node(2);
	tree.root.right=new node(3);
	tree.root.left.left=new node(4);
	tree.root.left.right=new node(5);
     tree.display();
  }
}
