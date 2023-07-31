//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a boolean array to mark visited vertices.
        boolean[] visited = new boolean[V];
        
        // Create a queue for BFS.
        Queue<Integer> queue = new LinkedList<>();
        
        // Result list to store the BFS traversal.
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        
        // Mark the starting vertex (0) as visited and enqueue it.
        visited[0] = true;
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            bfsTraversal.add(currentVertex);
            
            // Traverse all the adjacent vertices of the current vertex.
            for (int neighbor : adj.get(currentVertex)) {
                if (!visited[neighbor]) {
                    // Mark the neighbor as visited and enqueue it for further exploration.
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return bfsTraversal;
    }
}
