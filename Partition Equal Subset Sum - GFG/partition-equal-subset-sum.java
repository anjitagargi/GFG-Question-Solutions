//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static boolean check(int i,int sm,long target,int[] arr,int N,Boolean[][] dp)
    {
        if(sm==target) return true;
        if(i==N) return false;
        
        if(dp[i][sm]!=null) return dp[i][sm];
        
        if(sm+arr[i]>target)
            return dp[i][sm]=check(i+1,sm,target,arr,N,dp);
            
        return dp[i][sm]=check(i+1,sm,target,arr,N,dp) || check(i+1,sm+arr[i],target,arr,N,dp);
    }
    static int equalPartition(int N, int arr[])
    {
        long sum=0;
        
        for(int i=0;i<N;i++) sum+=arr[i];
        
        if(sum%2==1) return 0;
        
        long half=sum/2;
        
        Boolean[][] dp=new Boolean[N][(int)(sum)];
        
        return check(0,0,half,arr,N,dp)?1:0;
    }
}