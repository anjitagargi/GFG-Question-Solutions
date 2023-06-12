//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends

class Solution {
    
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
         ArrayList<Integer> result = new ArrayList<>();
        if(n==0 || s==0){
              result.add(-1);
        return result;
        }
        int left = 0; 
        int right = 0;
        int sum = 0; 
       

        while (right < n) {
            sum += arr[right];

           
            while (sum > s) {
                sum -= arr[left];
                left++;
            }

            
            if (sum == s) {
                result.add(left + 1); 
                result.add(right + 1);
                return result;
            }

            right++;
        }


        result.add(-1);
        return result;
    }
}
