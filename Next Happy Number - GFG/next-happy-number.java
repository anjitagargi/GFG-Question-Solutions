//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//   >> JAVA CODE <<

class Solution{

    static int nextHappy(int N) {
        int nextNumber = N + 1;
        
        while (true) {
            if (isHappy(nextNumber)) {
                return nextNumber;
            }
            
            nextNumber++;
        }
    }
    
    private static boolean isHappy(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        while (!mp.containsKey(n)) {
            mp.put(n, 1);
            int sum = 0;
            
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            
            if (sum == 1) {
                return true;
            }
            
            n = sum;
        }
        
        return false;
    }
}