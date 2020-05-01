import java.util.*;
public class mergeSort{
public static void merge(int a[],int l,int m,int r){
  int s1,s2;
  s1=m-l+1;
  s2=r-m;

  int la[]=new int[s1];
  int ra[]=new int[s2];
    for(int i=0;i<s1;i++)
     la[i]=a[l+i];
    for(int j=0;j<s2;j++)
     ra[j]=a[m+1+j];

    int i=0,j=0,k=l;
    while(i<s1&&j<s2){
	if(la[i]<=ra[j]){
	  a[k]=la[i];
	  i++;
	  k++;
	}
	else{
	  a[k]=ra[j];
	  j++;
	  k++;
	}
    }

   while(i<s1){
    a[k]=la[i];
    i++;
    k++;
   }

   while(j<s2){
    a[k]=ra[j];
    j++;
    k++;
   }
}
public static void sort(int a[],int l,int r){
  if(l<r){
    int m=(l+r)/2;
    sort(a,l,m);
    sort(a,m+1,r);
    merge(a,l,m,r);
  }
}

 public static void main(String args[]){
    Scanner s=new Scanner(System.in);
     System.out.println("Enter length of array");
     int n=s.nextInt();
     int a[]=new int[n];
	for(int i=0;i<a.length;i++){
	   a[i]=s.nextInt();
        }
     
      sort(a,0,a.length-1);
      
      for(int i=0;i<a.length;i++){
	System.out.println(a[i]);
     }  
 }

}
