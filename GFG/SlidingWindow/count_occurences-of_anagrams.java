/*
Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.
Your Task:
Complete the function search() which takes two strings pat, txt, as input parameters and returns an integer denoting the answer. You don't to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(26) or O(256)

Constraints:
1 <= |pat| <= |txt| <= 105
Both string contains lowercase english letters.
*/


// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int ans=0;
        int n=txt.length();
        int k=pat.length();
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            if(map.containsKey(pat.charAt(i)))
                map.replace(pat.charAt(i), map.get(pat.charAt(i))+1);
            else
                map.put(pat.charAt(i), 1);
        }
        int count=map.size();
        int i=0, j=0;
        while(j<n){
            if(map.containsKey(txt.charAt(j))){
                map.replace(txt.charAt(j), map.get(txt.charAt(j))-1);
                if(map.get(txt.charAt(j))==0)
                    count--;
            }
            if(j-i+1<k)
                j++;
            else if(j-i+1==k){
                if(count==0)
                    ans++;
                if(map.containsKey(txt.charAt(i))){
                    map.replace(txt.charAt(i), map.get(txt.charAt(i))+1);
                    if(map.get(txt.charAt(i))==1)
                        count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
