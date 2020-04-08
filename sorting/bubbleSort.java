import java.util.*;
class bubbleSort{
 public static void sort(int a[]){
     for(int p=0;p<a.length-1;p++){
	for(int i=0;i<a.length-p-1;i++){
	  if(a[i]>a[i+1]){
	     int t=a[i];
	     a[i]=a[i+1];
	     a[i+1]=t;
          }
        }
     }
 }
 public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.println("Enter array length");
    int n=s.nextInt();
    int a[]=new int[n];
    for(int i=0;i<a.length;i++){
	a[i]=s.nextInt();
    }
    sort(a);
    for(int i=0;i<a.length;i++){
	System.out.println(a[i]);
    }
 }

}
