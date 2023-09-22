//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


import java.util.ArrayList;

class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> result = new ArrayList<>();

        // Find the first occurrence of x
        int firstIndex = binarySearchFirst(arr, n, x);

        // If x is not found, return -1 for both indices
        if (firstIndex == -1) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        // Find the last occurrence of x
        int lastIndex = binarySearchLast(arr, n, x);

        result.add(firstIndex);
        result.add(lastIndex);
        return result;
    }

    // Helper function to find the first occurrence of x using binary search
    private int binarySearchFirst(int arr[], int n, int x)
    {
        int left = 0;
        int right = n - 1;
        int firstIndex = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x)
            {
                firstIndex = mid;
                right = mid - 1; // Continue searching on the left side
            }
            else if (arr[mid] < x)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return firstIndex;
    }

    // Helper function to find the last occurrence of x using binary search
    private int binarySearchLast(int arr[], int n, int x)
    {
        int left = 0;
        int right = n - 1;
        int lastIndex = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x)
            {
                lastIndex = mid;
                left = mid + 1; // Continue searching on the right side
            }
            else if (arr[mid] < x)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return lastIndex;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends