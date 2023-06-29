//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isDivisible(String s) {
        // code here
       int oddbits = 0, evenbits = 0;
    for (int counter = 0; counter < s.length(); counter++)
    {
       
        // checking if the bit is nonzero
        if (s.charAt(counter) == '1')
        {
           
            // checking if the nonzero bit is at even
            // position
            if (counter % 2 == 0) {
                evenbits++;
            }
            else {
                oddbits++;
            }
        }
    }
            
             if (Math.abs(oddbits - evenbits) % 3 == 0) {
       return 1;
    }
    else {
        return 0;
    }
    
}
}