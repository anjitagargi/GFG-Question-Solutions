//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
    HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int value = map.getOrDefault(a[i], 0);
            map.put(a[i], value + 1);
        }
            
            for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (size / 2)) {
                return it.getKey();
            }
            }
        return -1;
    }
}