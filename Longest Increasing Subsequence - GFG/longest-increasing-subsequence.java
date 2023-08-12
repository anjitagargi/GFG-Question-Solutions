//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends

class Solution {
    static int longestSubsequence(int size, int a[]) {
        List<Integer> lis = new ArrayList<>();
        
        for (int num : a) {
            int index = binarySearch(lis, num);
            if (index == lis.size()) {
                lis.add(num);
            } else {
                lis.set(index, num);
            }
        }
        
        return lis.size();
    }
    
    static int binarySearch(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}
