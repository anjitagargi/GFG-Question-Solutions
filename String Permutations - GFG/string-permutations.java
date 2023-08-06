//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> result = new ArrayList<>();
        generatePermutations(S.toCharArray(), 0, result);
        Collections.sort(result); // Sort the permutations lexicographically
        return result;
    }

    private void generatePermutations(char[] arr, int index, ArrayList<String> result)
    {
        if (index == arr.length - 1)
        {
            result.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++)
        {
            swap(arr, index, i);
            generatePermutations(arr, index + 1, result);
            swap(arr, index, i); // Backtrack
        }
    }

    private void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
