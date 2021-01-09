/*
Given an unsorted integer array nums, find the smallest missing positive integer.

Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

0 <= nums.length <= 300
-231 <= nums[i] <= 231 - 1
*/


class Solution {
    public int firstMissingPositive(int[] nums) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i]-1]){
                int t=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=t;
            }
            else
                i++;
        }
        int ans=1, f=0;
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                ans=j+1;
                f=1;
                break;
            }
        }
        if(f==0)
            return n+1;
        return ans;
    }
}
