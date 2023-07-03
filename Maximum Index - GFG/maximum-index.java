//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
         int []rightMax = new int[n];
    rightMax[n-1]= arr[n-1];
    for(int i = n-2; i>=0; i--)
      rightMax[i] = Math.max(rightMax[i+1] , arr[i]);
 
    // rightMax[i] = max{ arr[i...(n-1] }
    int maxDist = Integer.MIN_VALUE;
    int i = 0, j = 0;
    while(i < n && j < n)
    {
      if(rightMax[j] >= arr[i])
      {
        maxDist = Math.max( maxDist, j-i );
        j++;
      }
      else // if(rightMax[j] < leftMin[i])
        i++;
    }
 
    return maxDist;
    
    }
}