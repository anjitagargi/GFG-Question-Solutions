//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        	// Increment array elements by 1
	for (int i = 0; i < n; i++) {
	arr[i] += 1;
	}
	
	
	// result list
	ArrayList<Integer> res = new ArrayList<>();

	// count variable for count of
	// largest element
	int count = 0;

	for (int i = 0; i < n; i++) {

	// Calculate index value
	int index = Math.abs(arr[i]) > n
		? Math.abs(arr[i]) / (n + 1)
		: Math.abs(arr[i]);

	// Check if index equals largest element value
	if (index == n) {
		count++;
		continue;
	}

	// Get element value at index
	int val = arr[index];

	// Check if element value is negative, positive
	// or greater than n
	if (val < 0) {
		res.add(index - 1);
		arr[index] = Math.abs(arr[index]) * (n + 1);
	}
	else if (val > n)
		continue;
	else
		arr[index] = -arr[index];
	}

	// If largest element occurs more than once
	if (count > 1)
	res.add(n - 1);

	if (res.size() == 0)
	res.add(-1);
	else
	Collections.sort(res);

	return res;
    }
}






