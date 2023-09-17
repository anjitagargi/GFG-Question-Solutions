//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    // Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        long[] fibSequence = new long[n];
        
        if (n <= 0) {
            return fibSequence; 
        }
        
        fibSequence[0] = 1;
        
        if (n == 1) {
            return fibSequence; 
        }
        
        fibSequence[1] = 1;
        
        if (n == 2) {
            return fibSequence; 
        }
        
        for (int i = 2; i < n; i++) {
            fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];
        }
        
        return fibSequence;
    }
}
