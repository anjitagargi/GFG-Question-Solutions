//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
         ArrayList<Integer> result = new ArrayList<>();

        String binaryStr = Integer.toBinaryString(N);

        binaryStr = String.format("%16s", binaryStr).replace(' ', '0');

        int length = binaryStr.length();

        String leftRotated = binaryStr.substring(D % length) + binaryStr.substring(0, D % length);
        int leftResult = Integer.parseInt(leftRotated, 2);
        result.add(leftResult);

        String rightRotated = binaryStr.substring(length - (D % length)) + binaryStr.substring(0, length - (D % length));
        int rightResult = Integer.parseInt(rightRotated, 2);
        result.add(rightResult);

        return result;
    }

    
}

