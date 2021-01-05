/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
*/



class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int gr[]=new int[n];
        int gl[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(height[i]);
                gl[i]=-1;
                continue;
            }
            while(!st.isEmpty()){
                if(st.peek()>height[i]){
                    gl[i]=st.peek();
                    break;
                }
                else
                    st.pop();
            }
            if(st.isEmpty()){
                gl[i]=-1;
                st.push(height[i]);
            }
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                st.push(height[i]);
                gr[i]=-1;
                continue;
            }
            while(!st.isEmpty()){
                if(st.peek()>height[i]){
                    gr[i]=st.peek();
                    break;
                }
                else
                    st.pop();
            }
            if(st.isEmpty()){
                gr[i]=-1;
                st.push(height[i]);
            }
        }
        int width[]=new int[n];
        for(int i=0;i<n;i++){
            width[i]=Math.min(gr[i], gl[i]);
            // System.out.print(width[i]+" ");
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(width[i]!=-1){
                ans+=width[i]-height[i];
            }
        }
        // System.out.println();
        return ans;
    }
}
