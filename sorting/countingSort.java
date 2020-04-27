import java.util.*;
class countingSort{
 public static void sort(int a[]){
    int n=a.length;
    int max=a[0],size;
    for(int i=0;i<n;i++){
	if(a[i]>max)
	  max=a[i];
    }
    size=max+1;
    int count[]=new int[size];
    int result[]=new int[n];
    for(int i=0;i<n;i++){
        count[a[i]]++;
    }
    for(int i=1;i<size;i++){
	count[i]+=count[i-1];
    }
    for(int i=n-1;i>=0;i--){
	result[count[a[i]]-1]=a[i];
 	count[a[i]]--;
    }
    for(int i=0;i<n;i++){
	a[i]=result[i];
    }
    
 }

 public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.println("Enter array length");
      int n=s.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++)
	  a[i]=s.nextInt();
      sort(a);
	for(int i=0;i<n;i++)
	  System.out.println(a[i]);
 }
}
