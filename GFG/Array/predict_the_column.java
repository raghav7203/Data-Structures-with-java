/*
Given a matrix(2D array) M of size N*N consisting of 0s and 1s only. The task is to find the column with maximum number of 0s.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines of input, first of which contains N and next N line contains N elements.

Output:
For each testcase, output the column with maximum number of 0s.

Constraints:
1 <= T <= 100
1 <= N <= 102
0 <= A[i][j] <= 1

User Task:
Your task is to complete the function columnWithMaxZero() which should return the column number with maximum number of zeros. If more than one column exists, print the one which comes first.

Example:
Input:
1
3
1 1 0
1 1 0
1 1 0

Output:
2

Explanation:
Testcase 1: 2nd column (0-based indexing) is having 3 zeros which is maximum.
*/

//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends


//User function Template for Java

/*Class Geeks with its member function columnWithMaxZero()
* a[][] = matrix input
* n : number of rows and columns each
*/
class Geeks{
    
    static int columnWithMaxZero(int a[][],int n){
        
        // Your code here
        int r=0, c=0, max=0;
        for(int i=0;i<n;i++){
            c=0;
            for(int j=0;j<n;j++){
                if(a[j][i]==0)
                    c++;
            }
            if(c>max){
                r=i;
                max=c;
            }
        }
        return r;
        
    }
}

// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) {
	    // Taking input using scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int testcase = sc.nextInt();
		
		while(testcase-- > 0){
		    
		    //taking size of 2d-array
		    int n = sc.nextInt();

            //creating a 2d-array
		    int a[][] = new int[n][n];
		    
		    //adding elements to the array
		    for(int i = 0;i<n;i++){
		        for(int j = 0;j<n;j++){
		            a[i][j] = sc.nextInt();
		        }
		    }
		    
		    //creating an object of Geeks clas
		    Geeks obj = new Geeks();
		    
		    //calling the method columnWithMaxZero()
		    //of class Geeks
		    System.out.println(obj.columnWithMaxZero(a, n));
		}
	}
}  // } Driver Code Ends
