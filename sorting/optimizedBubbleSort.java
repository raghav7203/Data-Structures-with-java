import java.util.*;
class optimizedBubbleSort{
  public static void sort(int a[]){
     for(int p=0;p<a.length-1;p++){
	  int f=0;
	for(int i=0;i<a.length-p-1;i++){
	   if(a[i]>a[i+1]){
	      int t=a[i];
	      a[i]=a[i+1];
	      a[i+1]=t;
	      f=1;
           }
        }
       if(f==0)
	break;
     }
  }
  public static void main(String args[]){
     Scanner s=new Scanner(System.in);
       System.out.println("Enter length of array");
       int n=s.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++){
	  a[i]=s.nextInt();
       }
     sort(a);
     for(int i=0;i<n;i++){
	System.out.println(a[i]);
     }
  }
}
