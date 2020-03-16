//breadth first traversal or level order traversal using recursion
class node{
  int data;
  node left,right;
    public node(int d){
      data=d;
      left=right=null;
    }
}
class binaryTree2{
  node root=null;
  public void display(){
    int h=height(root);
	for(int i=1;i<=h;i++){
	   printCorrespondingLevel(i,root);
        }
  }
  public int height(node root){
     if(root==null){
	return 0;
     }
     else{
        int lh=height(root.left);
	int rh=height(root.right);
	  if(lh>rh)
            return(lh+1);
	  else
	    return(rh+1);
     }
  }
  public void printCorrespondingLevel(int level,node root){
	if(root==null)
	   return;
	else if(level==1)
	  System.out.println(root.data);
	else{
          printCorrespondingLevel(level-1,root.left);
	  printCorrespondingLevel(level-1,root.right);
        }
  }
  public static void main(String args[]){
     binaryTree2 tree=new binaryTree2();
	tree.root=new node(1);
	tree.root.left=new node(2);
	tree.root.right=new node(3);
	tree.root.left.left=new node(4);
	tree.root.left.right=new node(5);
     tree.display();
  }
}
