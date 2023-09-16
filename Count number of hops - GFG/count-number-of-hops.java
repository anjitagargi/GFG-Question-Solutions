//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static long countWays(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        int mod = 1000000007;
        long[] ways = new long[n + 1];

        // Initialize base cases
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;

        for (int i = 4; i <= n; i++) {
          
            ways[i] = (ways[i - 1] + ways[i - 2] + ways[i - 3]) % mod;
        }

        return ways[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n)); 
    }
}


