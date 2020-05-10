import java.util.*;
class quickSort{
  public static int partition(int a[],int l,int r){
     int i,j,pivot;
	pivot=a[r];
	i=l-1;
	for(j=l;j<r;j++){
	   if(a[j]<pivot){
             i++;
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
           }
        }
     int t=a[i+1];
	 a[i+1]=a[r];
	 a[r]=t;
    return i+1;
  }
  public static void sort(int a[],int l,int r){
      if(l<r){
        int p=partition(a,l,r);
	sort(a,l,p-1);
	sort(a,p+1,r);
      }
  }
  public static void main(String args[]){
      Scanner s=new Scanner(System.in);
      System.out.println("Enter array length:");
	int n=s.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++)
	  a[i]=s.nextInt();
	sort(a,0,n-1);
	  for(int i=0;i<n;i++)
	    System.out.println(a[i]);
  }
}
