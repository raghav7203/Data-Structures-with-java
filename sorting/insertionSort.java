import java.util.*;
class insertionSort{
  public static void sort(int a[]){
     for(int k=1;k<a.length;k++){
	int key=a[k];
	int j=k-1;
	while(j>=0&&a[j]>key){
	   a[j+1]=a[j];
	   j--;
        }
       a[j+1]=key;
     }
  }
  public static void main(String args[]){
      Scanner s=new Scanner(System.in);
	System.out.println("Enter array length");
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
