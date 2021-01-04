/*
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int i=0, j=0;
        HashMap<Character, Integer> map=new HashMap<>();
        int count=0;
        while(j<n){
            if(map.containsKey(s.charAt(j)))
                map.replace(s.charAt(j), map.get(s.charAt(j))+1);
            else
                map.put(s.charAt(j), 1);
            
            if(map.size()==j-i+1){
                count=Math.max(count, j-i+1);
                j++;
            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    if(map.containsKey(s.charAt(i))){
                        map.replace(s.charAt(i), map.get(s.charAt(i))-1);
                        if(map.get(s.charAt(i))==0)
                            map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return count;
    }
}
