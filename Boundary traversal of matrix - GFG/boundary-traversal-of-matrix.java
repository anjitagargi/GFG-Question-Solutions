//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{

    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        
        if(n==1)
            for(int i=0;i<m;i++) ans.add(matrix[0][i]);
        else if(m==1)
            for(int i=0;i<n;i++) ans.add(matrix[i][0]);
        else{
            for(int i=0;i<m-1;i++) ans.add(matrix[0][i]);
            for(int i=0;i<n-1;i++) ans.add(matrix[i][m-1]);
            for(int i=m-1;i>0;i--) ans.add(matrix[n-1][i]);
            for(int i=n-1;i>0;i--) ans.add(matrix[i][0]);
        }
        
        return ans;
    }
}