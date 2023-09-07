//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int level=0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited=new boolean[100001];
        
        queue.offer(start);
        visited[start]=true;
        while (!queue.isEmpty()) {
            
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                
                int current = queue.poll();
                
                if (current == end) {
                    return level;
                }
            
                for (int number : arr) {
                        int newStart = (current * number) % 100000;
                        if(visited[newStart]!=true){
                            queue.offer(newStart);
                            visited[newStart]=true;
                        }
                }
            }
            
            level++;    
        }

        return -1;
    }
}
