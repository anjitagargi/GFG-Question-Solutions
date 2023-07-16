//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
 
        for (char ch : A.toCharArray()) {
            if (!map.containsKey(ch)) {
                list.add(ch);
                map.put(ch, 1);
            }
            else {
                  
                int index = list.indexOf(ch);
               

                if (index != -1)
                      list.remove(index);
            }
            sb.append(list.isEmpty() ? '#' : list.get(0));
        }
        return sb.toString();
      
    }
}