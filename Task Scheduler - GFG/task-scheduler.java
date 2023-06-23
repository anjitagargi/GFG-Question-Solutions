//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char a[] = new char[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.next().charAt(0);
            }
            Solution obj = new Solution();
            int ans = obj.leastInterval(n, k, a);
            System.out.println(ans);
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int leastInterval(int N, int K, char tasks[]) {
        // code here
         if (K == 0) {
            return tasks.length;}
        Map<Character, Integer> taskMap = new HashMap<>();
      
        int maxFrequency = 0;
        for (char task : tasks) {
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);
            maxFrequency = Math.max(taskMap.get(task), maxFrequency);
        }

        // number of such max frequency tasks
        int maxFreqTasks = 0;
        for (char task : taskMap.keySet()) {
            if (taskMap.get(task) == maxFrequency) {
                maxFreqTasks++;
            }
        }

        // rest of the tasks
        int nonMaxFreqTasks = tasks.length - (maxFreqTasks * maxFrequency);
        // rest of the distributed tasks on each cycle
        int cycleLength = maxFrequency > 1 ? (nonMaxFreqTasks / (maxFrequency - 1)) : 0;
        // extra tasks distributed to the first few cycles if any
        int remaining = maxFrequency > 1 ? (nonMaxFreqTasks % (maxFrequency - 1)) : 0;

        // total length of each cycle (minus remaining)
        int cycle = maxFreqTasks + cycleLength;
        int idle = 0;
        // distribute idles if needed
        if (cycle + 1 <= K && remaining > 0) {
            idle += ((maxFrequency - 1) * (K - cycle));
        } else if (cycle <= K && remaining == 0) {
            idle += ((maxFrequency - 1) * (K - cycle + 1));
        }
        // add extra idles for the cycles that didn't get the "remaining" tasks
        if (remaining > 0 && cycle <= K) {
            idle += (maxFrequency - 1 - remaining);
        }
        return tasks.length + idle;
    }
}
