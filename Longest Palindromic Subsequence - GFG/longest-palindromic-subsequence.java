//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
         String R = new StringBuilder(S).reverse().toString();
 
        int dp[][]  = new int[S.length() + 1][R.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= R.length(); j++) {
                if (S.charAt(i - 1) == R.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1],
                                        dp[i - 1][j]);
            }
        }
 
        return dp[S.length()][R.length()];
    }
}